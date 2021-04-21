package ma.learn.quiz.bean;

import javax.persistence.*;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private Long numero;
    private double pointReponseJuste;
    private double pointReponsefausse;
    @OneToOne
    private TypeDeQuestion typeDeQuestion;

    public TypeDeQuestion getTypeDeQuestion() {
        return typeDeQuestion;
    }

    public void setTypeDeQuestion(TypeDeQuestion typeDeQuestion) {
        this.typeDeQuestion = typeDeQuestion;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public double getPointReponseJuste() {
        return pointReponseJuste;
    }

    public void setPointReponseJuste(double pointReponseJuste) {
        this.pointReponseJuste = pointReponseJuste;
    }

    public double getPointReponsefausse() {
        return pointReponsefausse;
    }

    public void setPointReponsefausse(double pointReponsefausse) {
        this.pointReponsefausse = pointReponsefausse;
    }

    @ManyToOne
    private Quiz quiz;


    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    @OneToMany
    //private Reponse reponse;
    //private TypeDeQuestion typeDeQuestion;

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

  /*  public Reponse getReponse() {
        return reponse;
    }

    public void setReponse(Reponse reponse) {
        this.reponse = reponse;
    }*/
}