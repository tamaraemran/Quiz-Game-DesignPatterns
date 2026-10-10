/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiz.application;

/**
 *
 * @author tamar
 */

import java.util.ArrayList;
import java.util.List;
public class QuestionBuilder {
    
    private String text;
    private final List <String> options = new ArrayList<>();
    private String correctAnswer;

    public QuestionBuilder setText(String text) {
        this.text = text;
        return this;
    }

    public QuestionBuilder addOption(String option) {
        options.add(option);
        return this;
    }

    public QuestionBuilder setCorrectAnswer(String answer) {
        this.correctAnswer = answer;
        return this;
    }

    public Question build() {

        if (text == null || text.trim().isEmpty()) {
            throw new IllegalStateException(
                    "Question text is required");
        }

        if (options.size() != 4) {
            throw new IllegalStateException(
                    "Each question must have 4 options");
        }

        if (correctAnswer == null ||
                !options.contains(correctAnswer)) {
            throw new IllegalStateException(
                    "Correct answer must match an option");
        }

        return new Question(
                text,
                options.toArray(new String[0]),
                correctAnswer
        );
    }
}
