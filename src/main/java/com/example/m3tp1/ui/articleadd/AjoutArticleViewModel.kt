package com.example.m3tp1.ui.articleadd

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.m3tp1.bo.Article
import com.example.m3tp1.repository.ArticleRepository
import java.util.Date

class AjoutArticleViewModel : ViewModel() {
    var article = Article(titre = "", description = "", prix = 0.0, urlImage =  "", dateSortie =  Date())

    fun addArticle() {
        val newArticle = Article(
            titre = article.titre ?: "",
            description = article.description ?: "",
            prix = article.prix ?: 0.0,
            urlImage = "",
            dateSortie = Date()
        )

        ArticleRepository.addArticle(newArticle)
    }
}