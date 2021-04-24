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
public class Section {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id ;
	  public String ref ;
	  public String libelle ;
	  public String contenu ;
	  public String urlimage ;
	  public String urlvideo ;
	  public String urlimage2 ;
	  public String urlimage3 ;
	  public String questions ;
	  public String indicationProf ;
	  public int nombreContenuFinalise ;
	  public int nombreContenuEnCours ;
	  public int nombreLienFinalise ;
	  public int nombreLienEnCourse;
	  @ManyToOne
	  public CategorieSection categorieSection;
	@ManyToOne
	  private Cours cours;

	public Section() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Section(String ref, String libelle, String contenu, String urlimage, String urlvideo, String urlimage2,
			String urlimage3, String questions, String indicationProf, int nombreContenuFinalise,
			int nombreContenuEnCours, int nombreLienFinalise, int nombreLienEnCourse,
			CategorieSection categorieSection, Cours cours) {
		super();
		this.ref = ref;
		this.libelle = libelle;
		this.contenu = contenu;
		this.urlimage = urlimage;
		this.urlvideo = urlvideo;
		this.urlimage2 = urlimage2;
		this.urlimage3 = urlimage3;
		this.questions = questions;
		this.indicationProf = indicationProf;
		this.nombreContenuFinalise = nombreContenuFinalise;
		this.nombreContenuEnCours = nombreContenuEnCours;
		this.nombreLienFinalise = nombreLienFinalise;
		this.nombreLienEnCourse = nombreLienEnCourse;
		this.categorieSection = categorieSection;
		this.cours = cours;
	}


	public String getContenu() {
		return contenu;
	}


	public void setContenu(String contenu) {
		this.contenu = contenu;
	}


	public String getUrlimage2() {
		return urlimage2;
	}


	public void setUrlimage2(String urlimage2) {
		this.urlimage2 = urlimage2;
	}


	public String getUrlimage3() {
		return urlimage3;
	}


	public void setUrlimage3(String urlimage3) {
		this.urlimage3 = urlimage3;
	}


	public String getQuestions() {
		return questions;
	}


	public void setQuestions(String questions) {
		this.questions = questions;
	}


	public String getIndicationProf() {
		return indicationProf;
	}


	public void setIndicationProf(String indicationProf) {
		this.indicationProf = indicationProf;
	}


	

	public int getNombreContenuFinalise() {
		return nombreContenuFinalise;
	}

	public void setNombreContenuFinalise(int nombreContenuFinalise) {
		this.nombreContenuFinalise = nombreContenuFinalise;
	}

	public int getNombreContenuEnCours() {
		return nombreContenuEnCours;
	}

	public void setNombreContenuEnCours(int nombreContenuEnCours) {
		this.nombreContenuEnCours = nombreContenuEnCours;
	}

	public int getNombreLienFinalise() {
		return nombreLienFinalise;
	}

	public void setNombreLienFinalise(int nombreLienFinalise) {
		this.nombreLienFinalise = nombreLienFinalise;
	}

	public int getNombreLienEnCourse() {
		return nombreLienEnCourse;
	}

	public void setNombreLienEnCourse(int nombreLienEnCourse) {
		this.nombreLienEnCourse = nombreLienEnCourse;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CategorieSection getCategorieSection() {
		return categorieSection;
	}


	public void setCategorieSection(CategorieSection categorieSection) {
		this.categorieSection = categorieSection;
	}


	


	public Cours getCours() {
		return cours;
	}


	public void setCours(Cours cours) {
		this.cours = cours;
	}


	


	public long getId() {
		return id;
	}


	public void setId(long id){
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


	


	public String getUrlimage() {
		return urlimage;
	}


	public void setUrlimage(String urlimage) {
		this.urlimage = urlimage;
	}


	public String getUrlvideo() {
		return urlvideo;
	}


	public void setUrlvideo(String urlvideo) {
		this.urlvideo = urlvideo;
	}

	
}
