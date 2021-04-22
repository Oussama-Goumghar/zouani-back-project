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

    @JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "cours")
    private List<CoursItem> coursItems;


    public Cours(String code, String libelle, String detail, int duree, List<CoursItem> coursItems) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.detail = detail;
		this.duree = duree;
		this.coursItems = coursItems;
	}

	public Cours() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<CoursItem> getCoursItems() {
		return coursItems;
	}

	public void setCoursItems(List<CoursItem> coursItems) {
		this.coursItems = coursItems;
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
