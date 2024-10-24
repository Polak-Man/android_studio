package com.example.super_app

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText


class AjoutDepActivity : AppCompatActivity() {

    lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ajout_dep) // Vérifiez que ce layout existe

        // Initialiser la base de données
        dbHelper = DatabaseHelper(this)

        val editText = findViewById<TextInputEditText>(R.id.nom_depense)
        val button = findViewById<Button>(R.id.valider_formulaire)

        // Action au clic du bouton : insérer la donnée dans la base de données
        button.setOnClickListener {
            val inputText = editText.text.toString()

            if (inputText.isNotEmpty()) {
                val isInserted = dbHelper.insertInput(inputText)

                if (isInserted) {
                    Toast.makeText(this, "Donnée insérée avec succès: $inputText", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Erreur lors de l'insertion", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Le champ est vide", Toast.LENGTH_SHORT).show()
            }
        }

        // Exemple pour récupérer et afficher toutes les entrées
        val allInputs = dbHelper.getAllInputs()
        for (input in allInputs) {
            Toast.makeText(this, "Entrée: $input", Toast.LENGTH_SHORT).show()

            // Lier le bouton "Accueil" pour rediriger vers MainActivity
            findViewById<Button>(R.id.Accueil).setOnClickListener {
                // Démarrer Ajout_Dep_Activity
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

        }
    }
}
