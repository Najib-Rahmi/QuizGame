package com.example.sql;

public class Quiz {
    private String Question,reponse1,reponse2,reponse3,bonnereponse;
    private String id;

    public Quiz() {

    }


    public String getId() {
        return id;
    }

    public String getQuestion() {
        return Question;
    }

    public String getReponse1() {
        return reponse1;
    }

    public String getReponse2() {
        return reponse2;
    }

    public String getReponse3() {
        return reponse3;
    }

    public String getBonneReponse() {
        return bonnereponse;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBonneReponse(String bonnereponse) {
        this.bonnereponse = bonnereponse;
    }

    public void setReponse1(String reponse1) {
        this.reponse1 = reponse1;
    }

    public void setReponse2(String reponse2) {
        this.reponse2 = reponse2;
    }

    public void setReponse3(String reponse3) {
        this.reponse3 = reponse3;
    }

    public void setQuestion(String question) {
        this.Question=question;
    }

    public Quiz(String Question,String reponse1,String reponse2,String reponse3,String bonnereponse){
        this.Question=Question;
        this.reponse1=reponse1;
        this.reponse2=reponse2;
        this.reponse3=reponse3;
        this.bonnereponse=bonnereponse;
    }
    @Override
    public String toString() {
        return Question + reponse1 + reponse2 + reponse3 +bonnereponse;
    }
}
