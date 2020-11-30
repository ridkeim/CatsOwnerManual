package ru.ridkeim.catsownermanual

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class DetailActivity : AppCompatActivity() {

    companion object {
        const val KEY_CHAPTER_NUMBER = "chapter"
        const val KEY_CHAPTER_TITLE = "chapter_title"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val chapterTitle = intent.getStringExtra(KEY_CHAPTER_TITLE) ?: ""
        val chapterNumber = intent.getIntExtra(KEY_CHAPTER_NUMBER,0)+1
        val webView = findViewById<WebView>(R.id.webView)
        val text = "$chapterNumber $chapterTitle"
        webView.loadDataWithBaseURL(null, text, "text/html", "en_US", null)
    }
}