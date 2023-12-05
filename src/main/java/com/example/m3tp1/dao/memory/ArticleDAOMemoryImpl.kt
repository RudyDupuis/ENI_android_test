package com.example.m3tp1.dao.memory

import com.example.m3tp1.bo.Article
import com.example.m3tp1.dao.ArticleDAO
import java.util.Date

class ArticleDAOMemoryImpl : ArticleDAO {
    private val articlesInMemory: MutableList<Article> = mutableListOf(
        Article(1L, "pyjama", "un super pyjama", 12.5, "", Date()),
        Article(2L, "soda", "un super soda", 2.5, "", Date()),
        Article(3L, "pomme", "une super pomme", 1.5, "", Date()),
    )

    override fun selectById(id: Long): Article {
        return articlesInMemory.find { it.id == id } ?: throw NoSuchElementException("Article not found")
    }

    override fun addNewOne(article: Article): Long {
        val newId = articlesInMemory.size + 1
        val newArticle = Article(newId.toLong(), article.titre, article.description, article.prix, article.urlImage, article.dateSortie)
        articlesInMemory.add(newArticle)
        return newId.toLong()
    }
}
