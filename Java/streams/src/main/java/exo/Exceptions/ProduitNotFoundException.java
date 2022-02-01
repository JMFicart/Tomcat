package exo.Exceptions;

public class ProduitNotFoundException extends RuntimeException {
    public ProduitNotFoundException() {
        super("Le produit demandé n'est pas disponible.");
    }
}
