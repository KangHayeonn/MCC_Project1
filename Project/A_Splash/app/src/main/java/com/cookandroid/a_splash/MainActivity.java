package com.cookandroid.a_splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private boolean saveLoginDate;
    private String id;
    private String pwd;
    private EditText idET;
    private EditText password;
    private Button login;
    private CheckBox saveCB;
    private CheckBox keep;
    private SharedPreferences appDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        appDate = getSharedPreferences("appDate", MODE_PRIVATE);
        load();
        idET = (EditText) findViewById((R.id.idET));
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        saveCB = (CheckBox) findViewById(R.id.saveCB);
        keep = (CheckBox) findViewById(R.id.keep);
        if (saveLoginDate) {
            idET.setText(id);
            password.setText(pwd);
            keep.setChecked(saveLoginDate);
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
                Intent intent = new Intent(getApplicationContext(),MainmenuActivity.class);

                startActivity(intent);
            }
        });
    }
    private void save() {
        SharedPreferences.Editor editor = appDate.edit();

        editor.putBoolean("SAVE_LOGIN_DATA", keep.isChecked());
        editor.putString("ID", idET.getText().toString().trim());
        editor.putString("PWD", password.getText().toString().trim());
        editor.apply();}

    private void load() {
        saveLoginDate = appDate.getBoolean("SAVE_LOGIN_DATA", false);
        id = appDate.getString("ID", "");
        pwd = appDate.getString("PWD", "");
    }


}