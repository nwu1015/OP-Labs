import java.util.*;

public class lab8 {
    public static void main(String[] args){
        FootballResult footballResult1 = new FootballResult("Команда \"Бублікі\"", "Команда \"Вафлі\"", "Команда \"Бублікі\"", 2);
        FootballResult footballResult2 = new FootballResult("Команда \"Шоколадки\"", "Команда \"Мармеладки\"", "Команда \"Мармеладки\"", 3);
        FootballResult footballResult3 = new FootballResult("Команда \"A\"", "Команда \"B\"", "Команда \"А\"", 3);
        FootballResult[] footballResults = {footballResult1, footballResult2, footballResult3};
        // Сортування за іменем переможця
        Arrays.sort(footballResults, new WinnerNameComparator());

        TreeSet<FootballResult> footballResultSet = new TreeSet<>(new WinnerNameComparator());
        footballResultSet.addAll(Arrays.asList(footballResults));
        System.out.println("Результати, збережені у TreeSet:");
        for (FootballResult result : footballResultSet) {
            result.displayResult();
        }



        TennisResult tennisResult1 = new TennisResult("Гравець1", "Гравець2", "Гравець1", 3);
        TennisResult tennisResult2 = new TennisResult("Гравець3", "Гравець4", "Гравець3", 2);
        TennisResult[] tennisResults = {tennisResult1, tennisResult2};

        TreeSet<TennisResult> tennisResultSet = new TreeSet<>(new Comparator<TennisResult>() {
            @Override
            public int compare(TennisResult result1, TennisResult result2) {
                return Integer.compare(result1.getScore(), result2.getScore());
            }
        });

        System.out.println("\nРезультати, збережені у TreeSet:");
        for (TennisResult result : tennisResults) {
            tennisResultSet.add(result);
            result.displayResult();
        }
    }

    static class WinnerNameComparator implements Comparator<FootballResult> {
        @Override
        public int compare(FootballResult result1, FootballResult result2) {
            return result1.getWinner().compareTo(result2.getWinner());
        }
    }
}

abstract class SportResult {
    private String winner;
    private int score;

    public SportResult(String winner, int score) {
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
}

class FootballResult extends SportResult {
    private final String team1;
    private final String team2;

    public FootballResult(String team1, String team2, String winner, int score) {
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
}

class TennisResult extends SportResult {
    private String player1;
    private String player2;

    public TennisResult(String player1, String player2, String winner, int score) {
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
}