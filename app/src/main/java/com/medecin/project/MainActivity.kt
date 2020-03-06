package com.medecin.project

import MedecinAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.widget.SearchView
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val call = RetrofitService.endpoint.getmedecin()


        val btnRecherche = findViewById(R.id.button_recherche) as Button

        call.enqueue(object: Callback<List<Medecin>> {
            override fun onResponse(call: Call<List<Medecin>>?, response:
            Response<List<Medecin>>?) {
                val adapter = MedecinAdapter(this@MainActivity, response?.body()!!)
                Listview_id.adapter = adapter

                  EditTextRechercheCommune.addTextChangedListener(object : TextWatcher {

                    override fun afterTextChanged(s: Editable) {}

                    override fun beforeTextChanged(s: CharSequence, start: Int,
                                                   count: Int, after: Int) {
                    }

                    override fun onTextChanged(s: CharSequence, start: Int,
                                               before: Int, count: Int) {

                    }
                })
            }
            override fun onFailure(call: Call<List<Medecin>>, t: Throwable) {
                Toast.makeText(this@MainActivity, t!!.message, Toast.LENGTH_SHORT).show()
            }
        })
    }
}
