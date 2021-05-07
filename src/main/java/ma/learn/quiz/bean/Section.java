package ma.learn.quiz.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Section implements Serializable{
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;

	    private String code;
	    private String libelle;
	    private String urlImage;
	    private String urlImage2;
	    private String urlImage3;
	    private String urlVideo;
	    private String contenu;
	    private String questions;
	    private String indicationProf;
	    private Integer numeroOrder;
	    @ManyToOne
	    private CategorieSection categorieSection;
	    @ManyToOne
	    private Cours cours;
	    private int url;
	    private int content;

	

	
	
 
	public Section(String code, String libelle, String urlImage, String urlImage2, String urlImage3,
				String urlVideo, String contenu, String questions, String indicationProf, Integer numeroOrder,
				CategorieSection categorieSection, Cours cours, int url, int content) {
			super();
			this.code = code;
			this.libelle = libelle;
			this.urlImage = urlImage;
			this.urlImage2 = urlImage2;
			this.urlImage3 = urlImage3;
			this.urlVideo = urlVideo;
			this.contenu = contenu;
			this.questions = questions;
			this.indicationProf = indicationProf;
			this.numeroOrder = numeroOrder;
			this.categorieSection = categorieSection;
			this.cours = cours;
			this.url = url;
			this.content = content;
		}

	public int getUrl() {
		return url;
	}

	public void setUrl(int url) {
		this.url = url;
	}

	public int getContent() {
		return content;
	}

	public void setContent(int content) {
		this.content = content;
	}

	public Integer getNumeroOrder() {
			return numeroOrder;
		}

		public void setNumeroOrder(Integer numeroOrder) {
			this.numeroOrder = numeroOrder;
		}

	public Section() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContenu() {
		return contenu;
	}


	public void setContenu(String contenu) {
		this.contenu = contenu;
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


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	



	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public String getUrlImage2() {
		return urlImage2;
	}

	public void setUrlImage2(String urlImage2) {
		this.urlImage2 = urlImage2;
	}

	public String getUrlImage3() {
		return urlImage3;
	}

	public void setUrlImage3(String urlImage3) {
		this.urlImage3 = urlImage3;
	}

	public String getUrlVideo() {
		return urlVideo;
	}

	public void setUrlVideo(String urlVideo) {
		this.urlVideo = urlVideo;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Section other = (Section) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
