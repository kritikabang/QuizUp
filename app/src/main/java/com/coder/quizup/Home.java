package com.coder.quizup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {
private Button btnquiz,btnscore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnquiz=(Button)findViewById(R.id.buttonquiz);
        btnscore=(Button)findViewById(R.id.buttonscore);

        btnquiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Home.this,Quiz.class);
                startActivity(intent);
            }
        });
    }
}
