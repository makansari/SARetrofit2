package com.example.saretrofit2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCall.setOnClickListener {

            Toast.makeText(this,"test",Toast.LENGTH_LONG).show()
            var makecall = RetroiftClient.myretrofit.getUsers()

            makecall.enqueue(object : Callback<UsersData>{
                override fun onResponse(call: Call<UsersData>, response: Response<UsersData>) {

                    var myresponse = response.body()!!


                    var contactData = myresponse.contacts

                    var sb = StringBuilder()


                    for(i in contactData)
                    {

                        sb.append(i.name)
                        sb.append(i.phone)

                        sb.append("\n")
                        sb.append("\n")
                        sb.append("\n")

                    }
                    textViewRES.setText(sb)

                    Log.i("mytag","")


                }

                override fun onFailure(call: Call<UsersData>, t: Throwable) {

                    Log.i("mytag","${t.message}")
                }
            })
        }
    }
}