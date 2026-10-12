package quiz.application;

/**
 * Singleton Pattern
 *
 * Holds all the data of ONE quiz game (player name, score, current
 * question index, and the user's answers) in a single shared object.
 *
 * Replaces the public static variables (score, count) and the
 * useranswers[][] array that were scattered inside Quiz, and the
 * name/count/score values passed through every screen's constructor.
 */
public class QuizSession {

    public static final int TOTAL_QUESTIONS = 10;
    public static final int POINTS_PER_QUESTION = 10;

    // The single instance
    private static QuizSession instance;

    private String playerName;
    private int score;
    private int currentIndex;
    private String[] userAnswers;

    // Private constructor: no other class can call "new QuizSession()"
    private QuizSession() {
        reset();
    }

    // Global access point to the single instance
    public static synchronized QuizSession getInstance() {
        if (instance == null) {
            instance = new QuizSession();
        }
        return instance;
    }

    // Start a new game: clears the old score and answers
    // (fixes the original bug where score kept adding up after "Play Again")
    public void reset() {
        playerName = "";
        score = 0;
        currentIndex = 0;
        userAnswers = new String[TOTAL_QUESTIONS];
    }

    // ---------- player ----------
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    // ---------- question index ----------
    public int getCurrentIndex() {
        return currentIndex;
    }

    public void nextQuestion() {
        currentIndex++;
    }

    public boolean isLastQuestion() {
        return currentIndex == TOTAL_QUESTIONS - 1;
    }

    // ---------- answers ----------
    public void saveAnswer(String answer) {
        userAnswers[currentIndex] = (answer == null) ? "" : answer;
    }

    public String getAnswer(int index) {
        return userAnswers[index];
    }

    // ---------- score ----------
    public int getScore() {
        return score;
    }

    public void addPoints(int points) {
        score += points;
    }
}
