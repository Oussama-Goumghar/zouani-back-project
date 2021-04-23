package ma.learn.quiz.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ReponseEtudiant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String ref;
	@ManyToOne
	private Question question;
	@ManyToOne
	private Reponse reponse;
	@ManyToOne
	private Etudiant etudiant;
	@ManyToOne
	private QuizEtudiant quizEtudiant;
	
	private Double note;
	
	
	public QuizEtudiant getQuizEtudiant() {
		return quizEtudiant;
	}
	public void setQuizEtudiant(QuizEtudiant quizEtudiant) {
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
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public Reponse getReponse() {
		return reponse;
	}
	public void setReponse(Reponse reponse) {
		this.reponse = reponse;
	}
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	public Double getNote() {
		return note;
	}
	public void setNote(Double note) {
		this.note = note;
	}
	
	
	
}
