package com.example.frame

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var fab_open: Animation? = null
    var fab_close:Animation? = null
    var isFabOpen = false
    var fab: FloatingActionButton? = null
    var fab1:FloatingActionButton? = null
    var fab2:FloatingActionButton? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab_open = AnimationUtils.loadAnimation(applicationContext,R.anim.fab_open)
        fab_close = AnimationUtils.loadAnimation(applicationContext,R.anim.fab_close)

//        fab = floatBtn
//        fab1 = floatBtn2
//        fab2 = floatBtn3

        floatBtn.setOnClickListener(View.OnClickListener {
            anim()
            Toast.makeText(this,"main Button",Toast.LENGTH_SHORT).show()
        })
        floatBtn2.setOnClickListener(View.OnClickListener {
            anim()
            Toast.makeText(this,"1st Button",Toast.LENGTH_SHORT).show()
        })
        floatBtn3.setOnClickListener(View.OnClickListener {
            anim()
            Toast.makeText(this,"2nd Button",Toast.LENGTH_SHORT).show()
        })


        startDrawBtn.setOnClickListener {
            val intent = Intent(this,DrawerActivity::class.java)
            intent.putExtra("string","sfdsafd")
            startActivity(intent)
        }


    }

    fun anim(){
        if(isFabOpen){
            floatBtn2.startAnimation(fab_close)
            floatBtn3.startAnimation(fab_close)
            floatBtn2.isClickable = true
            floatBtn3.isClickable = true
            isFabOpen=false
        }
        else{
            floatBtn2.startAnimation(fab_open)
            floatBtn3.startAnimation(fab_open)
            floatBtn2.isClickable = false
            floatBtn3.isClickable = false
            isFabOpen=true
        }
    }


}
