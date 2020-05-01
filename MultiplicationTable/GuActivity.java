package com.example.homework;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class GuActivity extends AppCompatActivity {

    private TextView questText;
    private TextView numText;
    private EditText inputText;
    private ProgressBar progressBar;

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btn0;
    private Button btnCancel;
    private Button btnEnter;

    private static final Random RANDOM = new Random();
    static Editable editable;
    static int n1;
    static int n2;
    static int count;
    static String questStr;

    static Intent intent = new Intent();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gugu);

        intent = getIntent();

        questText = findViewById(R.id.questText);
        numText = findViewById(R.id.numText);
        inputText = findViewById(R.id.inputText);
        progressBar = findViewById(R.id.progressBar);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnCancel = findViewById(R.id.btnCancel);
        btnEnter = findViewById(R.id.btnEnter);

        count=0;
        numText.setText(String.valueOf(count));
        setNum();

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickNumber(0);

            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickNumber(1);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickNumber(2);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickNumber(3);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickNumber(4);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickNumber(5);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickNumber(6);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickNumber(7);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickNumber(8);
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickNumber(9);
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText("");
            }
        });
        
        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    editable = inputText.getText();
                    String str = editable.toString();
                    int i = Integer.parseInt(str);

                    String str2;
                    if( i==(n1*n2) )
                    {
                        count++;
                        Toast.makeText(getApplicationContext(),"딩동댕", Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(getApplicationContext(),"땡", Toast.LENGTH_SHORT).show();

                    str2= String.valueOf(count);
                    numText.setText(str2);
                    setNum();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "숫자를 입력하세요", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

        Thread t1 = new Thread(new Runnable() {
            int sec=0;
            String str;
            @Override
            public void run() {
                while (true)
                {
                    sec++;
                    try {
                        Thread.sleep(1000);
                    }
                    catch (Exception e) {}
                    progressBar.setProgress(sec);
                    if(sec ==60)
                        break;
                }
                str = String.valueOf(count);
                intent.putExtra("correctCount",str);
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        t1.start();

    }


    public void clickNumber(int n)
    {
        editable = inputText.getText();
        String temp = editable.toString();

        String str = String.valueOf(n);
        temp = temp + str;
        inputText.setText(temp);
    }

    public void setNum(){
        questText.setText(null);
        inputText.setText(null);
        n1=(RANDOM.nextInt(9)+1);
        n2=(RANDOM.nextInt(9)+1);

        questStr = n1 +" * " +n2;
        questText.setText(questStr);
    }



}
