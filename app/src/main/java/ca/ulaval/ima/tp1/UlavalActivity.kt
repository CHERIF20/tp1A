package ca.ulaval.ima.tp1

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class UlavalActivity : AppCompatActivity() {
    private lateinit var webView: WebView
    private var currentZoomLevel = 21 // Niveau de zoom par défaut

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ulaval)
        title = "TP1"

        val urlUlaval = intent.getStringExtra("urlUlaval")

        // Initialisation du WebView
        webView = findViewById(R.id.webView)
        webView.settings.apply {
            javaScriptEnabled = true
            setSupportZoom(true)
            builtInZoomControls = true
            displayZoomControls = false // Cache les contrôles de zoom par défaut
        }

        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                webView.evaluateJavascript(
                    """
                    (function() {
                        var map = document.querySelector('iframe').contentWindow.google.maps.Map;
                        if (map) {
                            map.setZoom($currentZoomLevel);
                        }
                    })();
                    """.trimIndent(), null
                )
            }
        }

        // Charger l'URL Google Maps
        if (urlUlaval != null) {
            webView.loadUrl(urlUlaval)
        }


        findViewById<Button>(R.id.button_fermer).setOnClickListener {
            finish()
        }
    }

}


