package com.cookandroid.a_main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnstudentID = (Button) findViewById(R.id.studentID);
        Button btnsKey = (Button) findViewById(R.id.Key);
        Button btnTicket = (Button) findViewById(R.id.Ticket);
        Button btnLibrary = (Button) findViewById(R.id.Library);
        Button btnLMS = (Button) findViewById(R.id.LMS);
        Button btnNotice = (Button) findViewById(R.id.Notice);
        Button btnHomepage = (Button) findViewById(R.id.Homepage);
        Button btnMap = (Button) findViewById(R.id.Map);

        btnNotice.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.mju.ac.kr/mjukr/255/subview.do");
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });

        btnHomepage.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.mju.ac.kr/mjukr/index.do");
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });
    }


}