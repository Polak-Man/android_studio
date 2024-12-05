package com.example.super_app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.super_app.element_liste

class ElementListeAdapter(
    private val context: Context,
    private val elements: List<element_liste>
) : RecyclerView.Adapter<ElementListeAdapter.ViewHolder>() {

    // Création de la vue pour chaque élément
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.card, parent, false)
        return ViewHolder(view)
    }

    // Liaison des données à la vue
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val element = elements[position]
        holder.title.text = element.nom
        holder.description.text = element.categorie
    }

    // Nombre total d'éléments
    override fun getItemCount(): Int = elements.size

    // Gestion des vues dans le RecyclerView
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.nom)
        val description: TextView = itemView.findViewById(R.id.categorie)
    }
}
