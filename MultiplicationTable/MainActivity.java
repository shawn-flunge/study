package com.example.homework;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button startBtn;
    private TextView ans1;

    static Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBtn = (Button)findViewById(R.id.startBtn);
        ans1 = (TextView)findViewById(R.id.ans1);

        startBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(),GuActivity.class);
                startActivityForResult(intent,1);
                //startActivity(intent);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1)
        {

            if(resultCode==Activity.RESULT_OK)
            {
                String str = data.getExtras().getString("correctCount");
                Toast.makeText(getApplicationContext(),str,Toast.LENGTH_SHORT).show();
                ans1.setText(str);
            }
            
        }

    }


}
