package com.example.learning_bugeto

import android.annotation.SuppressLint
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import com.example.learning_bugeto.databinding.ActivityWebViewBinding

class WebView : AppCompatActivity() {
    lateinit var binding: ActivityWebViewBinding

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.progressCircular.visibility = View.VISIBLE
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.settings.setSupportZoom(true)
        binding.webView.webViewClient =object :WebViewClient(){

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                if (binding.progressCircular.visibility == View.VISIBLE){
                    binding.progressCircular.visibility = View.GONE
                }
            }

        }
        binding.webView.loadUrl("https://bugeto.net/courses/kotlin-language-course")

    }

    override fun onBackPressed() {
        if (binding.webView.canGoBack()){
            binding.webView.goBack()
        }else {
            super.onBackPressed()
        }
    }

}