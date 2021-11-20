package com.example.fortuners


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import android.view.WindowInsetsController

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val name: TextView = findViewById(R.id.nameTextView)
        val description: TextView = findViewById(R.id.descriptionTextView)
        val poster: ImageView = findViewById(R.id.posterImageView)

        name.text = intent.getStringExtra("name")
        description.text = intent.getStringExtra("description")

        Glide.with(this)
            .load(intent.getStringExtra("url"))
            .into(poster)
    }



}