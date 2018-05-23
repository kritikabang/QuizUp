package com.coder.quizup;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
private EditText ename,eemail,epass,ephone;
private Button breg2;
SQLiteOpenHelper openHelper;
SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ename=(EditText)findViewById(R.id.editTextname);
        eemail=(EditText)findViewById(R.id.editTextemail);
        epass=(EditText)findViewById(R.id.editTextpass);
        ephone=(EditText)findViewById(R.id.editTextphone);
        breg2=(Button)findViewById(R.id.buttonreg2);

        openHelper=new dbHelper(this);
        breg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db=openHelper.getWritableDatabase();
                String name=ename.getText().toString();
                String passw=epass.getText().toString();
                String email=eemail.getText().toString();
                String pphone=ephone.getText().toString();
                insertdata(name,email,passw,pphone);
                Toast.makeText(getApplicationContext(), "Registered Successfully",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(Register.this,Login.class);
                startActivity(intent);
            }
        });
    }

    public void insertdata(String nm, String email, String pass, String phone){
        ContentValues contentValues = new ContentValues();
        contentValues.put(dbHelper.COL_2, nm);
        contentValues.put(dbHelper.COL_3, email);
        contentValues.put(dbHelper.COL_4, pass);
        contentValues.put(dbHelper.COL_5, phone);
        long id = db.insert(dbHelper.TABLE_NAME,null, contentValues);
    }
}
