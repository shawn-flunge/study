package com.example.webrtcexkotlin

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import org.json.JSONObject
import org.webrtc.*
import org.webrtc.PeerConnection.IceServer
import java.util.*

class MainActivity : AppCompatActivity(),View.OnClickListener, SignalingClient.SignalingInterface {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }





    override fun onClick(v: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onRemoteHangUp(msg: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onOfferReceived(data: JSONObject) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onAnswerReceived(data: JSONObject) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onIceCandidateReceived(data: JSONObject) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTryToStart() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreatedRoom() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onJoinedRoom() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onNewPeerJoined() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
