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

   private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registr.setOnClickListener{checkButton()}
        binding.name.setOnKeyListener { view, keyCode, _ -> handleKeyEvent(view, keyCode)}
        binding.email.setOnKeyListener { view, keyCode, _ -> handleKeyEvent(view, keyCode)}
        binding.password.setOnKeyListener { view, keyCode, _ -> handleKeyEvent(view, keyCode)}
        binding.rePassword.setOnKeyListener { view, keyCode, _ -> handleKeyEvent(view, keyCode)}
        binding.DOB.setOnKeyListener { view, keyCode, _ -> handleKeyEvent(view, keyCode)}




    }

    @SuppressLint("SetTextI18n")
    fun checkButton(){

//check if all are not empty
        val st1 = binding.name.text.toString()
        val st2 = binding.email.text.toString()
        val st3 = binding.password.text.toString()
        val st4 = binding.rePassword.text.toString()

        if (st1 == "" || st2 == "" || st3 == "" || st4 == "") {
            binding.tipResult.text = "Failed"
            return }
        else if (st1 != "" || st2 != "" || st3 != "" || st4 != ""){
            binding.tipResult.text = "Success"
            binding.tipResultInfo.text= "Name :${binding.name.text.toString()} \n" +
                    "Email :${binding.email.text.toString()} \n"+
                    "DOB :${binding.DOB.text.toString()} \n"
            return}

//heck if the 2 password are same

        if(st3==st4){
            binding.tipResult.text = "Success"
            return
        }else  {binding.tipResult.text = "Failed"
        return}







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