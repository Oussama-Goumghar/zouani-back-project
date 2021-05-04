package ma.learn.quiz.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
public class Parcours implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private String libelle;
    private String description ;
    @Temporal(TemporalType.DATE)
    private Date datePublication ;
   @Temporal(TemporalType.DATE)
    private Date dateCreation ;
    private int numeroOrder;
    private int nombreCours;
    @JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy="parcours")
    private List<Cours> courss;
	@ManyToOne
	private Centre centre;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "parcours")
     private List<Etudiant> etudiant;

	

	


	


	public Parcours(String ref, String libelle, String description, Date datePublication, Date dateCreation,
			int numeroOrder, int nombreCours, List<Cours> courss, Centre centre, List<Etudiant> etudiant) {
		super();
		this.ref = ref;
		this.libelle = libelle;
		this.description = description;
		this.datePublication = datePublication;
		this.dateCreation = dateCreation;
		this.numeroOrder = numeroOrder;
		this.nombreCours = nombreCours;
		this.courss = courss;
		this.centre = centre;
		this.etudiant = etudiant;
	}

	public int getNombreCours() {
		return nombreCours;
	}

	public void setNombreCours(int nombreCours) {
		this.nombreCours = nombreCours;
	}

	public List<Etudiant> getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(List<Etudiant> etudiant) {
		this.etudiant = etudiant;
	}

	public Parcours() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Cours> getCourss() {
		return courss;
	}

	public void setCourss(List<Cours> courss) {
		this.courss = courss;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDatePublication() {
		return datePublication;
	}

	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public Centre getCentre() {
		return centre;
	}

	public void setCentre(Centre centre) {
		this.centre = centre;
	}

	public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

	public int getNumeroOrder() {
		return numeroOrder;
	}

	public void setNumeroOrder(int numeroOrder) {
		this.numeroOrder = numeroOrder;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parcours other = (Parcours) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
	