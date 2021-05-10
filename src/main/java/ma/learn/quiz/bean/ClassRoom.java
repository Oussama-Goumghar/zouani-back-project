package ma.learn.quiz.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ClassRoom implements Serializable{
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String libelle;
	private String description;
	@ManyToOne
	private Prof responsable;
	
	
	public ClassRoom() {
		super();
	}
	public ClassRoom(String libelle, String description, Prof responsable) {
		super();
		this.libelle = libelle;
		this.description = description;
		this.responsable = responsable;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Prof getResponsable() {
		return responsable;
	}
	public void setResponsable(Prof responsable) {
		this.responsable = responsable;
	}
	
}
