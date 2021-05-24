package ma.learn.quiz.vo;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ma.learn.quiz.bean.Prof;

public class SalaryVo {
@ManyToOne
private Prof prof;
@Temporal(TemporalType.DATE)
private Date annee;
@Temporal(TemporalType.DATE)
private Date mois;
private BigDecimal nbrSessionMensuel;
private BigDecimal nbrSessionGlobale; 
private BigDecimal montantMensuel;
private BigDecimal montantGlobale;
public Prof getProf() {
	return prof;
}
public void setProf(Prof prof) {
	this.prof = prof;
}
public Date getAnnee() {
	return annee;
}
public void setAnnee(Date annee) {
	this.annee = annee;
}
public Date getMois() {
	return mois;
}
public void setMois(Date mois) {
	this.mois = mois;
}
public BigDecimal getNbrSessionMensuel() {
	return nbrSessionMensuel;
}
public void setNbrSessionMensuel(BigDecimal nbrSessionMensuel) {
	this.nbrSessionMensuel = nbrSessionMensuel;
}
public BigDecimal getNbrSessionGlobale() {
	return nbrSessionGlobale;
}
public void setNbrSessionGlobale(BigDecimal nbrSessionGlobale) {
	this.nbrSessionGlobale = nbrSessionGlobale;
}
public BigDecimal getMontantMensuel() {
	return montantMensuel;
}
public void setMontantMensuel(BigDecimal montantMensuel) {
	this.montantMensuel = montantMensuel;
}
public BigDecimal getMontantGlobale() {
	return montantGlobale;
}
public void setMontantGlobale(BigDecimal montantGlobale) {
	this.montantGlobale = montantGlobale;
}

}
