package quiz.application;

import java.util.List;

public class QuizFacade {
    private final QuizSession session;
    private final ScoreCalculator scoreCalculator;
    private final List<Question> questions;

    public QuizFacade(QuizSession session, List<Question> questions) {
        this.session = session;
        this.questions = questions;
        this.scoreCalculator = new ScoreCalculator();
    }

    public Question getCurrentQuestion() {
        return questions.get(session.getCurrentIndex());
    }

    public int getCurrentIndex() {
        return session.getCurrentIndex();
    }

    public boolean isLastQuestion() {
        return session.isLastQuestion();
    }

    public void nextQuestion() {
        session.nextQuestion();
    }

    public void saveAnswer(String answer) {
        session.saveAnswer(answer);
    }

    public void finishQuiz() {
        int points = scoreCalculator.calculateScore(questions, session);
        session.addPoints(points);
    }
}
