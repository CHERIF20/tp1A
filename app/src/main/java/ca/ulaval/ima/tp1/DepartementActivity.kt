package ca.ulaval.ima.tp1

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
class DepartementActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_departement)
        title="UlavalActivity"
        val webView = findViewById<WebView>(R.id.webViewDepartement)
        webView.settings.javaScriptEnabled = true
        val urlDepartement = intent.getStringExtra("urlDepartement")
        if (urlDepartement != null) {
            webView.loadUrl(urlDepartement)
        }
    }
}