package com.example.tempopoa

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Toast
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.Volley
import com.barbbecker.fundatec.proconapp.GsonRequest

import kotlinx.android.synthetic.main.activity_main.*
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity() {


    private var queue: RequestQueue? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        queue = Volley.newRequestQueue(baseContext)
        readStation()

    }

    private fun readStation() {
        var request = GsonRequest(
            "https://metroclimaestacoes.procempa.com.br/metroclima/seam/resource/rest/externalRest/ultimaLeitura",
            Array<Station>::class.java, null,
            Response.Listener { response ->
                Toast.makeText(baseContext, "Deu certo " + response, Toast.LENGTH_LONG).show()
                listview.adapter = ArrayAdapter<Station>(baseContext,
                    android.R.layout.simple_list_item_1, response
                )
            },
            Response.ErrorListener { error ->
                Toast.makeText(baseContext, "Deu error " + error.message, Toast.LENGTH_LONG).show()
            }
        )
        queue?.add(request)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
