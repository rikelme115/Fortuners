package com.example.fortuners

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        setupRecyclerView(recyclerView)
    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        recyclerView.adapter = PointViewAdapter(getVideogames())
    }

    class PointViewAdapter(private val values: List<Points>) :
        RecyclerView.Adapter<PointViewAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_content, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val point = values[position]
            holder.nameTextView.text = point.name
            holder.dateTextView.text = point.date

            holder.posterImageView.let {
                Glide.with(holder.itemView.context)
                    .load(point.url)
                    .into(it)
            }

            holder.itemView.setOnClickListener { v ->
                val intent = Intent(v.context, DetailActivity::class.java).apply {
                    putExtra("id", point.id)
                    putExtra("name", point.name)
                    putExtra("description", point.description)
                    putExtra("url", point.url)
                }
                v.context.startActivity(intent)
            }

        }

        override fun getItemCount() = values.size

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val nameTextView: TextView = view.findViewById(R.id.nameTextView)
            val dateTextView: TextView = view.findViewById(R.id.dateTextView)
            val posterImageView: ImageView = view.findViewById(R.id.posterImageView)
        }
    }

    private fun getVideogames(): MutableList<Points>{
        val mVideogame:MutableList<Points> = ArrayList()
        mVideogame.add(Points(1, "Parque Explora", "Fecha de Inaguracion:diciembre de 2007",
            "Es un museo interactivo y parque temático de 22000 m2 dedicado a la ciencia y la tecnología. Está al norte de Medellín, cerca del campus de la Universidad de Antioquia. Cuenta con los espacios Exploratorio, Planetario, Vivario, Acuario y Teatro, y con las salas interactivas En Escena, Mente, Tiempo, Sala Música y Sala Infantil.",
            "https://i.pinimg.com/originals/9e/66/1d/9e661d10b945ec8389b2874ec7fd6b0c.jpg"))
        mVideogame.add(Points(2, "Valorant", "Fecha de estreno inicial: 2 de junio de 2020",
            "Valorant es un videojuego de disparos en primera persona multijugador gratuito desarrollado y publicado por Riot Games. El juego se anunció por primera vez con el nombre en clave Project A en octubre de 2019.",
            "https://assets.mycast.io/posters/valorant-fan-casting-poster-33618-large.jpg?1586664619"))
        mVideogame.add(Points(3, "Fortnite", "Fecha de estreno inicial: 21 de julio de 2017",
            "Fortnite es un videojuego del año 2017 desarrollado por la empresa Epic Games, lanzado como diferentes paquetes de software que presentan diferentes modos de juego, pero que comparten el mismo motor de juego y mecánicas. Fue anunciado en los Spike Video Game Awards en 2011.",
            "https://galleryplus.ebayimg.com/ws/web/154293147956_1_0_1.jpg"))
        mVideogame.add(Points(4, "Dota 2", "9 de julio de 2013",
            "Dota 2 es un videojuego perteneciente al género de Arena de batalla en línea ARTS, también conocido como MOBA, lanzado el 9 de julio del año 2013. El juego fue desarrollado por la empresa Valve Corporation.",
            "https://upload.wikimedia.org/wikipedia/ru/8/8e/%D0%9E%D0%B1%D0%BB%D0%BE%D0%B6%D0%BA%D0%B0_Dota_2.jpg"))
        mVideogame.add(Points(5, "Counter-Strike: Global Offensive", "Fecha de estreno inicial: 21 de agosto de 2012",
            "Counter-Strike: Global Offensive es un videojuego de disparos en primera persona desarrollado por Valve Corporation en cooperación con Hidden Path Entertainment, y es el cuarto juego de la saga Counter-Strike, sin contar Counter-Strike: Online.",
            "https://s3.gaming-cdn.com/images/products/62/orig/counter-strike-global-offensive-prime-status-upgrade-cover.jpg"))
        return mVideogame
    }
}