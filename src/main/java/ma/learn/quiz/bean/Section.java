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

	private long id;
	private String ref;
	private String libelle;
	private String detail;
	
	private String urlimage;
	private String urlvideo;

	@ManyToOne
	  private Cours cours;


	public Section(String ref, String libelle, String detail, String urlimage, String urlvideo) {
		super();
		this.ref = ref;
		this.libelle = libelle;
		this.detail = detail;
		this.urlimage = urlimage;
		this.urlvideo = urlvideo;
	}


	public Cours getCours() {
		return cours;
	}


	public void setCours(Cours cours) {
		this.cours = cours;
	}


	public Section() {
		super();
		// TODO Auto-generated constructor stub
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


	public String getDetail() {
		return detail;
	}


	public void setDetail(String detail) {
		this.detail = detail;
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
