package exo.models;

public class ProduitForm {
    private String nom;
    private double prix;

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public ProduitForm(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
    }
}
