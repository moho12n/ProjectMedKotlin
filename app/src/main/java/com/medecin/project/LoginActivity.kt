package com.medecin.project

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.core.content.edit

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var btn_new_activity = findViewById(R.id.ButtonLoginToSignUp) as Button
        btn_new_activity.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        var btnlogin = findViewById(R.id.btnlogin) as Button
        btnlogin.setOnClickListener {



            check()


            val call = RetrofitService.endpoint.login( EditTextTelephoneLogin.text.toString(),EditTextTelephonePassword.text.toString())
            call.enqueue(object: Callback<List<Patient>> {
                override fun onResponse(call: Call<List<Patient>>?, response:
                Response<List<Patient>>?) {
                    if(response?.body().isNullOrEmpty()){
                        Toast.makeText(this@LoginActivity, "Veuillez verifier vos information", Toast.LENGTH_SHORT).show()

                    }
                    else {
                        if (response?.body()!![0].newpassword=="0"){

                            var phone = response?.body()!![0].phone
                            Toast.makeText(this@LoginActivity, phone, Toast.LENGTH_SHORT).show()

                        }
                        else {
                            Toast.makeText(this@LoginActivity, "Accueil", Toast.LENGTH_SHORT).show()
                            log()
                            //On met l'interface du patient
                        }
                    }

                }
                override fun onFailure(call: Call<List<Patient>>, t: Throwable) {
                    Toast.makeText(this@LoginActivity, t!!.message, Toast.LENGTH_SHORT).show()
                }
            })

        }
    }


fun check():Boolean{


    val pref = this.getSharedPreferences("status"

        ,Context.MODE_PRIVATE)

    val con = pref.getBoolean("connected"

        , false)
    println(con.toString())
    return con

}
 fun log(){
     val pref = this.getSharedPreferences("status"

         ,Context.MODE_PRIVATE)
     pref.edit {
         putBoolean("connected"
             ,true)




     }

 }



}
