package com.example.basic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Register extends AppCompatActivity implements View.OnClickListener {

    EditText name,password,CPassword,email,phone;
    Spinner gender;
    Button register;

    DatabaseHelper db;

    String pass,cpass,strname,stremail,strphone,strgen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DatabaseHelper(this);

        // connecting variables with widgets
        name = findViewById(R.id.name);
        password = findViewById(R.id.password);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        CPassword = findViewById(R.id.confirmPassword);
        gender = findViewById(R.id.gender);

        register = findViewById(R.id.register);

        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        pass = password.getText().toString();
        if(pass.equals(CPassword.getText().toString())){
            strname = name.getText().toString();
            stremail = email.getText().toString();
            strphone = phone.getText().toString();
            strgen = gender.getSelectedItem().toString();

            db.insertData(strname,strphone,stremail,pass,strgen);

            Toast.makeText(this,"Registered Successfully",Toast.LENGTH_SHORT).show();

        }
        else{
            Toast.makeText(this,"Password doesn't match",Toast.LENGTH_SHORT).show();
        }

    }
}
