package ma.learn.quiz.bean;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Entity;
import org.springframework.data.annotation.Id;

@Entity
public class CategorieSection implements Serializable{

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private String libelle;
    private int numeroOrdre;

  @ManyToOne
  private SuperCategorieSection superCategorieSection;

    
   
	public CategorieSection() {
	super();
	// TODO Auto-generated constructor stub
}

	



	public CategorieSection(String ref, String libelle, int numeroOrdre, SuperCategorieSection superCategorieSection) {
		super();
		this.ref = ref;
		this.libelle = libelle;
		this.numeroOrdre = numeroOrdre;
		this.superCategorieSection = superCategorieSection;
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
