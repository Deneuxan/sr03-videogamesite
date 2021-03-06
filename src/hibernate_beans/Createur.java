package hibernate_beans;
// Generated 2017-4-28 5:44:07 by Hibernate Tools 5.2.1.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Createur generated by hbm2java
 */
@Entity
@Table(name = "createur")
public class Createur implements java.io.Serializable {

	private int idCreateur;
	private String nom;
	private String descriptionCreateur;
	private Set<Jeux> jeuxes = new HashSet<Jeux>(0);

	public Createur() {
	}

	public Createur(int idCreateur, String nom, String descriptionCreateur) {
		this.idCreateur = idCreateur;
		this.nom = nom;
		this.descriptionCreateur = descriptionCreateur;
	}

	public Createur(int idCreateur, String nom, String descriptionCreateur, Set<Jeux> jeuxes) {
		this.idCreateur = idCreateur;
		this.nom = nom;
		this.descriptionCreateur = descriptionCreateur;
		this.jeuxes = jeuxes;
	}

	@Id

	@Column(name = "id_createur", unique = true, nullable = false)
	public int getIdCreateur() {
		return this.idCreateur;
	}

	public void setIdCreateur(int idCreateur) {
		this.idCreateur = idCreateur;
	}

	@Column(name = "nom", nullable = false, length = 100)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "description_createur", nullable = false, length = 1000)
	public String getDescriptionCreateur() {
		return this.descriptionCreateur;
	}

	public void setDescriptionCreateur(String descriptionCreateur) {
		this.descriptionCreateur = descriptionCreateur;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "createur")
	public Set<Jeux> getJeuxes() {
		return this.jeuxes;
	}

	public void setJeuxes(Set<Jeux> jeuxes) {
		this.jeuxes = jeuxes;
	}

}
