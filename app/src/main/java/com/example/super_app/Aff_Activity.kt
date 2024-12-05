package com.example.super_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.super_app.element_liste

class HistoryActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var elementListe: ArrayList<element_liste>
    private lateinit var adapter: ElementListeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        elementListe = ArrayList()
        loadElements()
        adapter = ElementListeAdapter(this, elementListe)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun loadElements() {

        elementListe.add(element_liste("Item 1","Description 1", "Description 1" ,"Description 1"))
        elementListe.add(element_liste("Item 2", "Description 2" ,"Description 2","Description 2"))
        elementListe.add(element_liste("Item 3","Description 3","Description 3", "Description 3"))
    }
}

