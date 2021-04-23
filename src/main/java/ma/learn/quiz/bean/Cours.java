package ma.learn.quiz.bean;



import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


@Entity
public class Cours {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private String libelle ;
    private String detail ;
    private int duree;

    @ManyToOne
    private Parcours parcours;


    public Cours(String code, String libelle, String detail, int duree) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.detail = detail;
		this.duree = duree;
		
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

	public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    


}
