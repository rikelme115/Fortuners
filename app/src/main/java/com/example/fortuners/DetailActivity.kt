package com.example.fortuners


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val name: TextView = findViewById(R.id.nameTextView)
        val description: TextView = findViewById(R.id.descriptionTextView)
        val poster: ImageView = findViewById(R.id.posterImageView)
        val ubicacion: TextView = findViewById(R.id.ubicacionTextView)
        val temperatura: TextView = findViewById(R.id.tempTextView)

        name.text = intent.getStringExtra("name")
        description.text = intent.getStringExtra("description")
        ubicacion.text = intent.getStringExtra("ubicacion")
        temperatura.text = intent.getStringExtra("temperatura")

        Glide.with(this)
            .load(intent.getStringExtra("url"))
            .into(poster)
    }



}