package com.example.homework;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button startBtn;
    private TextView ans1;
    private ListView listView;

    static Intent intent;

    static ArrayList<String> arrList;
    static ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBtn = (Button)findViewById(R.id.startBtn);
        listView = findViewById(R.id.listView);

        arrList= new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, arrList);
        listView.setAdapter(adapter);

        startBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(),GuActivity.class);
                startActivityForResult(intent,1);
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
                //String str = data.getExtras().getString("correctCount");
                //Toast.makeText(getApplicationContext(),str,Toast.LENGTH_SHORT).show();
                arrList.add(data.getExtras().getString("correctCount"));
                adapter.notifyDataSetChanged();
            }
        }
    }
}
