import java.util.*;

public class Lab9 {
    public static void main(String[] args) {
        FootballResult footballResult1 = new FootballResult("Команда \"Бублікі\"", "Команда \"Вафлі\"", "Команда \"Бублікі\"", 2);
        FootballResult footballResult2 = new FootballResult("Команда \"Шоколадки\"", "Команда \"Мармеладки\"", "Команда \"Мармеладки\"", 3);
        FootballResult footballResult3 = new FootballResult("Команда \"A\"", "Команда \"B\"", "Команда \"A\"", 3);
        FootballResult footballResult4 = null; // Приклад з null-посиланням
        FootballResult[] footballResults = {footballResult1, footballResult2, footballResult3};

        FootballResult[] footballResults1 = {footballResult1, footballResult2, footballResult3, footballResult4};

        // Завдання 2.1
        // Сортування за іменем переможця в порядку зростання
        Arrays.sort(footballResults, (result1, result2) -> result1.getWinner().compareTo(result2.getWinner()));

        System.out.println("Результати футбольних матчів, відсортовані за іменем переможця:");
        for (FootballResult result : footballResults) {
            result.displayResult();
        }

        // Завдання 2.2
        // Сортування за іменем переможця в зворотньому порядку
        Comparator<FootballResult> winnerComparatorReversed = (result1, result2) -> result2.getWinner().compareTo(result1.getWinner());
        Arrays.sort(footballResults, winnerComparatorReversed);
        System.out.println("");
        System.out.println("Результати футбольних матчів, відсортовані за іменем переможця зворотному порядку:");
        for (FootballResult result : footballResults) {
            result.displayResult();
        }

        // Завдання 2.4
        // Створення компаратора, який дозволяє порівнювати null-посилання на об’єкти з іншими об’єктами
        Comparator<FootballResult> nullsFirstComparator = Comparator
                .nullsFirst(Comparator.comparing((FootballResult result) -> result.getWinner()));
        Arrays.sort(footballResults1, nullsFirstComparator);
        System.out.println("");
        System.out.println("Результати футбольних матчів, відсортовані, де null-посилання на об’єкти на початку:");
        for (FootballResult result : footballResults1) {
            if (result != null) {
                result.displayResult();
            } else {
                System.out.println("Результат: null");
            }
        }


        TennisResult tennisResult1 = new TennisResult("Гравець1", "Гравець2", "Гравець1", 3);
        TennisResult tennisResult2 = new TennisResult("Гравець3", "Гравець4", "Гравець3", 2);
        TennisResult tennisResult3 = new TennisResult("Гравець1", "Гравець2", "Гравець1", 4);
        TennisResult[] tennisResults = {tennisResult1, tennisResult2, tennisResult3};

        // Завдання 2.3
        // Створення компаратора, що спочатку порівнює за іменем переможця, а потім за оцінкою
        Comparator<TennisResult> winnerThenScoreComparator = Comparator
                .comparing((TennisResult result) -> result.getWinner())
                .thenComparingInt((TennisResult result) -> result.getScore());
        Arrays.sort(tennisResults, winnerThenScoreComparator);
        System.out.println("");
        System.out.println("Результати тенісних матчів, відсортовані спочатку за переможцем, а потім за оцінкою:");
        for (TennisResult result : tennisResults) {
            result.displayResult();
        }
    }
}