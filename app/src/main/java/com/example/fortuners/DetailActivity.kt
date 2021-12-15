package com.example.fortuners


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.fortuners.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_detail)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name: TextView = binding.nameTextView
        val description: TextView =binding.descriptionTextView
        val poster: ImageView = binding.posterImageView
        val ubicacion: TextView = binding.ubicacionTextView
        val temperatura: TextView = binding.tempTextView

        name.text = intent.getStringExtra("name")
        description.text = intent.getStringExtra("description")
        ubicacion.text = intent.getStringExtra("ubicacion")
        temperatura.text = intent.getStringExtra("temperatura")

        Glide.with(this)
            .load(intent.getStringExtra("url"))
            .into(poster)


        binding.button.setOnClickListener { v ->
            val intent = Intent(v.context, MapsPoi::class.java).apply {

                putExtra("lat", -34.0)
                putExtra("lon", 151.0)
            }
            v.context.startActivity(intent)
        }
    }



}