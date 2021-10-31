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
        val con1 = st1.toDoubleOrNull()
        val con2 = st2.toDoubleOrNull()
        val con3 = st3.toDoubleOrNull()
        val con4 = st4.toDoubleOrNull()
        if (con1 == null || con2 == null || con3 == null || con4 == null) {
            binding.tipResult.text = "Failed"
            return }else if (con1 != null || con2 != null || con3 != null || con4 != null){ binding.tipResult.text = "Success"}

//heck if the 2 password are same
        val passcheck = binding.password.text.toString()
        val passcheck1 = binding.rePassword.text.toString()
        if(passcheck==passcheck1) binding.tipResult.text = "Success"


    }
}