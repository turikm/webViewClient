package com.example.webview

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val context = this
        webview.webViewClient = MyWevViewClient()

        btnGo.setOnClickListener({
            webview.loadUrl("https://"+edtUrl.text.toString())
        })
///////////////////////////////////////////
        btnGoBack.setOnClickListener({
            if(webview.canGoBack())
                webview.goBack()
            else
                Toast.makeText(context,"No History Available",Toast.LENGTH_SHORT).show()
        })
///////////////////////////////////////////
        btnForward.setOnClickListener({
            if(webview.canGoForward())
                webview.goForward()
            else
                Toast.makeText(context,"No History Available",Toast.LENGTH_SHORT).show()
        })
    }

    class MyWevViewClient : WebViewClient()
    {
        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        override fun shouldOverrideUrlLoading(view: WebView?,request: WebResourceRequest?): Boolean
        {
            view?.loadUrl(request?.url.toString())
            return true
        }

        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean
        {
            view?.loadUrl(url.toString())
            return true
        }
    }
}