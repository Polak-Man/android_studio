package com.example.super_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Gestion de l'Edge-to-Edge pour les insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Lier le bouton "button_ajout_dep" pour rediriger vers AjoutDepActivity
        findViewById<Button>(R.id.button_ajout_dep).setOnClickListener {
            // Démarrer Ajout_Dep_Activity
            val intent = Intent(this, AjoutDepActivity::class.java)
            startActivity(intent)
        }
    }
}
