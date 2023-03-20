package com.controversialz.gptassistant.chat

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.controversialz.gptassistant.R
import com.controversialz.gptassistant.databinding.ActivityMainBinding
import com.controversialz.gptassistant.databinding.FragmentChatBinding

class ChatFragment : Fragment(R.layout.fragment_chat) {
    private val binding by viewBinding(FragmentChatBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupWebView(binding.webview)
    }
    @SuppressLint("SetJavaScriptEnabled")
    private fun setupWebView(webView: WebView) {
        webView.apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
            settings.domStorageEnabled = true
            settings.setSupportZoom(false)
            settings.cacheMode=WebSettings.LOAD_CACHE_ELSE_NETWORK
            loadUrl("https://chat.openai.com/auth/login")
        }
    }
}