package com.example.fortuners

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
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
        recyclerView.adapter = PointViewAdapter(getPoints())
    }

    class PointViewAdapter(private val values: List<Point>) :
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

    private fun getPoints(): MutableList<Point>{
        val mPoint:MutableList<Point> = ArrayList()
        mPoint.add(Point(1, "Parque Explora", "Fecha de Inaguracion:diciembre de 2007",
            "Es un museo interactivo y parque temático de 22000 m2 dedicado a la ciencia y la tecnología. Está al norte de Medellín, cerca del campus de la Universidad de Antioquia. Cuenta con los espacios Exploratorio, Planetario, Vivario, Acuario y Teatro, y con las salas interactivas En Escena, Mente, Tiempo, Sala Música y Sala Infantil.",
            "https://tipsparatuviaje.com/wp-content/uploads/2019/09/parque-explora.jpg"))
        mPoint.add(Point(2, "Museo y Jardines El Castillo", "Fecha de estreno inicial: 2 de junio de 2020",
            "Valorant es un videojuego de disparos en primera persona multijugador gratuito desarrollado y publicado por Riot Games. El juego se anunció por primera vez con el nombre en clave Project A en octubre de 2019.",
            "https://tipsparatuviaje.com/wp-content/uploads/2019/09/museo-y-jardines-el-castillo.jpg"))
        mPoint.add(Point(3, "Parque Bolívar", "Fecha de estreno inicial: 21 de julio de 2017",
            "Fortnite es un videojuego del año 2017 desarrollado por la empresa Epic Games, lanzado como diferentes paquetes de software que presentan diferentes modos de juego, pero que comparten el mismo motor de juego y mecánicas. Fue anunciado en los Spike Video Game Awards en 2011.",
            "https://tipsparatuviaje.com/wp-content/uploads/2019/09/parque-bolivar.jpg"))
        mPoint.add(Point(4, "Parque de los Pies Descalzos", "9 de julio de 2013",
            "Dota 2 es un videojuego perteneciente al género de Arena de batalla en línea ARTS, también conocido como MOBA, lanzado el 9 de julio del año 2013. El juego fue desarrollado por la empresa Valve Corporation.",
            "https://tipsparatuviaje.com/wp-content/uploads/2019/09/parque-de-los-pies-descalzos.jpg"))
        mPoint.add(Point(5, "Jardín Botánico de Medellín", "Fecha de estreno inicial: 21 de agosto de 2012",
            "Counter-Strike: Global Offensive es un videojuego de disparos en primera persona desarrollado por Valve Corporation en cooperación con Hidden Path Entertainment, y es el cuarto juego de la saga Counter-Strike, sin contar Counter-Strike: Online.",
            "https://tipsparatuviaje.com/wp-content/uploads/2019/09/jardin-botanico-de-medellin.jpg"))
        return mPoint
    }


}