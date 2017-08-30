package com.pocketimps.sample

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

/**
 * List of items. Clicking on item opens activity with HTML.
 */
class ListActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        // Create adapter with list of items
        val adapter = ListAdapter()
        adapter.setData(listOf(ItemData("File 1", "file:///android_asset/file1.html"),
                               ItemData("File 2", "file:///android_asset/file2.html"),
                               ItemData("File 3", "file:///android_asset/file3.html"),
                               ItemData("File 4", "file:///android_asset/file4.html"),
                               ItemData("File 5", "file:///android_asset/file5.html")))

        // Add reaction on click
        adapter.itemClickListener = { data ->
            WebViewActivity.start(this, data)
        }

        // Init recycler and set adapter
        val recycler = findViewById<RecyclerView>(R.id.recycler)
        recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler.adapter = adapter
    }
}
