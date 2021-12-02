package com.example.fortuners




import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fortuners.databinding.FragmentRecyclerBinding
import org.json.JSONArray
import java.io.IOException


class RecyclerFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentRecyclerBinding? = null
    private val binding get() = _binding!!

    /*var navController: NavController? = null*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRecyclerBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*navController = findNavController(view)*/

        binding.btnPlus.setOnClickListener(this)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        setupRecyclerView(recyclerView)
    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        recyclerView.adapter = PoiViewAdapter(loadData())
    }

    private fun loadData(): MutableList<Poi>{
        val listaPoi:MutableList<Poi> = mutableListOf()
        try{

            val stream = requireContext().assets.open("poi.json")
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

    override fun onClick(v: View?) =
        binding.btnPlus.findNavController().navigate(R.id.action_recyclerFragment_to_settingsFragment)

}
