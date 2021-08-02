package com.example.registrationform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var obtainedusername = ""
        var obtainedfullname = ""
        var obtainedcountry = ""
        var obtainedemail = ""
        var obtainedphone = ""
        var obtainedgender = ""
        obtainedusername = intent.getStringExtra("Referusername").toString()
        obtainedfullname = intent.getStringExtra("Referfullname").toString()
        obtainedcountry = intent.getStringExtra("Refercountry").toString()
        obtainedemail = intent.getStringExtra("Referemail").toString()
        obtainedphone = intent.getStringExtra("Referphone").toString()
        obtainedgender = intent.getStringExtra("Refergender").toString()
        welcomeTextview.text= "Welcome "+ obtainedusername + "\nFullname: " + obtainedfullname +"\n Country: "+ obtainedcountry+"\n Email: "+ obtainedemail +"\n Phone: "+obtainedphone +"\nGender : "+obtainedgender
    }
}