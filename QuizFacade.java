/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiz.application;

/**
 *
 * @author tamar
 */

import java.util.List;

// Facade Pattern: Manages quiz operations

public class QuizFacade {
    private final QuizSession session;
    private final ScoreCalculator scoreCalculator;
    private final List<Question> questions;

    public QuizFacade(QuizSession session, List<Question> questions) {
        this.session = session;
        this.questions = questions;
        this.scoreCalculator = new ScoreCalculator();
    }

    public void saveAnswer(String answer) {
        session.saveAnswer(answer);
    }

    public void nextQuestion() {
        session.nextQuestion();
    }

    public void finishQuiz() {
        int points = scoreCalculator.calculateScore(questions, session);
        session.addPoints(points);
    }
}
