package ma.learn.quiz.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
public class Parcours {
	  @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	    private String code;
	    private String libelle;
	    private String ref;
	    @OneToOne
	    private Centre centre;
	  
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
		public Centre getCentre() {
			return centre;
		}
		public void setCentre(Centre centre) {
			this.centre = centre;
		}
		public String getRef() {
			return ref;
		}
		public void setRef(String ref) {
			this.ref = ref;
		}
		
}
	