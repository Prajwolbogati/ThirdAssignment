package com.example.thirdassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnlogin;
    private EditText etusername, etpassword;
    private String username, password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etusername = findViewById(R.id.username);
        etpassword = findViewById(R.id.password);
        btnlogin = findViewById(R.id.btnlogin);

        btnlogin.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btnlogin) {
            username = etusername.getText().toString();
            password = etpassword.getText().toString();
            if(checkvalidate()) {

                if(username.equals("softwarica") && password.equals("coventry")) {
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(this, "Either username or Password is incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        }

    }

    private boolean checkvalidate(){
        if(TextUtils.isEmpty(username))
        {
            etusername.setError("Please enter a username");
            etusername.requestFocus();
            return false;
        }
        if(TextUtils.isEmpty(password))
        {
            etpassword.setError("Please enter password");
            etpassword.requestFocus();
            return false;
        }


        return  true;
    }
}
