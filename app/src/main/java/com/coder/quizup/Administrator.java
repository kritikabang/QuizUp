package com.coder.quizup;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import static com.coder.quizup.dbHelper.TABLE_NAME;
import static com.coder.quizup.dbHelper2.TABLE_NAME2;

public class Administrator extends AppCompatActivity {
    Button btnviewuser,btnviewscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator);
        btnviewuser=(Button) findViewById(R.id.buttonviewusers);
        btnviewscore=(Button)findViewById(R.id.buttonviewscore);

        btnviewuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> arr=new ArrayList<>();
                arr=getAllRecords();

                //ArrayAdapter<Regis> adapter= new ArrayAdapter<Regis>(Main2Activity.this,android.R.layout.simple_list_item_1,arr);
                ArrayAdapter<String> adapter= new ArrayAdapter<String>(Administrator.this,android.R.layout.simple_list_item_1,arr);
                ListView lv=(ListView)findViewById(R.id.listview);
                lv.setAdapter(adapter);
            }

        });

        btnviewscore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> arr2=new ArrayList<>();
                arr2=getAllRecords2();

                ArrayAdapter<String> adapter2= new ArrayAdapter<String>(Administrator.this,android.R.layout.simple_list_item_1,arr2);
                ListView lv2=(ListView)findViewById(R.id.listview);
                lv2.setAdapter(adapter2);
            }
        });

    }

    public ArrayList<String> getAllRecords() {
        dbHelper db=new dbHelper(this);
        SQLiteDatabase database = db.getReadableDatabase();
        Cursor cursor = database.query(TABLE_NAME, null, null, null, null, null, null);
        //ArrayList<Regis> contacts = new ArrayList<Regis>();
        ArrayList<String> contacts = new ArrayList<String>();
        //Regis contactModel;
        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
//                contactModel = new Regis();
//                contactModel.setID(cursor.getString(0));
//
//                contactModel.setFirstName(cursor.getString(1));
//                Toast.makeText(this,cursor.getString(1),Toast.LENGTH_SHORT).show();
//                contactModel.setLastName(cursor.getString(2));
                //contacts.add(contactModel);
                contacts.add(i,cursor.getString(0)+" "+ cursor.getString(1) + " "  + cursor.getString(3)+ " " + cursor.getString(4));
            }
        }
        cursor.close();
        database.close();
        return contacts;
    }

    public ArrayList<String> getAllRecords2(){
        dbHelper2 db2=new dbHelper2(this);
        SQLiteDatabase database2= db2.getReadableDatabase();
        Cursor cursor2=database2.query(TABLE_NAME2,null,null,null,null,null,null);
        ArrayList<String> contacts2=new ArrayList<String>();

        if(cursor2.getCount()>0){
            for(int i=0;i<cursor2.getCount();i++){
                cursor2.moveToNext();
                contacts2.add(i,cursor2.getString(0)+ " " + cursor2.getString(1) + " " + cursor2.getString(2));
            }
        }
        cursor2.close();
        database2.close();
        return contacts2;
    }
}
