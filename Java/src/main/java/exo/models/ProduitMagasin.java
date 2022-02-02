package exo.models;

public class ProduitMagasin {
    private int idmagasin;
    private int idproduit;

    public ProduitMagasin(int idmagasin, int id) {
        this.idmagasin = idmagasin;
        this.idproduit = id;
    }

    public int getIdMagasin() {
        return idmagasin;
    }

    public void setIdMagasin(int id) {
        this.idmagasin = id;
    }

    public int getIdProduit() {
        return idproduit;
    }

    public void setIdProduit(int id) {
        this.idproduit = id;
    }
}
