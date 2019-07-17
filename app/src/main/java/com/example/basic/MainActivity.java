package com.example.basic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button signin,learn,join;
    EditText email,pass;
    String stremail,strpass;
    DatabaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("create","before super");
        super.onCreate(savedInstanceState);
        Log.d("create","before set");
        setContentView(R.layout.activity_main);
        Log.d("create","before construct");
        //creating mydbhelper object
        mydb = new DatabaseHelper(this);

        //Buttons
        signin = findViewById(R.id.login);
        learn = findViewById(R.id.learn);
        join = findViewById(R.id.join);

        // Edit Text
        email = findViewById(R.id.email);
        pass = findViewById(R.id.password);

        // set listener on each button
        signin.setOnClickListener(this);
        learn.setOnClickListener(this);
        join.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){
            // trying to login
            case R.id.login:
                stremail = email.getText().toString();
                strpass = pass.getText().toString();

                Cursor res = mydb.getDataOnEmail(stremail);
                System.out.println(res.getCount());
                if(res.getCount()==0){
                    Toast.makeText(this,"Sorry no account found",Toast.LENGTH_SHORT).show();
                }
                else{
                    while(res.moveToNext()) {
                        if (res.getString(4).equals(strpass)) {
                            Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT);
                            Intent home = new Intent(MainActivity.this, Home.class);
                            startActivity(home);
                        } else {
                            Toast.makeText(this, "password doesnt match", Toast.LENGTH_SHORT);
                        }
                    }
                }

                break;
            case R.id.learn:
                Intent i = new Intent(MainActivity.this,LearnMore.class);
                startActivity(i);
                break;
            case R.id.join:
                Intent intent = new Intent(MainActivity.this,Register.class);
                startActivity(intent);
                break;
        }

    }

}
