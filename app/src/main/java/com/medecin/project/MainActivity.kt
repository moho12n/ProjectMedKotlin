package com.medecin.project

import MedecinAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.Menu
import android.widget.SearchView
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private  var myDataset : ArrayList<Medecin> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewAdapter = MedecinAdapter(myDataset)
        viewManager = LinearLayoutManager(this)

        val call = RetrofitService.endpoint.getmedecin()
        call.enqueue(object: Callback<List<Medecin>> {
            override fun onResponse(call: Call<List<Medecin>>?, response:
            Response<List<Medecin>>?) {
                myDataset.addAll(ArrayList( response?.body()!!))
                Log.e("dataset",myDataset.toString())
                viewAdapter.notifyDataSetChanged()
            }
            override fun onFailure(call: Call<List<Medecin>>, t: Throwable) {
                Toast.makeText(this@MainActivity, t!!.message, Toast.LENGTH_SHORT).show()
            }
        })

        recyclerView = findViewById<RecyclerView>(R.id.list_id).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter

        }

        EditTextRechercheCommune.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                val call2 = RetrofitService.endpoint.getMedecinSpecAndComm(EditTextRechercheCommune.text.toString(),EditTextRechercheSpecialite.text.toString())
                    call2.enqueue(object: Callback<List<Medecin>> {
                        override fun onResponse(call2: Call<List<Medecin>>?, response:
                        Response<List<Medecin>>?) {
                            myDataset.clear()
                            if(response?.body() != null) myDataset.addAll(ArrayList( response?.body()!!))
                            Log.e("dataset",myDataset.toString())
                            viewAdapter.notifyDataSetChanged()
                        }
                        override fun onFailure(call: Call<List<Medecin>>, t: Throwable) {
                            Toast.makeText(this@MainActivity, t!!.message, Toast.LENGTH_SHORT).show()
                        }
                    })
                }


        })

        EditTextRechercheSpecialite.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                val call2 = RetrofitService.endpoint.getMedecinSpecAndComm(EditTextRechercheCommune.text.toString(),EditTextRechercheSpecialite.text.toString())
                call2.enqueue(object: Callback<List<Medecin>> {
                    override fun onResponse(call2: Call<List<Medecin>>?, response:
                    Response<List<Medecin>>?) {
                        myDataset.clear()
                        if(response?.body() != null) myDataset.addAll(ArrayList( response?.body()!!))
                        Log.e("dataset",myDataset.toString())
                        viewAdapter.notifyDataSetChanged()
                    }
                    override fun onFailure(call: Call<List<Medecin>>, t: Throwable) {
                        Toast.makeText(this@MainActivity, t!!.message, Toast.LENGTH_SHORT).show()
                    }
                })
            }


        })
    }
}
