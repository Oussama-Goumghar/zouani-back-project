package ma.learn.quiz.bean;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Prof {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private long numero;
    private String nom;
    private String prenom;
    private String login;
	private String password;
	private String email;
	private String ref;
	
	@ManyToOne
	private CategorieProf categorieProf;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "responsable")
    private List<ClassRoom> classRooms ;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "prof")
    private List<RecommendTeacher> recommendTeacher ;
    
    
    
	public List<RecommendTeacher> getRecommendTeacher() {
		return recommendTeacher;
	}

	public void setRecommendTeacher(List<RecommendTeacher> recommendTeacher) {
		this.recommendTeacher = recommendTeacher;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<ClassRoom> getClassRooms() {
		return classRooms;
	}

	public void setClassRooms(List<ClassRoom> classRooms) {
		this.classRooms = classRooms;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

	

	public CategorieProf getCategorieProf() {
		return categorieProf;
	}

	public void setCategorieProf(CategorieProf categorieProf) {
		this.categorieProf = categorieProf;
	}
    
}
