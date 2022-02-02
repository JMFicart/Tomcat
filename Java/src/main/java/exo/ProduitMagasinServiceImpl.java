package exo;

import exo.Exceptions.ProduitNotFoundException;
import exo.models.ProduitMagasin;
import exo.models.Produit;

import java.util.ArrayList;
import java.util.List;

public class ProduitMagasinServiceImpl implements ProduitMagasinService{
    ProduitServiceImpl produitservice = ProduitServiceImpl.getinstance();

    private static ProduitMagasinServiceImpl _instance;
    public static ProduitMagasinServiceImpl getinstance(){
        return _instance == null ? _instance = new ProduitMagasinServiceImpl() : _instance;
    }

    public ProduitMagasinServiceImpl() {
        listeproduitmagasin.add(new ProduitMagasin(1, 1));
        listeproduitmagasin.add(new ProduitMagasin(1, 2));
        listeproduitmagasin.add(new ProduitMagasin(2, 1));
        listeproduitmagasin.add(new ProduitMagasin(2, 2));
    }

    private final List<ProduitMagasin> listeproduitmagasin = new ArrayList<>();

    @Override
    public boolean insertproduct(int idmagasin, int idproduit) {
        boolean rslt = false;
        if (listeproduitmagasin.stream().filter(p -> p.getIdMagasin() == idmagasin && p.getIdProduit() == idproduit).count() == 0){
            listeproduitmagasin.add(new ProduitMagasin(idmagasin,idproduit));
            rslt = true;
        }
        return rslt;
    }

    @Override
    public boolean deleteproduct(int idmagasin, int idproduit) {
        return false;
    }

    @Override
    public List<Produit> getAllbyMagasin(int idMagasin) {
        List<Produit> lp = new ArrayList<>();
        Produit prod;

        for (ProduitMagasin pm : _instance.listeproduitmagasin)
        {
            if (pm.getIdMagasin() == idMagasin){
                prod = produitservice.getAll().stream().filter(p -> p.getId() == pm.getIdProduit()).findFirst().orElseThrow(ProduitNotFoundException::new);
                lp.add(prod);
            }
        }
        return lp;
    }
}
