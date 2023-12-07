package com.example.m3tp1.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.m3tp1.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val snackbarMessage = intent.getStringExtra("snackbar")
        if (snackbarMessage != null) {
            Snackbar.make(
                findViewById(android.R.id.content),
                snackbarMessage,
                Snackbar.LENGTH_LONG
            ).show()
        }

        val buttonExplicit = findViewById<FloatingActionButton>(R.id.floatingActionButtonAjoutArticle)
        buttonExplicit.setOnClickListener {
            Intent(this,AjoutArticleActivity::class.java).apply {
                startActivity(this)
            }
        }

    }
}