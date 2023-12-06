package com.example.m3tp1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.m3tp1.repository.ArticleRepository

class ListArticleFragment : Fragment() {

    @SuppressLint("MissingInflatedId")
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

        val button = view.findViewById<Button>(R.id.buttonListArticle)
        button.setOnClickListener {
            findNavController().navigate(R.id.action_listArticleFragment_to_detailArticleFragment)
        }

        return view
    }
}