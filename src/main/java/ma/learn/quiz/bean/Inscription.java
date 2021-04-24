package ma.learn.quiz.bean;


	import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

	@Entity
	public class Inscription  {
		 @Id
		    @GeneratedValue(strategy = GenerationType.AUTO)
		    private Long id ;
		    private String numeroInscription;
		    private String ref;
		   @ManyToOne
		   private Parcours parcours;
		
		
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
			public String getRef() {
				return ref;
			}
			public void setRef(String ref) {
				this.ref = ref;
			}
			public Parcours getParcours() {
				return parcours;
			}
			public void setParcours(Parcours parcours) {
				this.parcours = parcours;
			}
			
			
			
		
			
			
		   

	}



