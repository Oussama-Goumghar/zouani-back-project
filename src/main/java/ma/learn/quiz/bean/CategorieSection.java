package ma.learn.quiz.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

@Entity
public class CategorieSection {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private String libelle;
    private int numeroOrdre;

  @ManyToOne
  private Section section;

    
   
	public CategorieSection() {
	super();
	// TODO Auto-generated constructor stub
}

	public CategorieSection(String ref, String libelle, int numeroOrdre, Section section) {
	super();
	this.ref = ref;
	this.libelle = libelle;
	this.numeroOrdre = numeroOrdre;
	this.section = section;
}

	public Section getSection() {
	return section;
}

public void setSection(Section section) {
	this.section = section;
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
