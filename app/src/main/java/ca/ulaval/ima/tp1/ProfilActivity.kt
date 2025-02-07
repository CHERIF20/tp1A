package ca.ulaval.ima.tp1

import Profil
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Locale

class ProfilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)
        title="ProfilDescription"
        val profil = intent.getParcelableExtra<Profil>("profil")
        profil?.let {
            val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            findViewById<TextView>(R.id.textViewPrenom).text = "Prénom : ${it.prenom}"
            findViewById<TextView>(R.id.textViewNom).text = "Nom de famille: ${it.nom}"
            findViewById<TextView>(R.id.textViewDateNaissance).text = "Date de naissance : ${dateFormat.format(it.dateNaissance.time)}"
            findViewById<TextView>(R.id.textViewIdul).text = "IDUL : ${it.idul}"
        }
    }
}