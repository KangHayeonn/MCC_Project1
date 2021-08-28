import cv2
import numpy as np
import face_recognition
import pickle
import time
faceCascade = cv2.CascadeClassifier("haarcascade_frontalface_default.xml")
if not faceCascade.load(cv2.samples.findFile("haarcascade_frontalface_default.xml")):
    print('--(!)Error loading face cascade')
    exit(0)

#encoding_file = 'encodings.pickle'
encoding_file = 'encodings.json'
#data = pickle.loads(open(encoding_file, "rb").read())

with open(encoding_file, 'r') as f:
    data = json.load(f)

unknown_name = 'Unknown'
recognized_name = None
frame_count = 0
frame_interval = 8

frame_width = 640
frame_height = 480
frame_resolution = [frame_width, frame_height]
frame_rate = 16
video_capture = cv2.VideoCapture(0)

while True:
    # Capture frame-by-frame
    ret, frame = video_capture.read()
    start_time = time.time()
    
    gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
    rgb = cv2.cvtColor(frame, cv2.COLOR_BGR2RGB)

    faces = faceCascade.detectMultiScale(gray)

    rois = [(y, x + w, y + h, x) for (x, y, w, h) in faces]

    encodings = face_recognition.face_encodings(rgb, rois)

    # 다시 names 초기화
    names = []

    # loop over the facial embeddings
    for encoding in encodings:
        # attempt to match each face in the input image to our known
        # encodings
        matches = face_recognition.compare_faces(np.array(data["encodings"]),encoding,tolerance = 0.5)
        name = unknown_name

        # check to see if we have found a match
        if True in matches:
            matchedIdxs = [i for (i, b) in enumerate(matches) if b]
            counts = {}


            for i in matchedIdxs:
                name = data["names"][i]
                counts[name] = counts.get(name, 0) + 1

            name = max(counts, key=counts.get)
        
        # update the list of names
        names.append(name)

    # loop over the recognized faces
    for ((top, right, bottom, left), name) in zip(rois, names):
        # draw the predicted face name on the image
        y = top - 15 if top - 15 > 15 else top + 15
        color = (0, 255, 0)
        line = 2
        if(name == unknown_name):
            color = (0, 0, 255)
            line = 1
            
        if(name != recognized_name):
            recognized_name = name
            
        cv2.rectangle(frame, (left, top), (right, bottom), color, line)
        y = top - 15 if top - 15 > 15 else top + 15
        cv2.putText(frame, name, (left, y), cv2.FONT_HERSHEY_SIMPLEX,0.75, color, line)
                
    end_time = time.time()
    process_time = end_time - start_time
    print("=== A frame took {:.3f} seconds".format(process_time))
    # show the output image
    cv2.imshow('Video', frame)

    
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

# When everything is done, release the capture
video_capture.release()
cv2.destroyAllWindows()
print(names)