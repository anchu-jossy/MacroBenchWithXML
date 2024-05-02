package com.example.xmlandmacrobenchmark

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.xmlandmacrobenchmark.databinding.ActivityShoplistBinding

class ShopListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShoplistBinding
    private val shopList = mutableListOf<Shop>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShoplistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ShopListAdapter(this, getDummyShops())
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
       binding.searchView.setOnQueryTextListener(
        object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String?): Boolean {
            // Perform search operation here

            return true
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            // Handle text changes in search bar
            // You can perform incremental search here
            performSearch(newText)
            return true
        }
    })
        binding.searchView.setOnCloseListener {
            // Restore the original data set when the search view is closed
            adapter.restoreOriginalDataSet()
            true // Return true to indicate that the listener has consumed the event
        }

}


    private fun performSearch(query: String?) {
        val filteredList = mutableListOf<Shop>()

        query?.let { searchTerm ->
            for (shop in getDummyShops()) {
                if (shop.name.contains(searchTerm, true) || shop.address.contains(searchTerm, true)) {
                    filteredList.add(shop)
                    filteredList.distinct()
                }
            }
        }

        // Update the adapter with the filtered list
        val adapter = binding.recyclerView.adapter as ShopListAdapter
        adapter.filterShopList(filteredList.distinct())
    }

    private fun getDummyShops(): List<Shop> {

        // Add each shop object to the shop_list array
        shopList.add(Shop(1, "Fashion Emporium", "123 Main St", 4.5f, ImageUrls.FASHION_EMPORIUM))
        shopList.add(Shop(2, "Dominos", "456 Elm St", 4.2f, ImageUrls.DOMINOS))
        shopList.add(Shop(3, "Gourmet Delights", "789 Oak Ave", 3.8f, ImageUrls.GOURMET_DELIGHTS))
        shopList.add(Shop(4, "Books 'R' Us", "101 Maple Rd", 4.0f, ImageUrls.BOOKS_R_US))
        shopList.add(Shop(5, "Sports World", "202 Pine Ln", 4.7f, ImageUrls.SPORTS_WORLD))
        shopList.add(
            Shop(
                6,
                "Home Decor Outlet",
                "303 Cedar Blvd",
                4.3f,
                ImageUrls.HOME_DECOR_OUTLET
            )
        )
        shopList.add(Shop(7, "Electronics Hub", "404 Walnut Dr", 4.6f, ImageUrls.ELECTRONICS_HUB))
        shopList.add(Shop(8, "Jewelry Palace", "505 Birch Ave", 4.8f, ImageUrls.JEWELRY_PALACE))
        shopList.add(Shop(9, "Supermarket Plus", "606 Spruce St", 4.1f, ImageUrls.SUPERMARKET_PLUS))
        shopList.add(
            Shop(
                10,
                "Cosmetics Corner",
                "707 Sycamore Rd",
                4.4f,
                ImageUrls.COSMETICS_CORNER
            )
        )

        return shopList
    }

}
