package com.barbbecker.fundatec.gamelist

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.get

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    var arrayGames = arrayListOf(
        "PS4", "Switch", "PC", "PC Gamer", "PC de Loja", "PS1", "PS Vita", "PS3", "PS2",
        "SNES", "NES", "Mega Drive", "Polystation", "Dynavision", "Atari", "Amiga", "3DO",
        "Jaguar", "Neo geo", "N64", "Virtual Boy", "Wii", "Wii U"
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        repeat(10) {
            arrayGames.addAll(arrayGames)
        }

        var adapter = ArrayAdapter<String>(baseContext, android.R.layout.simple_list_item_1, arrayGames)
        listView.adapter = adapter

        listView.setOnItemClickListener { adapterView, view, i, l ->
            var name = adapterView.getItemAtPosition(i)
            Toast.makeText(baseContext, "Position : $i - name : $name", Toast.LENGTH_LONG).show()
        }
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
