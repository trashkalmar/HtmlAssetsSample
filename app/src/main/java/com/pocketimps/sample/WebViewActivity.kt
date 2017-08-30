package com.pocketimps.sample

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.webkit.WebView

/**
 * WebView with selected item
 */
class WebViewActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)

        val webView = findViewById<WebView>(R.id.web_view)

        // Deserialize current data and extract URI of asset file
        val data = intent.getSerializableExtra(KEY_DATA) as ItemData
        webView.loadUrl(data.fileUri)
    }

    companion object {
        private const val KEY_DATA = "item data"

        /**
         * Starts activity with given [ItemData].
         */
        fun start(context: Context, data: ItemData) {
            val intent = Intent(context, WebViewActivity::class.java)
            intent.putExtra(KEY_DATA, data)
            context.startActivity(intent)
        }
    }
}
