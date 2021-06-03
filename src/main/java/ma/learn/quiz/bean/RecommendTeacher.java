package ma.learn.quiz.bean;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class RecommendTeacher {
		 @Id
		   @GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
		private int nombrevote ;
		private String nom;
		private String prenom;
		private String Commentaire;
		private int telephone;
		private String login;
		@ManyToOne
		private Prof prof;
		
		
		public Prof getProf() {
			return prof;
		}
		public void setProf(Prof prof) {
			this.prof = prof;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		
		
		public int getNombrevote() {
			return nombrevote;
		}
		public void setNombrevote(int nombrevote) {
			this.nombrevote = nombrevote;
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
		public String getCommentaire() {
			return Commentaire;
		}
		public void setCommentaire(String commentaire) {
			Commentaire = commentaire;
		}
		public int getTelephone() {
			return telephone;
		}
		public void setTelephone(int telephone) {
			this.telephone = telephone;
		}
		public String getLogin() {
			return login;
		}
		public void setLogin(String login) {
			this.login = login;
		}
		

	
	

}
