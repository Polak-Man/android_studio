package com.example.super_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.Manifest
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {
    private var isDarkTheme = false // Variable pour suivre l'état du thème

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

        // Vérifier les permissions
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 1)
        }

        // Lier le bouton "button_ajout_dep" pour rediriger vers AjoutDepActivity
        findViewById<Button>(R.id.button_ajout_dep).setOnClickListener {
            val intent = Intent(this, AjoutDepActivity::class.java)
            startActivity(intent)
        }

        // Lier le bouton "button_stats" pour rediriger vers Stats
        findViewById<Button>(R.id.button_stats).setOnClickListener {
            val intent = Intent(this, Stats::class.java)
            startActivity(intent)
        }

        // Lier le bouton "aff_dep" pour rediriger vers Aff_activity
        findViewById<Button>(R.id.aff_dep).setOnClickListener {
            val intent = Intent(this, Aff_Activity::class.java)
            startActivity(intent)
        }

        // Lier le bouton "param" pour rediriger vers Parametres
        findViewById<Button>(R.id.param).setOnClickListener {
            val intent = Intent(this, Parametres::class.java)
            startActivity(intent)
        }

        // Lier le bouton "button_theme" pour changer le thème
        findViewById<Button>(R.id.button_theme).setOnClickListener {
            toggleTheme()
        }
    }

    private fun toggleTheme() {
        isDarkTheme = !isDarkTheme // Inverser l'état du thème
        if (isDarkTheme) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES) // Activer le mode sombre
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO) // Activer le mode clair
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1 && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            // Permissions accordées, vous pouvez accéder au stockage externe ici
        }
    }
}