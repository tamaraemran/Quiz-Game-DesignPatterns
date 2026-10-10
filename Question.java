/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiz.application;

/**
 *
 * @author tamar
 */
public class Question {
    
    private final String text;
    private final String[] options;
    private final String correctAnswer;

    public Question(String text, String[] options,
                    String correctAnswer) {
        this.text = text;
        this.options = options.clone();
        this.correctAnswer = correctAnswer;
    }

    public String getText() {
        return text;
    }

    public String[] getOptions() {
        return options.clone();
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
