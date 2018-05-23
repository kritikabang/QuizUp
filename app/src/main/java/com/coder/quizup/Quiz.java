package com.coder.quizup;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Quiz extends AppCompatActivity {
private EditText eans1,eans2,eans3,ename;
private Button btnsubmit;
private TextView txtscore;
private String count;
SQLiteOpenHelper openHelper;
SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        ename=(EditText)findViewById(R.id.editTextscorername);
        eans1=(EditText)findViewById(R.id.editTextoption1);
        eans2=(EditText)findViewById(R.id.editTextoption2);
        eans3=(EditText)findViewById(R.id.editTextoption3);
        btnsubmit=(Button)findViewById(R.id.buttonsubmit);
        txtscore=(TextView)findViewById(R.id.textViewscore);
        count="";

        openHelper=new dbHelper2(this);

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db=openHelper.getWritableDatabase();
                String ans1=eans1.getText().toString();
                String ans2=eans2.getText().toString();
                String ans3=eans3.getText().toString();
                String name=ename.getText().toString();

                if(ans1.equalsIgnoreCase("Dennis Ritchie") && ans2.equalsIgnoreCase("James Gosling") && ans3.equalsIgnoreCase("1995")){
                    count ="3";
                }
                else if((ans1.equalsIgnoreCase("Dennis Ritchie") && ans2.equalsIgnoreCase("James Gosling")) || (ans1.equalsIgnoreCase("Dennis Ritchie") && ans3.equalsIgnoreCase("1995")) || (ans2.equalsIgnoreCase("James Gosling") && ans3.equalsIgnoreCase("1995"))){
                    count ="2";
                }
                else if((ans1.equalsIgnoreCase("Dennis Ritchie")) || (ans2.equalsIgnoreCase("James Gosling")) || ans3.equalsIgnoreCase("1995")){
                    count="1";
                }
                else{
                    count="0";
                }
                txtscore.setText("Result = " + count);
                insert(name,count);
            }
        });

    }

    public void insert(String nm,String c){
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put(dbHelper2.COLO_2,nm);
        contentValues2.put(dbHelper2.COLO_3, c);
        long id2 = db.insert(dbHelper2.TABLE_NAME2,null, contentValues2);
    }
}
