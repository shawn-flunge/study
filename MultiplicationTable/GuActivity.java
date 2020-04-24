package com.example.homework;

import android.content.DialogInterface;
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

import javax.xml.datatype.Duration;

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
    static int count = 0;
    static String questStr;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gugu);

        Intent intent = getIntent();

        questText = (TextView)findViewById(R.id.questText);
        numText = (TextView)findViewById(R.id.numText);
        inputText = (EditText)findViewById(R.id.inputText);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);

        btn0 = (Button)findViewById(R.id.btn0);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);
        btn6 = (Button)findViewById(R.id.btn6);
        btn7 = (Button)findViewById(R.id.btn7);
        btn8 = (Button)findViewById(R.id.btn8);
        btn9 = (Button)findViewById(R.id.btn9);
        btnCancel = (Button)findViewById(R.id.btnCancel);
        btnEnter = (Button)findViewById(R.id.btnEnter);





        n1=RANDOM.nextInt();
        n2=RANDOM.nextInt();
        questStr = n1 +" * " +n2;

        questText.setText(questStr);



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
                inputText.setText(null);
            }
        });

        btnEnter.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                editable = inputText.getText();

                if(Integer.valueOf(editable.toString())== (n1*n2) )
                {
                    count++;
                    Toast.makeText(getApplicationContext(),"딩동댕", Toast.LENGTH_SHORT);
                }
                else
                    Toast.makeText(getApplicationContext(),"땡", Toast.LENGTH_SHORT);

                numText.setText(count);
                resetObj();
            }
        });

        Thread t1 = new Thread(new Runnable() {
            int sec=0;
            @Override
            public void run() {
                while (sec < 61)
                    sec++;
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
                progressBar.setProgress(sec);
            }
        });

        t1.start();
        if(progressBar.getProgress()==60)
        {
            intent.putExtra("correctCount",count);
            setResult(1,intent);
            finish();
        }

    }


    public void clickNumber(int n)
    {
        inputText.setText(n);
    }

    public void resetObj()
    {
        questText.setText("");
        inputText.setText("");
        n1=RANDOM.nextInt();
        n2=RANDOM.nextInt();
        questStr = n1 +" * " +n2;

        questText.setText(questStr);
    }


}
