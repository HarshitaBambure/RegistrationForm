package com.example.registrationform

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var username = " "
        var fullname = " "
        var country = " "
        var email = " "
        var phone = " "
        var gender = " "
        username = txtInput_user.text.toString()

    txt_phone.doOnTextChanged { text, start, before, count ->
        if (text!!.length>10){
            txtLay_phone.error="No more!"
        }else if (text.length<10){
            txtLay_phone.error=null
        }
    }

        txt_email.doOnTextChanged { text, start, before, count ->
            if (text!!.length>40){
                txtLay_phone.error="No more!"
            }else if (text.length<40){
                txtLay_phone.error=null
            }
        }

        btn_createAccount.setOnClickListener {
            username = txtInput_user.text.toString()
            Toast.makeText(applicationContext, username, Toast.LENGTH_SHORT).show()
            fullname = txt_fullname.text.toString()
            country = autoCompleteTextView.text.toString()
            email = txt_email.text.toString()
            phone = txt_phone.text.toString()

            var genderId = radioGroup.checkedRadioButtonId
            if (genderId != -1){
                val selected_gender: RadioButton = findViewById(genderId)
                gender = selected_gender.text.toString()
            }

            var intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("Referusername", username)
                putExtra("Referfullname", fullname)
                putExtra("Refercountry", country)
                putExtra("Referemail", email)
                putExtra("Referphone", phone)
                putExtra("Refergender", gender)
            }
            startActivity(intent)
        }
}

    override fun onResume() {
        super.onResume()
        val country= resources.getStringArray(R.array.Country)
        val arrayAdapter = ArrayAdapter(this,R.layout.dropdown_item,country)
        autoCompleteTextView.setAdapter(arrayAdapter)
        autoCompleteTextView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val item = parent.getItemAtPosition(position).toString()
        }
    }



}