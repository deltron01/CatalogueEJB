package metier;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query; //cette implémentation représente l'EJB Session

@Stateless(name="CAT")
public class CatalogueEJBImpl implements ICatalogueLocal, ICatalogueRemote {
    @PersistenceContext(unitName="UP_CAT")
	private EntityManager em;
	@Override
	public void addProduit(Produit p) {
		em.persist(p);
	}

	@Override
	public List<Produit> getAllProduits() {
		Query req = em.createQuery("select p from Produit p");
		return req.getResultList();
	}

	@Override
	public List<Produit> getProduitsParMC(String mc) {
		Query req = em.createQuery("select p from Produit p where p.nomProduit like :x");
		req.setParameter("x", "%"+mc+"%");
		return req.getResultList();
	}

	@Override
	public Produit getProduit(Long id) {
		Produit p = em.find(Produit.class, id);
		return p;
	}

	@Override
	public void removeProduit(Long id) {
		Produit p = em.find(Produit.class, id);
		if(p == null) throw new RuntimeException(" -- Produit introuvable -- ");
		em.remove(p);
	}

	@Override
	public void updateProduit(Produit p) {
		Produit p1 = em.find(Produit.class, p.getIdProduit());
		p1.setPrix(p.getPrix());
		p1.setNomProduit(p.getNomProduit());
		em.persist(p1); // persist a 2 rôles : si l'element existe il le met à jour sinon il l'ajoute dans la table.
	}

}
