package exo;

import exo.Exceptions.NoProduitException;
import exo.Exceptions.ProduitNotFoundException;
import exo.models.Produit;
import exo.models.ProduitForm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProduitServiceImpl implements ProduitService {
    // region pattern singleton
    private static ProduitServiceImpl _instance;
    public static ProduitServiceImpl getinstance(){
        return _instance == null ? _instance = new ProduitServiceImpl() : _instance;
    }

    private ProduitServiceImpl(){
        liste.add(new Produit(1,"patate", "Les bons légumes", 10));
        liste.add(new Produit(2,"tomate", "Les bons légumes", 15));
    }
    //endregion

    private final List<Produit> liste = new ArrayList<>();

    @Override
    public List<Produit> getAll() {
        if (liste.size() > 0) {
            return liste;
        } else {
            return null;
        }
    }

    @Override
    public Produit getOne(int id) {
        Optional<Produit> prod = liste.stream().filter(p -> p.getId() == id).findFirst();
        return prod.orElseThrow(ProduitNotFoundException::new);
    }

    @Override
    public boolean insert(Produit toAdd) {
//        if ((liste.stream().noneMatch(p -> p.getId() == toAdd.getId())) && (toAdd.getId() != 0) && (toAdd.getNom() != null)) {
//            liste.add(new Produit(toAdd.getId(), toAdd.getNom(), toAdd.getMarque(), toAdd.getPrix()));
//            return true;
//        } else {
//            return false;
//        }
        boolean rslt = false;
        if (toAdd != null && !liste.stream().anyMatch(p -> p.getId() == toAdd.getId())) {
            liste.add(toAdd);
            rslt = true;
        }
        return rslt;
    }

    @Override
    public Produit delete(int id) {
        Produit p = getOne(id);
        liste.remove(p);
        return p;
    }

    @Override
    public List<Produit> getAllSorted(Comparator<Produit> comparator) {
        return liste.stream().sorted( comparator ).collect(Collectors.toList());
    }

    @Override
    public Produit getCheapest() {
        return liste.stream().min(Comparator.comparingDouble(Produit::getPrix)).orElseThrow(NoProduitException::new);
    }

    @Override
    public Produit getMostExpensive() {
        return liste.stream().max(Comparator.comparingDouble(Produit::getPrix)).orElseThrow(NoProduitException::new);
    }

    @Override
    public List<Produit> getAllByBrand(String brand) {
        return liste.stream().filter(p -> p.getMarque().equals(brand)).collect(Collectors.toList());
    }

    @Override
    public void update(int id, ProduitForm form) {
        Produit toUpdate = getOne(id);
        // Eventuellement faire içi une validation des données.
        toUpdate.setNom(form.getNom());
        toUpdate.setPrix(form.getPrix());
    }
}
