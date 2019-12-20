package com.example.androidmobilemapepsi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class TestActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        val x1 = intent.getIntExtra("X1_COORD",0)
        setContentView(R.layout.activity_test)
        //calculDistance(x1,x2,y1,y2)
    }

    fun calculDistance(x1:Int,x2:Int,y1:Int,y2:Int){

    }

}

