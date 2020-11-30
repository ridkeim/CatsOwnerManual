package ru.ridkeim.catsownermanual

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

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
        val text = readChapterFile(this,chapterNumber,chapterTitle)
        webView.loadDataWithBaseURL(null, text, "text/html", "en_US", null)
    }

    private fun readChapterFile(context : Context, chapterNumber : Int, chapterTitle : String) : String{
        val chapterFileName = "chapter$chapterNumber"
        val chapterFileId =
            context.resources.getIdentifier(
                chapterFileName,
                "raw",
                "ru.ridkeim.catsownermanual"
            )
        val stringBuilder = StringBuilder()
        stringBuilder.append("<h1>Глава $chapterNumber. $chapterTitle</h1>")
        if(chapterFileId!=0){
            BufferedReader(
                InputStreamReader(
                    context.resources.openRawResource(chapterFileId)
                )
            ).useLines{
                it.forEach {line ->
                    stringBuilder.append(line)
                    stringBuilder.append("<br>")
                }
            }
        } else{
            stringBuilder.append("Отсутствует файл $chapterFileName")
        }
        return stringBuilder.toString()
    }
}