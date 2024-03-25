package com.example.xmlandmacrobenchmark

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.xmlandmacrobenchmark.databinding.ActivityShoplistBinding

class ShopListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShoplistBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShoplistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ShopListAdapter(this, getDummyShops())
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }
    private fun getDummyShops(): List<Shop> {
        return listOf(
            Shop(1, "Fashion Emporium", "123 Main St", 4.5f, "https://img.freepik.com/free-photo/cheerful-happy-woman-enjoying-shopping-summer-sale-she-is-carrying-shopping-bags-walking_74952-3018.jpg?t=st=1710765372~exp=1710768972~hmac=8406fa5df800660d681b2359c4b038b3918957d7aef802a0cb83d8229347c5d5&w=900",),
            Shop(2, "Dominos", "456 Elm St", 4.2f, "https://img.freepik.com/free-photo/pizza-pizza-filled-with-tomatoes-salami-olives_140725-1200.jpg?w=1380&t=st=1710765258~exp=1710765858~hmac=289cae493695f77e7f6ce7e062583f2afbd35a3d0d9144ca76a0920e8201de59",),
            Shop(3, "Gourmet Delights", "789 Oak Ave", 3.8f, "https://m.media-amazon.com/images/I/91LEZ08xKQL._SY522_.jpg",),
            Shop(4, "Books 'R' Us", "101 Maple Rd", 4.0f, "https://upload.wikimedia.org/wikipedia/commons/5/5a/Books_HD_%288314929977%29.jpg",),
            Shop(5, "Sports World", "202 Pine Ln", 4.7f, "https://howtodoandroid.com/images/coco.jpg",),
            Shop(6, "Home Decor Outlet", "303 Cedar Blvd", 4.3f, "https://as1.ftcdn.net/v2/jpg/02/93/78/86/1000_F_293788672_bVLNaF1WiQijdayoBGUjkxSipn99n34E.jpg",),
            Shop(7, "Electronics Hub", "404 Walnut Dr", 4.6f, "https://images.unsplash.com/photo-1588508065123-287b28e013da?q=80&w=2787&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",),
            Shop(8, "Jewelry Palace", "505 Birch Ave", 4.8f, "https://media.istockphoto.com/id/1891306687/photo/golden-pearl-retail-fake-jewllery-displayed-on-street-shop.jpg?s=1024x1024&w=is&k=20&c=lLWDhMGxqFcS3eKfgSfnAy7GtHyl4L51sKfJQzJikWg=",),
            Shop(9, "Supermarket Plus", "606 Spruce St", 4.1f, "https://plus.unsplash.com/premium_photo-1664202219877-b32fcd5aa731?q=80&w=2940&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",),
            Shop(10, "Cosmetics Corner", "707 Sycamore Rd", 4.4f, "https://images.unsplash.com/photo-1571875257727-256c39da42af?q=80&w=2960&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",)
        )
    }
}
