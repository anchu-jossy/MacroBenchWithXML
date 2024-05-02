package com.example.xmlandmacrobenchmark

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.xmlandmacrobenchmark.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val item_list = ArrayList<String>()
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize RecyclerView
        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        supportActionBar?.setDisplayShowTitleEnabled(true)
        // Initialize Adapter
        val adapter = ItemAdapter(item_list, object : ItemAdapter.OnItemClickListener{
            override fun onClicking() {
            startActivity(Intent(this@MainActivity,ShopListActivity::class.java))
            }

        })
        binding.recyclerView.adapter = adapter

        // Set click listener for the button
        binding.exploreButton.setOnClickListener {

            item_list.add("Floor$counter")
            counter += 1
            // Update the RecyclerView
            adapter.notifyDataSetChanged()
            // Optionally, you can scroll to the last added item
            binding.recyclerView.scrollToPosition(item_list.size - 1)

        }
    }
}

