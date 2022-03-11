package com.example.testfrontendandroiddeveloper

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testfrontendandroiddeveloper.models.Article


class ArticleAdapter(val data: List<Article>): RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {


    class ArticleViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
        private val image: ImageView = itemView.findViewById(R.id.img)
        private val published: TextView = itemView.findViewById(R.id.publishedAt)
        private val author: TextView = itemView.findViewById(R.id.author)
        private val title: TextView = itemView.findViewById(R.id.title)
        private val description: TextView = itemView.findViewById(R.id.desc)
        private val source: TextView = itemView.findViewById(R.id.source)


        fun bind(datas: Article) {
            Glide.with(itemView.context).load(datas.urlToImage).into(image)
            published.text = datas.publishedAt
            author.text = datas.author
            title.text = datas.title
            description.text = datas.description
            source.text = datas.source.toString()
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        TODO("Not yet implemented")
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ArticleViewHolder(v)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        TODO("Not yet implemented")
        return holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
        return data.size
    }

}


