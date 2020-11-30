package ru.ridkeim.catsownermanual

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val chaptersListView = findViewById<ListView>(R.id.listView)
        chaptersListView.adapter = ArrayAdapter.createFromResource(this,R.array.chapters_names, android.R.layout.simple_list_item_1)
        chaptersListView.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra(DetailActivity.KEY_CHAPTER_NUMBER, position)
                putExtra(DetailActivity.KEY_CHAPTER_TITLE, view.findViewById<TextView>(android.R.id.text1).text)
            }
            startActivity(intent)
        }
    }
}