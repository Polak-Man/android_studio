package com.example.super_app;

public class element_liste {

    private String nom ;
    private String montant ;
    public String categorie ;
    private String date ;

    public element_liste(String nom, String categorie, String date, String montant) {
        this.nom = nom;
        this.categorie = categorie;
        this.date = date;
        this.montant = montant;
    }

    public String getMontant() {
        return montant;
    }

    public void setMontant(String montant) {
        this.montant = montant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCatégorie() {
        return categorie;
    }

    public void setCatégorie(String catégorie) {
        this.categorie = catégorie;
    }
}
