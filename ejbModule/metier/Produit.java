package metier;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="PRODUITS")
public class Produit implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
// @Id permet de disigner lequel des attributs est la primar key au niveau de la table
    @Id  
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID_PRODUIT")
	private Long idProduit;
    @Column(name="NOM_PRODUIT")
	private String nomProduit;
	private double prix;
	
	public Produit(String nomProduit, double prix) {
		super();
		this.nomProduit = nomProduit;
		this.prix = prix;
	}
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}
	public String getNomProduit() {
		return nomProduit;
	}
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	
}
