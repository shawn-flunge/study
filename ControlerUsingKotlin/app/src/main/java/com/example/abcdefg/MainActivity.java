package com.example.abcdefg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private TextView statusText;
    private Button playBtn;
    private Button recordBtn;

    private String fileName;

    private MediaRecorder mediaRecorder = null;
    private MediaPlayer mediaPlayer=null;

    private static final int REQUEST_RECORD_AUDIO_PERMISSION=200;


       byte[] org.apache.commons.io.FileUtils.readFileToByteArray(File file)
    final String mPath = "/some/directory/picture.png";

    byte[] imageBytes = FileUtils.readFileToByteArray(new File(mPath));


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        boolean permissionToRecordAccepted = false;

        switch (requestCode){
            case REQUEST_RECORD_AUDIO_PERMISSION:
                permissionToRecordAccepted=grantResults[0]==PackageManager.PERMISSION_GRANTED;
                break;
        }
        if(permissionToRecordAccepted ==false)
            finish();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.RECORD_AUDIO},REQUEST_RECORD_AUDIO_PERMISSION);

        //녹음 파일 경로와 파일명 지정
        fileName = getExternalCacheDir().getAbsolutePath() + "/record.3gp";

        statusText=(TextView)findViewById(R.id.statusText);
        playBtn=(Button)findViewById(R.id.playBtn);
        recordBtn=(Button)findViewById(R.id.recordBtn);

//        recordBtn.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                if(mediaRecorder ==null)
//                    startRecording();
//                else
//                    stopRecording();
//            }
//        });

        if(mediaRecorder ==null)
            startRecording();
        else
            stopRecording();





        recordBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(mediaRecorder !=null)
                    stopRecording();
                else
                    startRecording();
            }
        });


        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer ==null)
                    startPlaying();
                else
                    stopPlaying();
            }
        });


    }

    private void startRecording(){
        statusText.setText("녹음중");
        recordBtn.setText("녹음 중지");

        mediaRecorder = new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setOutputFile(fileName);
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        try{
            mediaRecorder.prepare();
        }catch (IOException e){
            e.printStackTrace();

            Toast.makeText(this,"녹음실패",Toast.LENGTH_SHORT).show();
            statusText.setText("대기상태");
            recordBtn.setText("녹음시작");
            mediaRecorder = null;

        }
        mediaRecorder.start();

    }

    private void stopRecording(){
        statusText.setText("대기상태");
        recordBtn.setText("녹음시작");

        if(mediaRecorder!=null){
            mediaRecorder.stop();
            mediaRecorder.release();
            mediaRecorder=null;
        }
    }

    private void startPlaying(){

        statusText.setText("재생중");
        playBtn.setText("재생중지");

        mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopPlaying();
            }
        });

        try {
            mediaPlayer.setDataSource(fileName);
            mediaPlayer.prepare();
            mediaPlayer.start();
        }catch (IOException e){
            e.printStackTrace();
            Toast.makeText(this,"재생실패",Toast.LENGTH_SHORT).show();
            statusText.setText("대기상태");
            playBtn.setText("재생시작");
            mediaPlayer = null;
        }

    }

    private void stopPlaying(){
        statusText.setText("대기상태");
        playBtn.setText("재생시작");
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer=null;
        }
    }

    public void abcd()throws IOException{
        final File initialFile = new File(fileName);
        final InputStream inputStream = new DataInputStream(new FileInputStream(initialFile));

        byte[] tt = new byte[inputStream.available()];

    }

}

