package ma.learn.quiz.bean;


	import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

	@Entity
	public class Inscription  {
		 @Id
		    @GeneratedValue(strategy = GenerationType.AUTO)
		    private Long id ;
		    private String numeroInscription;
		    @Temporal (TemporalType.DATE)
		   private Date date_debut_inscription;
		    @Temporal (TemporalType.DATE)
			   private Date date_fin_inscription;
		    
		   @ManyToOne
		   private Parcours parcours;
		  
		   @OneToOne
		   private Etudiant etudiant;
		   @OneToOne
		   private EtatInscription etatInscription;
		   
		
		
			public Long getId() {
				return id;
			}
			public void setId(Long id) {
				this.id = id;
			}
			
			
			public String getNumeroInscription() {
				return numeroInscription;
			}
			public void setNumeroInscription(String numeroInscription) {
				this.numeroInscription = numeroInscription;
			}
			
			public Date getDate_debut_inscription() {
				return date_debut_inscription;
			}
			public void setDate_debut_inscription(Date date_debut_inscription) {
				this.date_debut_inscription = date_debut_inscription;
			}
			public Date getDate_fin_inscription() {
				return date_fin_inscription;
			}
			public void setDate_fin_inscription(Date date_fin_inscription) {
				this.date_fin_inscription = date_fin_inscription;
			}
			public EtatInscription getEtatInscription() {
				return etatInscription;
			}
			public void setEtatInscription(EtatInscription etatInscription) {
				this.etatInscription = etatInscription;
			}
			public Parcours getParcours() {
				return parcours;
			}
			public void setParcours(Parcours parcours) {
				this.parcours = parcours;
			}
			
			public Etudiant getEtudiant() {
				return etudiant;
			}
			public void setEtudiant(Etudiant etudiant) {
				this.etudiant = etudiant;
			}
			
			
			
		
			
			
		   

	}



