package com.example.m3tp1.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.m3tp1.bo.Article
import com.example.m3tp1.databinding.ActivityAjoutArticleBinding
import com.example.m3tp1.repository.ArticleRepository
import java.util.Date

class AjoutArticleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAjoutArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val article = Article(titre = "", description = "", prix = 0.0, urlImage =  "", dateSortie =  Date())

        binding.article = article

        binding.buttonArticle.setOnClickListener {
            binding.article?.let { currentArticle ->
                val newArticle = Article(
                    titre = currentArticle.titre ?: "",
                    description = currentArticle.description ?: "",
                    prix = currentArticle.prix ?: 0.0,
                    urlImage = "",
                    dateSortie = Date()
                )

                ArticleRepository.addArticle(newArticle)

                Intent(this,HomeActivity::class.java).apply {
                    putExtra("snackbar","Vous venez de créer ${currentArticle.titre} vendu pour un montant de ${currentArticle.prix}€")
                    startActivity(this)
                }
            }
        }


    }
}