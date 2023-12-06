package com.example.m3tp1.dao

import com.example.m3tp1.bo.Article

interface ArticleDAO {
    fun selectAll() : MutableList<Article>
    fun selectById(id: Long) : Article
    fun addNewOne(article : Article) : Long
}