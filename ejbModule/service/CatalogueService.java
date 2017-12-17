package service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import metier.ICatalogueLocal;
import metier.Produit;

@Stateless
@WebService
public class CatalogueService {
    @EJB
	private ICatalogueLocal metier;
    @WebMethod
    public List<Produit> consulterProduits(@WebParam(name="motcle") String motcle){
    	return metier.getProduitsParMC(motcle);
    }
}
