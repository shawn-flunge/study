package com.example.drawmap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnToMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        btnToMap = (Button)findViewById(R.id.btnToMap);

        btnToMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "화면전환 " , Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), mapping.class);
                startActivity(intent);
            }
        });



    }
}
