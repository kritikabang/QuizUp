package com.coder.quizup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Adminlogin extends AppCompatActivity {
private EditText eadminuname,eadminpass;
private Button btnadminlog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);

        eadminuname=(EditText)findViewById(R.id.editTextadminname);
        eadminpass=(EditText)findViewById(R.id.editTextadminpass);
        btnadminlog=(Button)findViewById(R.id.buttonadminlogin);

        btnadminlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String adminname=eadminuname.getText().toString();
                String adminpas=eadminpass.getText().toString();

                if(adminname.equalsIgnoreCase("admin") && adminpas.equalsIgnoreCase("admin123")){
                    Intent intent=new Intent(Adminlogin.this,Administrator.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Login error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
