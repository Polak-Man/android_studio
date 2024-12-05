package com.example.super_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Aff_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aff) // Vérifiez que ce layout existe

        // Lier le bouton "Accueil" pour rediriger vers MainActivity
        findViewById<Button>(R.id.Accueil).setOnClickListener {
            // Démarrer Ajout_Dep_Activity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
