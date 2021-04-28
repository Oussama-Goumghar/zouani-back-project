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
public class CategorieSection implements Serializable{

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private String libelle;
    private int numeroOrdre;

  @ManyToOne
  private SuperCategorieSection superCategorieSection;
  
  @JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
  @OneToMany(mappedBy="cours")
  private List<Section> sections;
    
   
	public List<Section> getSections() {
	return sections;
}





public void setSections(List<Section> sections) {
	this.sections = sections;
}





	public CategorieSection() {
	super();
	// TODO Auto-generated constructor stub
}





	public CategorieSection(String ref, String libelle, int numeroOrdre, SuperCategorieSection superCategorieSection,
			List<Section> sections) {
		super();
		this.ref = ref;
		this.libelle = libelle;
		this.numeroOrdre = numeroOrdre;
		this.superCategorieSection = superCategorieSection;
		this.sections = sections;
	}





	public SuperCategorieSection getSuperCategorieSection() {
		return superCategorieSection;
	}

	public void setSuperCategorieSection(SuperCategorieSection superCategorieSection) {
		this.superCategorieSection = superCategorieSection;
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

    public int getNumeroOrdre() {
        return numeroOrdre;
    }

    public void setNumeroOrdre(int numeroOrdre) {
        this.numeroOrdre = numeroOrdre;
    }


}
