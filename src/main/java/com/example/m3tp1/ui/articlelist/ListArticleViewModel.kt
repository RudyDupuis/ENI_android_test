package com.example.m3tp1.ui.articlelist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.m3tp1.bo.Article
import com.example.m3tp1.repository.ArticleRepository
import kotlin.random.Random

class ListArticleViewModel : ViewModel() {
    var articles = MutableLiveData<List<Article>>(ArticleRepository.getAllArticle())

    fun getArticleList(): List<Article>? {
        return articles.value
    }

    fun getRandomArticle(): Article? {
        val maxBorne : Int = articles.value?.size ?: 1
        return articles.value?.get(Random.nextInt(1, maxBorne))
    }
}