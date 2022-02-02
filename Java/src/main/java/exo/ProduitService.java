package exo;

import exo.models.Produit;
import exo.models.ProduitForm;

import java.text.Normalizer;
import java.util.Comparator;
import java.util.List;

public interface ProduitService {
    List<Produit> getAll();
    Produit getOne(int id);

    boolean insert(Produit toAdd);
    Produit delete(int id);

    List<Produit> getAllSorted(Comparator<Produit> comparator);
    Produit getCheapest();
    Produit getMostExpensive();

    List<Produit> getAllByBrand(String brand);

    void update(int id, ProduitForm p);

}
