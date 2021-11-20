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
            holder.rakingTextView.text = point.puntuacion


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
                    putExtra("ubicacion", point.ubicacion)
                    putExtra("temperatura", point.temperatura)
                }
                v.context.startActivity(intent)
            }

        }

        override fun getItemCount() = values.size

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val nameTextView: TextView = view.findViewById(R.id.nameTextView)
            val dateTextView: TextView = view.findViewById(R.id.dateTextView)
            val posterImageView: ImageView = view.findViewById(R.id.posterImageView)
            val rakingTextView: TextView = view.findViewById((R.id.rakingTextView))
        }
    }

    private fun getPoints(): MutableList<Point>{
        val mPoint:MutableList<Point> = ArrayList()
        mPoint.add(Point(1, "Parque Explora", "Fecha de Inaguracion:diciembre de 2007",
            "Es un museo interactivo y parque temático de 22000 m2 dedicado a la ciencia y la tecnología. Está al norte de Medellín, cerca del campus de la Universidad de Antioquia. Cuenta con los espacios Exploratorio, Planetario, Vivario, Acuario y Teatro, y con las salas interactivas En Escena, Mente, Tiempo, Sala Música y Sala Infantil.",
            "Cra 52 #73-75, Medellín, Antioquia",
            "25.3 ºC",
            "3.8",
            "https://tipsparatuviaje.com/wp-content/uploads/2019/09/parque-explora.jpg"))
        mPoint.add(Point(2, "Museo y Jardines El Castillo", "Fecha de estreno inicial: 2 de junio de 2020",
            "Alberga una de las mayores colecciones de artes decorativas de Colombia. Es uno de los lugares favoritos para las personas amantes del arte, la cultura y la tradición.",
            "Cl. 9 Sur #32-269, Medellín, Antioquia",
            "26.3 ºC",
            "4.2",
            "https://tipsparatuviaje.com/wp-content/uploads/2019/09/museo-y-jardines-el-castillo.jpg"))
        mPoint.add(Point(3, "Parque Bolívar", "Fecha de estreno inicial: 21 de julio de 2017",
            "Es un parque de dos manzanas (10395 m²), situado en el Barrio Villanueva, en la zona céntrica de Medellín. Denominado en honor a Simón Bolívar. La estatua ecuestre del Libertador fue colocada en 1936, obra de los escultores italianos Giovanni Anderlini (realizador artístico) y Eugenio Maccagnani (fundidor).",
            "Cra. 49 #5596, Medellín, Antioquia",
            "29.1 ºC",
            "3.5",
            "https://tipsparatuviaje.com/wp-content/uploads/2019/09/parque-bolivar.jpg"))
        mPoint.add(Point(4, "Parque de los Pies Descalzos", "9 de julio de 2013",
            "Entre los sitios turísticos de Medellín no hay uno más lúdico que este parque que invita a descalzarse para sentir el contacto de la arena, el agua y la hierba. Es un relajante oasis en medio de la segunda mayor zona metropolitana de Colombia. La entrada es gratuita.",
            "Cra. 58 #42-125, Medellín, Antioquia",
            "22.6 ºC",
            "4.6",
            "https://tipsparatuviaje.com/wp-content/uploads/2019/09/parque-de-los-pies-descalzos.jpg"))
        mPoint.add(Point(5, "Jardín Botánico", "Fecha de estreno inicial: 21 de agosto de 2012",
            "El Jardín Botánico de Medellín Joaquín Antonio Uribe es un espacio de 13.2 hectáreas localizado en la Calle 73, que recibe más de dos millones de visitantes al año.Fue inaugurado en 1972 y nombrado en honor del naturalista y educador antioqueño, Joaquín Antonio Uribe.",
            "Cl. 73 ##5114, Medellín, Antioquia",
            "23.7 ºC",
            "4.7",
            "https://tipsparatuviaje.com/wp-content/uploads/2019/09/jardin-botanico-de-medellin.jpg"))
        return mPoint
    }


}