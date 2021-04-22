package ma.learn.quiz.bean;


import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ParcoursItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private String libelle ;
    @ManyToOne
    private Parcours parcours;
    @ManyToOne
    private Cours cours;

    
    
    
	public ParcoursItem(String code, String libelle, Parcours parcours, Cours cours) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.parcours = parcours;
		this.cours = cours;
	}

	public ParcoursItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cours getCours() {
		return cours;
	}

	public void setCours(Cours cours) {
		this.cours = cours;
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

    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
		this.code = code;
	}
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

}
