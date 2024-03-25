package com.example.xmlandmacrobenchmark

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class ItemAdapter(private var itemList: ArrayList<String>, private var listener: OnItemClickListener) :
    RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.bind(item, listener)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewItem: TextView = itemView.findViewById(R.id.textViewItem)
        private val cardView: CardView = itemView.findViewById(R.id.cardView)

        fun bind(item: String, listener: OnItemClickListener) {
            textViewItem.text = item
            textViewItem.setOnClickListener {
                listener.onClicking()
            }
            val randomColor = getRandomColor()
            cardView.setCardBackgroundColor(randomColor)
        }

        private fun getRandomColor(): Int {
            return Color.argb(255, Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))
        }
    }

    interface OnItemClickListener {
        fun onClicking()
    }
}
