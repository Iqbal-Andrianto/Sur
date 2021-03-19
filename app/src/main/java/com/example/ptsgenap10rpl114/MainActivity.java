package com.example.ptsgenap10rpl114;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText ituNama;
    private EditText ituPassword;
    private Button ituLogin;
    private TextView ituinfo;

    private final String Username = "Admin";
    private final String Password = "1234";

    boolean isValid = false;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ituNama = findViewById(R.id.iniNama);
        ituPassword = findViewById(R.id.iniPassword);
        ituLogin = findViewById(R.id.btnLogin);
        ituinfo = findViewById(R.id.iniInfo);

        ituLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String inputNama = ituNama.getText().toString();
                String inputPassword = ituPassword.getText().toString();

                if (inputNama.isEmpty() || inputPassword.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Txt Error", Toast.LENGTH_SHORT).show();

                }else{

                    isValid = validate(inputNama, inputPassword);

                    if (!isValid){

                        counter--;

                        Toast.makeText(MainActivity.this, "Incorrect", Toast.LENGTH_SHORT).show();

                        ituinfo.setText("Use your luck, your attempts is :" + counter);

                        if (counter == 0) {
                            ituLogin.setEnabled(false);

                        }


                    }else {

                    Toast.makeText(MainActivity.this, "Log in successfull", Toast.LENGTH_SHORT).show();

                    Intent intent = new  Intent(MainActivity.this, Homepage.class);
                    startActivity(intent);

                }

                }

            }
        });


    }


    private boolean validate(String name, String password){

        String username = "Admin";
        if (name.equals(username) && password.equals(Password)){
            return true;
        }

        return false;

    }

}