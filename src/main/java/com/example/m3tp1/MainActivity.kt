package com.example.m3tp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.m3tp1.bo.Article
import com.example.m3tp1.repository.ArticleRepository
import java.util.Date

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val article = Article(titre = "guitare", description = "Une super guitare", prix = 12.2, urlImage =  "", dateSortie =  Date())

        Log.d("Mestest", "${ArticleRepository.getArticle(1L)}")
        Log.d("Mestest", "${ArticleRepository.addArticle(article)}")

    }
}