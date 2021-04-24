package ma.learn.quiz.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Entity;
import org.springframework.data.annotation.Id;
@Entity
public class Parcours implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private String libelle;
    private String description ;
    //@Temporal(TemporalType.DATE)
    private Date datePublication ;
   // @Temporal(TemporalType.DATE)
    private Date dateCreation ;

    private int numeroOrder;

	@ManyToOne
	private Centre centre;


	public Parcours(String ref, String libelle, String description, Date datePublication, Date dateCreation,
			int numeroOrder) {
		super();
		this.ref = ref;
		this.libelle = libelle;
		this.description = description;
		this.datePublication = datePublication;
		this.dateCreation = dateCreation;
		this.numeroOrder = numeroOrder;
	}

	public Parcours() {
		super();
		// TODO Auto-generated constructor stub
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

}
	