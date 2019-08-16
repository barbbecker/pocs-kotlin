package com.barbbecker.fundatec.gamelist

import android.os.Bundle
import android.text.Layout
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.activity_recycler.*
import kotlinx.android.synthetic.main.content_recycler.*

class RecyclerActivity : AppCompatActivity() {

    var arrayGames = arrayListOf(
        "PS4", "Switch", "PC", "PC Gamer", "PC de Loja", "PS1", "PS Vita", "PS3", "PS2",
        "SNES", "NES", "Mega Drive", "Polystation", "Dynavision", "Atari", "Amiga", "3DO",
        "Jaguar", "Neo geo", "N64", "Virtual Boy", "Wii", "Wii U"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        var adapter = CustomAdapter(baseContext, arrayGames)
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(baseContext, RecyclerView.VERTICAL, false)
    }

}
