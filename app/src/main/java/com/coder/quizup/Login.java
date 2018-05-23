package com.coder.quizup;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
private EditText elogname,elogpass;
private Button btnmainlog;
SQLiteDatabase db;
SQLiteOpenHelper openHelper;
Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        elogname=(EditText)findViewById(R.id.editTextlogname);
        elogpass=(EditText)findViewById(R.id.editTextlogpass);
        btnmainlog=(Button)findViewById(R.id.buttonmainlog);

        openHelper=new dbHelper(this);
        db = openHelper.getReadableDatabase();

        btnmainlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = elogname.getText().toString();
                String pass = elogpass.getText().toString();

                cursor = db.rawQuery(String.format("SELECT *FROM %s WHERE %s=? AND %s=?", dbHelper.TABLE_NAME, dbHelper.COL_2, dbHelper.COL_4), new String[]{uname, pass});
                if (cursor != null) {
                    if (cursor.getCount() > 0) {
                        Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Login.this,Home.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Login error", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
