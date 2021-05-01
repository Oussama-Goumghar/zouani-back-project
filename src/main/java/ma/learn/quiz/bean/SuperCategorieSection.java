package ma.learn.quiz.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
public class SuperCategorieSection implements Serializable{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private String libelle;
    private int numeroOrder;
    @JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy="superCategorieSection")
    private List<CategorieSection> categorieSections;
	
    
    
	
	public SuperCategorieSection(String ref, String libelle, int numeroOrder,
			List<CategorieSection> categorieSections) {
		super();
		this.ref = ref;
		this.libelle = libelle;
		this.numeroOrder = numeroOrder;
		this.categorieSections = categorieSections;
	}

	public SuperCategorieSection() {
		super();
		// TODO Auto-generated constructor stub
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
	public int getNumeroOrder() {
		return numeroOrder;
	}
	public void setNumeroOrder(int numeroOrder) {
		this.numeroOrder = numeroOrder;
	}

	public List<CategorieSection> getCategorieSections() {
		return categorieSections;
	}

	public void setCategorieSections(List<CategorieSection> categorieSections) {
		this.categorieSections = categorieSections;
	}
    
}
