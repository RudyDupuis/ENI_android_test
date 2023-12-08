package com.example.m3tp1.ui.articlelist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.m3tp1.R

class ListArticleFragment : Fragment() {

    private val viewModel: ListArticleViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list_article, container, false)
        val textView = view.findViewById<TextView>(R.id.textViewListArictle)

        viewModel.articles.observe(viewLifecycleOwner, Observer { articles ->
            var titles = ""
            articles.forEach { article ->
                titles += "${article.titre}\n"
            }
            textView.text = titles
        })

        val article = viewModel.getRandomArticle()
        val button = view.findViewById<Button>(R.id.buttonListArticle)
        button.setOnClickListener {
            if(article != null){
                val direction = ListArticleFragmentDirections.actionListArticleFragmentToDetailArticleFragment(article)
                findNavController().navigate(direction)
            }

        }

        return view
    }
}