package ma.learn.quiz.bean;



import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


@Entity
public class Cours {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private String libelle ;
    private String description ;
    private int nombreContenuFinalise ;
    private int nombreContenuEnCours ;
    private int nombreLienFinalise ;
    private int nombreLienEnCourse;
    private int numeroOrder;
    @ManyToOne
    private Parcours parcours;
    @JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
    @OneToMany
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
		this.nombreLienEnCourse = nombreLienEnCourse;
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



	public int getNombreLienEnCourse() {
		return nombreLienEnCourse;
	}



	public void setNombreLienEnCourse(int nombreLienEnCourse) {
		this.nombreLienEnCourse = nombreLienEnCourse;
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

   

    


}
