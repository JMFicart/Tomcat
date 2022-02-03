package exo;

import exo.models.Magasin;
import exo.models.Produit;
import java.util.List;

public interface MagasinService {
    int getIdMagasin();
    String getNomMagasin();
    Magasin getOne(int id);
    List<Magasin> getAllName();
    boolean insert(Magasin toAdd);
    boolean insertproduct(int id, Produit toAdd);
    boolean deleteproduct(int idmagasin, Produit toDelete);
}
