package metier;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface ICatalogueRemote {
   public void addProduit(Produit p);
   public List<Produit> getAllProduits();
   public List<Produit> getProduitsParMC(String mc);
   public Produit getProduit(Long id);
   public void removeProduit(Long id);
   public void updateProduit(Produit p);
}
