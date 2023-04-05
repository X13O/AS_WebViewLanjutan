package com.fadlizainuddin.webviewlanjutan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView _webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _webView = findViewById(R.id.webView);

        WebViewClient webViewClient = new WebViewClient();
        _webView.setWebViewClient(webViewClient);

        WebChromeClient webChromeClient = new WebChromeClient();
        _webView.setWebChromeClient(webChromeClient);

        WebSettings webSettings = _webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);

        WebAppInterface webAppInterface = new WebAppInterface(this, MainActivity.this);
        _webView.addJavascriptInterface(webAppInterface, "Android");

        String url = "https://202102266-fadlizainuddin.000webhostapp.com/";
        _webView.loadUrl(url);

    }
}