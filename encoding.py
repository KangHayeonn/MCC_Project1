import cv2
import face_recognition
import pickle
from google.colab import files
import os

## parameter 설정 ###
model_method = 'cnn'
knownEncodings = []
knownNames = []
names = []
file_list = os.listdir()
id = []
for i in file_list:
  if '.jpg' in i:
    id.append(i[:-5])
    names = list(set(id))
id_count = len(names)
number_images = int(len(id) / id_count)
print(id,id_count,number_images,end='\n')

image_type = '.jpg'
#encoding_file = 'encodings.pickle'#output file
encoding_file = 'encodings.json'#output file
model_method = 'cnn'

knownEncodings = []
knownNames = []
for i in range(id_count):
    name = names[i]

    for idx in range(number_images):
        file_name = name + str(idx+1) + image_type
        image = cv2.imread(file_name)
        rgb = cv2.cvtColor(image, cv2.COLOR_BGR2RGB)#opencv는 BGR 쓰지만 우리는 RGB 쓴다.


        boxes = face_recognition.face_locations(rgb, model=model_method)
        encodings = face_recognition.face_encodings(rgb, boxes,num_jitters=10,model='large')
        # num_jitters : 몇번 반복해서 뽑는가 높을수록 accuracy 올라감
        for encoding in encodings:
          encoding = list(encoding)
          print(file_name, name, encoding)
          knownEncodings.append(encoding)
          knownNames.append(name)

data = {"encodings": knownEncodings, "names": knownNames}

with open(encoding_file, 'w', encoding='utf-8') as f:
    json.dump(data,f)
files.download(encoding_file)


'''
#####pickle#####
with open(encoding_file, 'wb') as f:
  f.write(pickle.dumps(data))
'''