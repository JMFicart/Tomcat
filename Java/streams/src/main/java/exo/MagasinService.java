package exo;

import exo.models.Magasin;
import exo.models.Produit;

import java.util.ArrayList;
import java.util.List;

public interface MagasinService {
    List<Magasin> getAllName();
    Magasin getOne(int id);
    boolean insert(Magasin toAdd);
    boolean insertproduct(int id, Produit toAdd);
    boolean deleteproduct(int idmagasin, Produit toDelete);
}
