package com.barbbecker.fundatec.apirestful

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_new_post.*

class NewPostActivity : AppCompatActivity() {

    private var queue: RequestQueue? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_post)

        btSend.setOnClickListener { view ->
            if (txtNome.text.toString().isEmpty()) {
                txtNome.error = "Preencha um nome!"
            }
            if (txtUserName.text.toString().isEmpty()) {
                txtNome.error = "Preencha o user name!"
            }
            if (txtUrlImagem.text.toString().isEmpty()) {
                txtNome.error = "Preencha a url da imagem!"
            }
            if (txtDesc.text.toString().isEmpty()) {
                txtNome.error = "Descreva o seu post!"
            }
            if (!txtNome.text.toString().isEmpty() &&
                !txtUserName.text.toString().isEmpty() &&
                !txtUrlImagem.text.toString().isEmpty() &&
                !txtDesc.text.toString().isEmpty()) {
                sendPost()
            }
        }

        queue = Volley.newRequestQueue(baseContext)

    }

    private fun sendPost() {
        var post = Post(null, txtDesc.text.toString(), null,
            txtUrlImagem.text.toString(), 0, txtNome.text.toString(),
            null, txtUserName.text.toString())

        var json = Gson().toJson(post)
        var url = "https://fundatec.dev.aioria.com.br/api/v1/post"
        var requestSendPost = GsonJsonRequest(Request.Method.POST, url, Post::class.java,
            json, Response.Listener { response ->
                finish()
            }, Response.ErrorListener { error ->
                Toast.makeText(baseContext, "Erro: " + error.message, Toast.LENGTH_LONG).show()
            })

        queue?.add(requestSendPost)
    }
}
