package com.example.testfrontendandroiddeveloper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testfrontendandroiddeveloper.api.ApiClient
import com.example.testfrontendandroiddeveloper.api.ApiInterface
import com.example.testfrontendandroiddeveloper.models.Article
import com.example.testfrontendandroiddeveloper.models.News
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var recyclerview: RecyclerView
    lateinit var progress_bar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val request = ApiClient.buildService(ApiInterface::class.java)
        val call = request.getArticles(getString(R.string.apiKey))

        recyclerview = findViewById(R.id.recyclerView)
        progress_bar = findViewById(R.id.progress_bar)


        call.enqueue(object : Callback<News>{
            override fun onResponse(call: Call<News>, response: Response<News>) {
                if (response.isSuccessful) {
                    progress_bar.visibility = View.GONE
                    recyclerview.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        adapter = ArticleAdapter(response.body()!!.Articles)
                    }

                }

            }
            override fun onFailure(call: Call<News>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }



}


