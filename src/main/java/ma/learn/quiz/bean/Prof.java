package ma.learn.quiz.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "responsable")
    private List<ClassRoom> classRooms ;
    
    
    
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
}
