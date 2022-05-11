package com.kitesoft.kakaosearchapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.kitesoft.kakaosearchapp.adapters.KeywordPlaceRecyclerAdapter
import com.kitesoft.kakaosearchapp.databinding.ActivityMainBinding
import com.kitesoft.kakaosearchapp.model.KeywordPlaceResponse
import com.kitesoft.kakaosearchapp.network.IRetrofitSearchPlaceService
import com.kitesoft.kakaosearchapp.network.RetrofitHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()

        searchKeywordItems()
    }

    private fun searchKeywordItems(){

        val retrofitSearchPlaceService=RetrofitHelper.getRetrofitInstance().create(IRetrofitSearchPlaceService::class.java)
        retrofitSearchPlaceService.searchPlacesByKeyword("공원", "127.5", "37.5").enqueue(object : Callback<KeywordPlaceResponse>{
            override fun onResponse(
                call: Call<KeywordPlaceResponse>,
                response: Response<KeywordPlaceResponse>
            ) {
                val keywordPlaceResponse:KeywordPlaceResponse?= response.body()
                //if(keywordPlaceResponse!=null) AlertDialog.Builder(this@MainActivity).setMessage("${keywordPlaceResponse.documents.size}").create().show()
                if(keywordPlaceResponse!=null) binding.recycler.adapter= KeywordPlaceRecyclerAdapter(this@MainActivity, keywordPlaceResponse.documents)
            }

            override fun onFailure(call: Call<KeywordPlaceResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, "error : ${t.message}", Toast.LENGTH_SHORT).show()
            }

        })
//        retrofitSearchPlaceService.searchPlacesByKeywordToString("공원", "127.5", "37.5").enqueue(object : Callback<String>{
//            override fun onResponse(call: Call<String>, response: Response<String>) {
//                AlertDialog.Builder(this@MainActivity).setMessage(response.body()).create().show()
//            }
//
//            override fun onFailure(call: Call<String>, t: Throwable) {
//                Toast.makeText(this@MainActivity, "error : ${t.message}", Toast.LENGTH_SHORT).show()
//            }
//        })

    }
}