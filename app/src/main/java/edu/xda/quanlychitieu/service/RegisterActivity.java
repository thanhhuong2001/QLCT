package edu.xda.quanlychitieu.service;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import edu.xda.quanlychitieu.R;
import edu.xda.quanlychitieu.data.MyDatabaseHelper;


public class RegisterActivity extends AppCompatActivity {

    EditText username, password;
    Button btnSave;
    MyDatabaseHelper db;

    private void init() {
        username = findViewById(R.id.edUsername);
        password = findViewById(R.id.edPassword);
        btnSave = findViewById(R.id.btnRegister);
        db = new MyDatabaseHelper(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String us = username.getText().toString();
                String pass = password.getText().toString();
                if(username.equals("") || password.equals("") || us.isEmpty() || pass.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Phai dien day du thong tin", Toast.LENGTH_SHORT).show();
                }else {
                    Boolean checkus = db.checkUsername(us);
                    if(checkus == true){
                        Boolean insert = db.insert(us, pass);
                        if(insert == true) {
                            Toast.makeText(getApplicationContext(), "Dang ki thanh cong", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                        }
                    }else{
                        Toast.makeText(getApplicationContext(), "Email da duoc su dung", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }




}
