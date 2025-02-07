package ca.ulaval.ima.tp1

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker

class UlavalActivity : AppCompatActivity() {
    private lateinit var mapView: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ulaval)
        title="TP1"
        Configuration.getInstance().userAgentValue = packageName

        // Récupération de l'URL de Google Maps depuis l'intent
        val urlUlaval = intent.getStringExtra("urlUlaval")

        // Initialisation de la carte
        mapView = findViewById(R.id.mapView)
        mapView.setTileSource(TileSourceFactory.MAPNIK)

        // Coordonnées de l'emplacement
        val location = GeoPoint(46.7793, -71.2765)

        // Configuration du zoom et du centre de la carte
        mapView.controller.setZoom(22.0)
        mapView.controller.setCenter(location)
        addLocationMarker(location, "Université Laval")
        findViewById<Button>(R.id.button_fermer).setOnClickListener {
            finish()
        }
    }

    private fun addLocationMarker(location: GeoPoint, title: String) {
        val marker = Marker(mapView)

        marker.position = location

        marker.title = title

        val locationMarkerIcon: Drawable? = ContextCompat.getDrawable(this, R.drawable.marqueur)
        marker.icon = locationMarkerIcon

        mapView.overlays.add(marker)
        mapView.invalidate()
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }
}