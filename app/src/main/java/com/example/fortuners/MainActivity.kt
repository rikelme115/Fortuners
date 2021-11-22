package com.example.fortuners


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import java.io.IOException



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        setupRecyclerView(recyclerView)
    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        recyclerView.adapter = PoiViewAdapter(loadData())
    }

    private fun loadData(): MutableList<Poi>{
        val listaPoi:MutableList<Poi> = mutableListOf()
        try{
            val stream = assets.open("poi.json")
            val size = stream.available()
            val buffer = ByteArray(size)
            stream.read(buffer)
            stream.close()
            val tContents = String(buffer)
            val jsonArray = JSONArray(tContents)

            for (i in 0 until jsonArray.length()){
                val obj = jsonArray.getJSONObject(i)
                val id = obj.getInt("id")
                val name = obj.getString("name")
                val date = obj.getString("date")
                val description = obj.getString("description")
                val ubicacion = obj.getString("ubicacion")
                val temperatura = obj.getString("temperatura")
                val puntuacion = obj.getString("puntuacion")
                val url = obj.getString("url")
                listaPoi.add(Poi(id,name, date, description, ubicacion, temperatura, puntuacion, url))
            }
        }catch (e: IOException){

        }
        return listaPoi
    }


}
