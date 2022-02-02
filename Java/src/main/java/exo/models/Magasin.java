package exo.models;

import java.util.ArrayList;
import java.util.List;

public class Magasin{
    private int uniqueid;
    private String nom;
    private String rue;
    private String ville;
    private String codepostal;
    private int numero;
    private double superficie;
    private final List<ProduitMagasin> listeproduits = new ArrayList<>();

    public Magasin(int uniqueid, String nom, String rue, String ville, String codepostal, int numero, double superficie) {
        this.uniqueid = uniqueid;
        this.nom = nom;
        this.rue = rue;
        this.ville = ville;
        this.codepostal = codepostal;
        this.numero = numero;
        this.superficie = superficie;
    }

    public int getUniqueid() {
        return uniqueid;
    }

    public void setUniqueid(int uniqueid) {
        this.uniqueid = uniqueid;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodepostal() {
        return codepostal;
    }

    public void setCodepostal(String codepostal) { this.codepostal = codepostal; }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public List<ProduitMagasin> getListeproduits() {
        return listeproduits;
    }
}
