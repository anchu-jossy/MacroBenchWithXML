package com.example.xmlandmacrobenchmark

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.xmlandmacrobenchmark.databinding.LayoutShoplistBinding
import java.util.Locale

class ShopListAdapter(private val context: Context, private var shopList: List<Shop>) :
    RecyclerView.Adapter<ShopListAdapter.ShopViewHolder>(), Filterable {

    private var filteredShopList: List<Shop> = shopList

    // Filter for search functionality
    private val filter = object : Filter() {
        override fun performFiltering(constraint: CharSequence?): FilterResults {
            val filteredList = mutableListOf<Shop>()
            val query = constraint?.toString()?.trim()?.toLowerCase(Locale.getDefault()) ?: ""

            if (query.isEmpty()) {
                filteredList.addAll(shopList)
            } else {
                for (shop in shopList) {
                    if (shop.name.toLowerCase(Locale.getDefault()).contains(query) ||
                        shop.address.toLowerCase(Locale.getDefault()).contains(query)
                    ) {
                        filteredList.add(shop)
                    }
                }
            }

            val filterResults = FilterResults()
            filterResults.values = filteredList
            return filterResults
        }

        override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
            filteredShopList = results?.values as List<Shop>
            notifyDataSetChanged()
        }
    }
    fun filterShopList(filteredList: List<Shop>) {
        filteredShopList = filteredList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = LayoutShoplistBinding.inflate(inflater, parent, false)
        return ShopViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {
        val shop = filteredShopList[position]
        holder.bind(shop)
    }

    override fun getItemCount(): Int = filteredShopList.size

    override fun getFilter(): Filter = filter
     fun restoreOriginalDataSet() {
        filteredShopList = shopList
        notifyDataSetChanged()
    }
    inner class ShopViewHolder(private val binding: LayoutShoplistBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(shop: Shop) {
            // Bind shop data to views
            with(binding) {
                // Set shop details
                shopName.text = shop.name
                shopAddress.text = shop.address
                shopRating.text = "Rating: ${shop.rating}"
                addStarRatings(shop.rating.toInt(), shopRating)
                // Load image using Glide
                Glide.with(itemView)
                    .load(shop.image)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(imageView)

            }
        }
        // Function to add star ratings to TextView
        private fun addStarRatings(rating: Int, textView: TextView) {
            val filledStar = "\u2605" // Filled star Unicode character
            val unfilledStar = "\u2606" // Unfilled star Unicode character
            val ratingText = StringBuilder()
            val brighterGrey = "#BEBEBE" // Example hexadecimal value for a lighter grey color

            for (i in 1..5) {
                ratingText.append(if (i <= rating) filledStar else unfilledStar)
            }

            textView.text = "Rating: $rating$ratingText"
            textView.setTextColor(Color.parseColor(brighterGrey))


        }

    }
}
