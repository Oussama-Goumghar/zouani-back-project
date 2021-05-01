package ma.learn.quiz.bean;



import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;



@Entity
public class Cours implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private String libelle ;
    private String description ;
    private int nombreContenuFinalise ;
    private int nombreContenuEnCours ;
    private int nombreLienFinalise ;
    private int nombreLienEnCours;
    private int numeroOrder;
    @ManyToOne
    private Parcours parcours;
    
   @JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy="cours")
    private List<Section> sections;
   
	public Cours(String ref, String libelle, String description, int nombreContenuFinalise, int nombreContenuEnCours,
			int nombreLienFinalise, int nombreLienEnCourse, int numeroOrder, Parcours parcours,
			List<Section> sections) {
		super();
		this.ref = ref;
		this.libelle = libelle;
		this.description = description;
		this.nombreContenuFinalise = nombreContenuFinalise;
		this.nombreContenuEnCours = nombreContenuEnCours;
		this.nombreLienFinalise = nombreLienFinalise;
		this.nombreLienEnCours = nombreLienEnCours;
		this.numeroOrder = numeroOrder;
		this.parcours = parcours;
		this.sections = sections;
	}

	public Cours() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Parcours getParcours() {
		return parcours;
	}

	public void setParcours(Parcours parcours) {
		this.parcours = parcours;
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



	public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}


	public int getNombreContenuFinalise() {
		return nombreContenuFinalise;
	}



	public void setNombreContenuFinalise(int nombreContenuFinalise) {
		this.nombreContenuFinalise = nombreContenuFinalise;
	}



	public int getNombreContenuEnCours() {
		return nombreContenuEnCours;
	}



	public void setNombreContenuEnCours(int nombreContenuEnCours) {
		this.nombreContenuEnCours = nombreContenuEnCours;
	}



	public int getNombreLienFinalise() {
		return nombreLienFinalise;
	}



	public void setNombreLienFinalise(int nombreLienFinalise) {
		this.nombreLienFinalise = nombreLienFinalise;
	}



	public int getNombreLienEnCours() {
		return nombreLienEnCours;
	}



	public void setNombreLienEnCours(int nombreLienEnCours) {
		this.nombreLienEnCours = nombreLienEnCours;
	}



	public int getNumeroOrder() {
		return numeroOrder;
	}



	public void setNumeroOrder(int numeroOrder) {
		this.numeroOrder = numeroOrder;
	}



	public List<Section> getSections() {
		return sections;
	}



	public void setSections(List<Section> sections) {
		this.sections = sections;
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
		Cours other = (Cours) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

   

    


}
