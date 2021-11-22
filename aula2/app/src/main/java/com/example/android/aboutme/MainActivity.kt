package com.example.android.aboutme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.android.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val hid : MyName = MyName("Tarik" )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myText = hid

        //val  clickMe : Button = findViewById(R.id.done_button)
        binding.doneButton.setOnClickListener {
            showSecret()
        }

    }

    private fun showSecret(){

        var nickname = "Tarik"

        binding.invalidateAll()
        if (  binding.nicknameEdit.text.toString() == nickname){
            binding.myText?.hidden = "Wowww"
            //binding.textHidden.text = "Wowww"
        }else{
            binding.myText?.hidden = "try again!"
            //binding.textHidden.text = "try again!"
        }

        //view.visibility = View.VISIBLE
        binding.textHidden.visibility = View.VISIBLE

        Handler(Looper.getMainLooper()).postDelayed({
            binding.textHidden.visibility = View.GONE
        }, 2000)


    }
}