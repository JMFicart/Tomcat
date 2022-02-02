package exo.Exceptions;

public class NoProduitException extends RuntimeException {
    public NoProduitException() {
        super("Il n'y a pas de produit !");
    }
}
