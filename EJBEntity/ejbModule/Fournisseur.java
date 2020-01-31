import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="table_fournisseur")

public class Fournisseur implements Serializable{

	@Id
	private String id;
	@Column(name="nom_Column")
	private String nom;
	@OneToMany(mappedBy = "fourniseur")
	private List<Produit> produits;
	
	public Fournisseur() {super();}
	public Fournisseur(String id) {this.id = id;}
	public Fournisseur(String id, String libelle) {
		this.id = id;
		this.nom = libelle;
		
	}
	
}
