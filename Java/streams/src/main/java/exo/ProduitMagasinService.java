package exo;

import exo.models.Produit;

import java.util.List;
import java.util.Optional;

public interface ProduitMagasinService {
    boolean insertproduct(int idmagasin, int idproduit);
    boolean deleteproduct(int idmagasin, int idproduit);

    List<Produit> getAllbyMagasin(int idmagasin);
}
