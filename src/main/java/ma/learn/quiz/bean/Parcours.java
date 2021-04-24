package ma.learn.quiz.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Parcours {
	  @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	   
	    private String libelle;
	    private String ref;
	    @ManyToOne
	    private Centre centre;
	  
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		
		public String getLibelle() {
			return libelle;
		}
		public void setLibelle(String libelle) {
			this.libelle = libelle;
		}
		
		public String getRef() {
			return ref;
		}
		public void setRef(String ref) {
			this.ref = ref;
		}
		public Centre getCentre() {
			return centre;
		}
		public void setCentre(Centre centre) {
			this.centre = centre;
		}
		
}
	