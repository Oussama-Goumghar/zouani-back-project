package ma.learn.quiz.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Etudiant {
	 @Id
	   @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	    private String ref;
	    private String nom;
	    private String prenom;
	    private int age;
	    private String login;
	    private String ville;
	    private String password;
	   private String etat;
	   
	    public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
		@ManyToOne
	    private Parcours parcours;
	   
	  
	    
	    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	    @OneToMany(mappedBy = "etudiant")
	     private List<QuizEtudiant> quizEtudiant;
	    
		
		
		public List<QuizEtudiant> getQuizEtudiant() {
			return quizEtudiant;
		}
		public void setQuizEtudiant(List<QuizEtudiant> quizEtudiant) {
			this.quizEtudiant = quizEtudiant;
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
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getVille() {
			return ville;
		}
		public void setVille(String ville) {
			this.ville = ville;
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
		public Parcours getParcours() {
			return parcours;
		}
		public void setParcours(Parcours parcours) {
			this.parcours = parcours;
		}
		
		
		
}