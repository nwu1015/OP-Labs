import java.util.*;

public class Lab10Part2 {
    public static void main(String[] args){
        List<SportResult1> results = new ArrayList<>();
        results.add(new FootballResult1("Команда \"1\"", "Команда \"2\"", "Команда \"1\"", 3));
        results.add(new TennisResult1("Гравець1", "Гравець2", "Гравець1", 3));
        results.add(new TennisResult1("Гравець3", "Гравець4", "Гравець3", 2));

        // Виведення списку об'єктів на консоль за допомогою методу forEach() інтерфейсу Iterable
        results.forEach(result -> System.out.println(result.toString()));
    }
}

abstract class SportResult1 {
    private String winner;
    private int score;

    public SportResult1(String winner, int score) {
        this.winner = winner;
        this.score = score;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public abstract void displayResult();

    @Override
    public String toString() {
        return "Переможець: " + winner + ", Очки: " + score;
    }
}

class FootballResult1 extends SportResult1 {
    private final String team1;
    private final String team2;

    public FootballResult1(String team1, String team2, String winner, int score) {
        super(winner, score);
        this.team1 = team1;
        this.team2 = team2;
    }

    @Override
    public void displayResult() {
        System.out.println("Результат футбольного матчу: " + team1 + " vs " + team2);
        System.out.println("Переможець: " + getWinner());
        System.out.println("Очки: " + getScore());
    }

    @Override
    public String toString() {
        return "Футбольний матч: " + team1 + " vs " + team2 + ", " + super.toString();
    }
}

class TennisResult1 extends SportResult1 {
    private String player1;
    private String player2;

    public TennisResult1(String player1, String player2, String winner, int score) {
        super(winner, score);
        this.player1 = player1;
        this.player2 = player2;
    }

    @Override
    public void displayResult() {
        System.out.println("Результат тенісного матчу: " + player1 + " vs " + player2);
        System.out.println("Переможець: " + getWinner());
        System.out.println("Очки: " + getScore());
    }

    @Override
    public String toString() {
        return "Тенісний матч: " + player1 + " vs " + player2 + ", " + super.toString();
    }
}