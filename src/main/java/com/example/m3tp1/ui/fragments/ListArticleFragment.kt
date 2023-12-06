package com.example.m3tp1.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.m3tp1.R
import com.example.m3tp1.repository.ArticleRepository

class ListArticleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list_article, container, false)

        var titles = ""
        ArticleRepository.getAllArticle().forEach { article ->
            titles += "${article.titre}\n"
        }

        val textView = view.findViewById<TextView>(R.id.textViewListArictle)
        textView.text = titles

        val article = ArticleRepository.getArticle(1L)
        val button = view.findViewById<Button>(R.id.buttonListArticle)
        button.setOnClickListener {
            val direction = ListArticleFragmentDirections.actionListArticleFragmentToDetailArticleFragment(article)
            findNavController().navigate(direction)
        }

        return view
    }
}