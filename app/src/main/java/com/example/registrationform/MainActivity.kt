package com.example.registrationform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.registrationform.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

   private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registr.setOnClickListener{checkButton()}
    }

    fun checkButton(){

//check if all are not empty
        val st1 = binding.name.text.toString()
        val st2 = binding.email.text.toString()
        val st3 = binding.password.text.toString()
        val st4 = binding.rePassword.text.toString()

        if (st1 == "" || st2 == "" || st3 == "" || st4 == "") {
            binding.tipResult.text = "Failed"
            return }
        else if (st1 != "" || st2 != "" || st3 != "" || st4 != ""){ binding.tipResult.text = "Success"
            return}

//heck if the 2 password are same

        if(st3==st4){
            binding.tipResult.text = "Success"
            return
        }else  binding.tipResult.text = "Failed"
//display the information

  binding.tipResultInfo.setText("Name :${binding.name.text.toString()} \n" +
          "Email :${binding.email.text.toString()} \n"+
          "DOB :${binding.email.text.toString()}")



    }
}