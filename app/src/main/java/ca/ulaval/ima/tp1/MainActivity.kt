package ca.ulaval.ima.tp1

import Profil
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var profil: Profil
    private val urlDepartement = "https://www.fsg.ulaval.ca/departements/departement-de-genie-electrique-et-de-genie-informatique"
    private val urlUlaval = "https://www.google.com/maps/place/Université+Laval/@46.7793,-71.2765,17z"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialisation du profil
        profil = Profil(
            "Barry",
            "Ramatoulaye Sidy Cherif",
            Calendar.getInstance().apply { set(2000, 0, 1) },
            "536 905 721"
        )

        // Configuration des boutons
        findViewById<Button>(R.id.btnUlaval).setOnClickListener {
            val intent = Intent(this, UlavalActivity::class.java)
            intent.putExtra("urlUlaval", urlUlaval)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnDepartement).setOnClickListener {
            val intent = Intent(this, DepartementActivity::class.java)
            intent.putExtra("urlDepartement", urlDepartement)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnProfil).setOnClickListener {
            val intent = Intent(this, ProfilActivity::class.java)
            intent.putExtra("profil", profil)
            startActivity(intent)
        }
    }
}