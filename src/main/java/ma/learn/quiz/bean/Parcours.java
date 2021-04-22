package ma.learn.quiz.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
public class Parcours {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private String libelle;
    private double duree;
    @JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy="parcours")
    private List<ParcoursItem> parcoursItems;


	

	public Parcours(String code, String libelle, double duree, List<ParcoursItem> parcoursItems) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.duree = duree;
		this.parcoursItems = parcoursItems;
	}

	public Parcours() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<ParcoursItem> getParcoursItems() {
		return parcoursItems;
	}

	public void setParcoursItems(List<ParcoursItem> parcoursItems) {
		this.parcoursItems = parcoursItems;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String ref) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }



    public double getDuree() {
        return duree;
    }

    public void setDuree(double duree) {
        this.duree = duree;
    }


}
