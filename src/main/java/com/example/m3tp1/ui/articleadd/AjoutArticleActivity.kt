package com.example.m3tp1.ui.articleadd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.m3tp1.bo.Article
import com.example.m3tp1.databinding.ActivityAjoutArticleBinding
import com.example.m3tp1.repository.ArticleRepository
import com.example.m3tp1.ui.HomeActivity
import java.util.Date

class AjoutArticleActivity : AppCompatActivity() {
    private val ajoutArticleVM by viewModels<AjoutArticleViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAjoutArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.vm = ajoutArticleVM

        binding.buttonArticle.setOnClickListener {
            ajoutArticleVM.addArticle()

            Intent(this, HomeActivity::class.java).apply {
                putExtra("snackbar","Vous venez de créer ${ajoutArticleVM.article.titre} vendu pour un montant de ${ajoutArticleVM.article.prix}€")
                startActivity(this)
            }
        }


    }
}