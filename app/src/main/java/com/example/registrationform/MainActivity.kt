package com.example.registrationform

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.Toast
import com.example.registrationform.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registr.setOnClickListener{check()}
        binding.name.setOnKeyListener { view, keyCode, _ -> handleKeyEvent(view, keyCode)}
        binding.email.setOnKeyListener { view, keyCode, _ -> handleKeyEvent(view, keyCode)}
        binding.password.setOnKeyListener { view, keyCode, _ -> handleKeyEvent(view, keyCode)}
        binding.rePassword.setOnKeyListener { view, keyCode, _ -> handleKeyEvent(view, keyCode)}
        binding.DOB.setOnKeyListener { view, keyCode, _ -> handleKeyEvent(view, keyCode)}



    }

    fun check (){
        val nameVar = binding.name.text.toString()
        val emailVar = binding.email.text.toString()
        val passVar = binding.password.text.toString()
        val repassVar = binding.rePassword.text.toString()
        val dobVar = binding.DOB.text.toString()

        if (nameVar.isNotEmpty() && emailVar.isNotEmpty() && passVar.isNotEmpty() && repassVar.isNotEmpty()){
               if (passVar == repassVar){
                   if (emailVar.contains('@')&& emailVar.contains(".")){
                       binding.tipResult.text=getString(R.string.app_succ)
                   }
                   else { binding.tipResult.text = getString(R.string.emilChS)}
               }
               else { binding.tipResult.text = getString(R.string.passChS) }
        }
        else {
            binding.tipResult.text = getString(R.string.app_fai)
        }

        binding.tipResultInfo.setText("Name : $nameVar \n"+
                                      "Email : $emailVar \n"+
                                      "DOB : $dobVar ")
    }






    private fun handleKeyEvent(view: View, keyCode: Int): Boolean {
        if (keyCode == KeyEvent.KEYCODE_ENTER) {
            // Hide the keyboard
            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            return true
        }
        return false
    }
}