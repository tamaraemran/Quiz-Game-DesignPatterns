/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author tamar
 */
package quiz.application;

import java.util.List;

// Facade Pattern: Calculates quiz score

public class ScoreCalculator {
    public int calculateScore(List<Question> questions, QuizSession session) {
        int points = 0;
        for (int i = 0; i < questions.size(); i++) {
            if (session.getAnswer(i) != null
                    && session.getAnswer(i).equals(questions.get(i).getCorrectAnswer())) {
                points += QuizSession.POINTS_PER_QUESTION;
            }
        }
        return points;
    }
}
