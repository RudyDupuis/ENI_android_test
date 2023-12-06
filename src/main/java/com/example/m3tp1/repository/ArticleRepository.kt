package com.example.m3tp1.repository

import com.example.m3tp1.bo.Article
import com.example.m3tp1.dao.ArticleDAO
import com.example.m3tp1.dao.DAOFactory
import com.example.m3tp1.dao.DAOType

object ArticleRepository {
    private val articleDAOMemory : ArticleDAO = DAOFactory.createArticleDAO(DAOType.MEMORY)
    private val articleDAONetwork : ArticleDAO = DAOFactory.createArticleDAO(DAOType.NETWORK)

    fun getAllArticle() : MutableList<Article> {
        return articleDAOMemory.selectAll()
    }

    fun getArticle(id : Long) : Article {
        return articleDAOMemory.selectById(id)
    }

    fun addArticle(article : Article) : Long {
        return articleDAOMemory.addNewOne(article)
    }
}