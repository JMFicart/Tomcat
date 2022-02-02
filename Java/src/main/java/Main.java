import exo.models.Produit;
import exo.ProduitServiceImpl;

public class Main {
    public static void main(String[] args) {
        ProduitServiceImpl ps = ProduitServiceImpl.getinstance() ;

        System.out.println("--------- Initialisation liste -----------");
        System.out.println(ps.getAll());

        System.out.println("--------- Insertion 2 articles -----------");
        ps.insert(new Produit(10, "Lait", "Campina", 2));
        ps.insert(new Produit(15, "Crême", "Campina", 1));

        System.out.println("--------- Affichage liste -----------");
        System.out.println(ps.getAll());
        System.out.println(ps.getOne(10));
        System.out.println(ps.getOne(15));
        System.out.println(ps.getOne(20));

        System.out.println("--------- Insertion 1 article -----------");
        ps.insert(new Produit(20, "Rhum", "Negrita", 15));
        System.out.println(ps.getAll());

        System.out.println("--------- Suppression 1 article -----------");
        ps.delete(20);
        System.out.println(ps.getAll());

        System.out.println("--------- Recherche du moins cher -----------");

    }
}
