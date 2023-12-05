package com.example.m3tp1.dao

import com.example.m3tp1.dao.memory.ArticleDAOMemoryImpl
import com.example.m3tp1.dao.network.ArticleDAONetworkImpl

object DAOFactory {
    fun createArticleDAO(type : DAOType) : ArticleDAO = when(type) {
            DAOType.MEMORY -> ArticleDAOMemoryImpl()
            DAOType.NETWORK -> ArticleDAOMemoryImpl()
    }
}