package com.example.fortuners

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PoiViewAdapter(private val values: List<Poi>) : RecyclerView.Adapter<PoiViewAdapter.ViewHolder>() {

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