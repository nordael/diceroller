package com.example.android.aboutme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit  var hiddenName : TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val  clickMe : Button = findViewById(R.id.done_button)
        hiddenName = findViewById(R.id.textHidden)

        clickMe.setOnClickListener {
            showSecret()
        }

    }

    private fun showSecret(){

        var inputNickname : EditText = findViewById(R.id.nickname_edit)
        var nickname = "Tarik"

        if ( inputNickname.text.toString() == nickname){
            hiddenName.text = "Wowww"
        }else{
            hiddenName.text = "try again!"
        }

        //view.visibility = View.VISIBLE
        hiddenName.visibility = View.VISIBLE

        Handler(Looper.getMainLooper()).postDelayed({
            hiddenName.visibility = View.GONE
        }, 2000)


    }
}