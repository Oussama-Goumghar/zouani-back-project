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
	private String ref;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Prof prof;
	
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
	public Prof getProf() {
		return prof;
	}
	public void setProf(Prof prof) {
		this.prof = prof;
	}
	public int getNombrevote() {
		return nombrevote;
	}
	public void setNombrevote(int nombrevote) {
		this.nombrevote = nombrevote;
	}
	

}
