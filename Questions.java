package com.example.sakshiquiz.quiz;

/**
 * Created by root on 5/18/2017.
 */

public class Questions {
    //name and address string
    private String question,answer;
    private String choice1, choice2, choice3, choice4;

    public Questions() {
      /*Blank default constructor essential for Firebase*/
    }

    //Getters and setters
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question1) {
        this.question = question1;
    }
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer1) {
        this.answer = answer1;
    }

    public String getChoice1() {
        return choice1;
    }

    public void setChoice1(String choice1) {
        this.choice1 = choice1;
    }

    public String getChoice2() {
        return choice2;
    }

    public void setChoice2(String choice2) {
        this.choice2 = choice2;
    }

    public String getChoice3() {
        return choice3;
    }

    public void setChoice3(String choice3) {
        this.choice3 = choice3;
    }

    public String getChoice4() {
        return choice4;
    }

    public void setChoice4(String choice4) {
        this.choice4 = choice4;
    }
}

