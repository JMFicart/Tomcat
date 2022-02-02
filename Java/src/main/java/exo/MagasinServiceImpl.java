package exo;

import exo.Exceptions.ProduitNotFoundException;
import exo.models.Magasin;
import exo.models.Produit;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MagasinServiceImpl implements MagasinService{
    private int idMagasin;
    private String nomMagasin;

    private static MagasinServiceImpl _instance;
    public static MagasinServiceImpl getinstance(){
        return _instance == null ? _instance = new MagasinServiceImpl() : _instance;
    }

    public MagasinServiceImpl() {
        listemagasin.add(new Magasin(1,"Nord", "Rue du pont", "Namur", "5000", 1, 20.00));
        listemagasin.add(new Magasin(2,"Centre", "Rue des Guillemins", "Liège", "4000", 15, 50.00));
    }

    private final List<Magasin> listemagasin = new ArrayList<>();

    @Override
    public int getIdMagasin(){
        return idMagasin;
    }

    @Override
    public String getNomMagasin(){
        return nomMagasin;
    }

    public void setNomMagasin(Magasin mag){
        nomMagasin = mag.getNom();
    }

    @Override
    public Magasin getOne(int id) {
        Optional<Magasin> magasin = listemagasin.stream().filter(p -> p.getUniqueid() == id).findFirst();
        idMagasin = id;
//        setNomMagasin(magasin);
        return magasin.orElseThrow(ProduitNotFoundException::new);
    }

    @Override
    public List<Magasin> getAllName() {
        return listemagasin;
    }

    @Override
    public boolean insert(Magasin toAdd) {
        boolean rslt = false;
        if (toAdd != null && !listemagasin.stream().anyMatch(p -> p.getUniqueid() == toAdd.getUniqueid())) {
            listemagasin.add(toAdd);
            rslt = true;
        }
        return rslt;
    }

    @Override
    public boolean insertproduct(int id, Produit toAdd) {
        return false;
    }

    @Override
    public boolean deleteproduct(int idmagasin, Produit toDelete) {
        return false;
    }
}

