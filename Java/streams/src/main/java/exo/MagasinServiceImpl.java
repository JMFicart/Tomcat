package exo;

import exo.models.Magasin;
import exo.models.Produit;

import java.util.ArrayList;
import java.util.List;

public class MagasinServiceImpl implements MagasinService{
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
    public List<Magasin> getAllName() {
        return listemagasin;
    }

    @Override
    public Magasin getOne(int id) {
        return null;
    }

    @Override
    public boolean insert(Magasin toAdd) {
        return false;
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

