package com.example.m3tp1.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.m3tp1.bo.Article
import com.example.m3tp1.databinding.ActivityMainBinding
import com.example.m3tp1.repository.ArticleRepository
import com.google.android.material.snackbar.Snackbar
import java.util.Date

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
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

                val snackbar = Snackbar.make(
                    binding.root,
                    "Vous venez de créer ${currentArticle.titre} vendu pour un montant de ${currentArticle.prix}€",
                    Snackbar.LENGTH_LONG
                )
                snackbar.show()
            }
        }


    }
}