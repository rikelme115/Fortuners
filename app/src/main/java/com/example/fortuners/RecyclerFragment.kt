package com.example.fortuners





import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fortuners.databinding.FragmentRecyclerBinding
import com.example.fortuners.models.MyDataItem
import com.example.fortuners.network.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RecyclerFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentRecyclerBinding? = null
    private val binding get() = _binding!!

    lateinit var myAdapter : PoiViewAdapter
    lateinit var linearLayoutManager : LinearLayoutManager


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentRecyclerBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.floatingActionButton2.setOnClickListener(this)
        binding.recyclerView.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(context)
        binding.recyclerView.layoutManager = linearLayoutManager

        getMyData()
    }

    private fun getMyData() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://my-json-server.typicode.com/rikelme115/Fortuners/")
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<MyDataItem>?> {
            override fun onResponse(
                call: Call<List<MyDataItem>?>,
                response: Response<List<MyDataItem>?>
            ) {
                val responseBody = response.body()!!

                myAdapter = PoiViewAdapter(responseBody)
                myAdapter.notifyDataSetChanged()
                binding.recyclerView.adapter = myAdapter
            }

            override fun onFailure(call: Call<List<MyDataItem>?>, t: Throwable) {
                Log.d("MainActivity", "onFailure: " +t.message)
            }
        })
    }

    override fun onClick(v: View?) =
        binding.floatingActionButton2.findNavController().navigate(R.id.action_recyclerFragment_to_settingsFragment)
}






