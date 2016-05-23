package com.playrtc.simplechat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class initialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);

        Button setupBtn = (Button)findViewById(R.id.setup_button);
        setupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Button chatBtn = (Button)findViewById(R.id.chat_button);

        chatBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent chatIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(chatIntent);
            }
        });
    }
}

