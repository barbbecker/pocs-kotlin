package com.barbbecker.fundatec.apirestful

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.Volley
import com.example.gamelist.CustomAdapter

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private var queue: RequestQueue? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()

            openNewPost()
        }

        queue = Volley.newRequestQueue(baseContext)
        recyclerView.layoutManager = LinearLayoutManager(baseContext, RecyclerView.VERTICAL, false)
        readApiRestFul()
    }

    private fun openNewPost() {
        startActivity(Intent(baseContext, NewPostActivity::class.java))
    }

    override fun onResume() {
        super.onResume()
        readApiRestFul()
    }

    private fun readApiRestFul() {
        var request = GsonRequest(
            "https://fundatec.dev.aioria.com.br/api/v1/timeline",
            Array<Post>::class.java, null,
            Response.Listener { response ->
                var adapter = CustomAdapter(this@MainActivity, ArrayList(response.toList()))
                recyclerView.adapter = adapter
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

    fun deletePost(id: Int?) {
        var url = "https://fundatec.dev.aioria.com.br/api/v1/post/" + id.toString()
        var requestDeletePost = GsonJsonRequest(Request.Method.DELETE, url, Post::class.java,
            "{}", Response.Listener { response ->
                Toast.makeText(baseContext, "Post deletado!", Toast.LENGTH_LONG).show()
                readApiRestFul()
            }, Response.ErrorListener { error ->
                Toast.makeText(baseContext, "Erro: " + error.message, Toast.LENGTH_LONG).show()
            })

        queue?.add(requestDeletePost)
    }

    fun likePost(id: Int?) {
        var url = "https://fundatec.dev.aioria.com.br/api/v1/post/" + id.toString() + "/like"
        var requestLikePost = GsonJsonRequest(Request.Method.PUT, url, Post::class.java,
            "{}", Response.Listener { response ->
                Toast.makeText(baseContext, "Like com sucesso", Toast.LENGTH_LONG).show()
                readApiRestFul()
            }, Response.ErrorListener { error ->
                Toast.makeText(baseContext, "Erro: " + error.message, Toast.LENGTH_LONG).show()
            })

        queue?.add(requestLikePost)
    }
}
