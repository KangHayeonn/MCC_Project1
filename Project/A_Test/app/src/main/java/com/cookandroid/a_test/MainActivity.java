package com.cookandroid.a_test;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends Activity {
    String ID;
    String Name;
    String Num;
    String Subj;

    Button btn;
    Button btn1;
    Button btn2;
    EditText ETID;
    EditText ETPW;
    EditText ETPW2;
    EditText ETname;
    EditText ETnum;
    EditText ETsubj;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.Button);
        btn1 = (Button) findViewById(R.id.Button1);
        btn2 = (Button) findViewById(R.id.Button2);
        ETID = (EditText) findViewById(R.id.editTextID);
        ETPW = (EditText) findViewById(R.id.editTextPW);
        ETPW2 = (EditText) findViewById(R.id.editTextPW2);
        ETname = (EditText) findViewById(R.id.editTextname);
        ETnum = (EditText) findViewById(R.id.editTextnum);
        ETsubj = (EditText) findViewById(R.id.editTextdep);
    }
    /*
    public void ClickButton(View view){
        Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
    }*/

    /*
    public void ClickButton1(View view){
        String EID = ETID.getText().toString();
        if (ID == EID){
            Toast.makeText(getApplicationContext(),"중복되는 ID입니다.",Toast.LENGTH_LONG).show();
        }
    }*/


    public void ClickButton2(View view){
        String EID = ETID.getText().toString();
        String EPW = ETPW.getText().toString();
        String EPW2 = ETPW2.getText().toString();
        String Ename = ETname.getText().toString();
        String Enum = ETnum.getText().toString();
        String Edep = ETsubj.getText().toString();

         if(EPW != EPW2){
            Toast.makeText(getApplicationContext(),"비밀번호를 확인하세요",Toast.LENGTH_LONG).show();
        }

        /*
        if (ID == EID){
            Toast.makeText(getApplicationContext(),"중복되는 ID입니다.",Toast.LENGTH_LONG).show();
        }
        else if(EPW != EPW2){
            Toast.makeText(getApplicationContext(),"비밀번호를 확인하세요",Toast.LENGTH_LONG).show();
        }
        else if (Name != Ename){
            Toast.makeText(getApplicationContext(),"일치하지 않는 이름입니다.",Toast.LENGTH_LONG).show();
        }
        else if (Num != Enum){
            Toast.makeText(getApplicationContext(),"일치하지 않는 학번입니다.",Toast.LENGTH_LONG).show();
        }
        else if (Subj != Edep){
            Toast.makeText(getApplicationContext(),"일치하지 않는 학과입니다.",Toast.LENGTH_LONG).show();
        }

        else{
            Intent intent = new Intent(getApplicationContext(),AgreeActivity.class);
        }
        */

    }
}