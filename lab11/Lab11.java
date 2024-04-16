@FunctionalInterface
interface Displayable {
    void display();
}

@FunctionalInterface
interface TennisResultFactory {
    TennisResult create(String player1, String player2, String winner, int score);
}

public class Lab11 {
    public static void main(String[] args){
        // Посилання на нестатичний метод об'єкта
        FootballResult footballResult = new FootballResult("Команда \"1\"", "Команда \"2\"", "Команда \"1\"", 3);
        displayResult(footballResult::displayResult);

        TennisResult tennisResult = new TennisResult("Гравець1", "Гравець2", "Гравець1", 3);
        displayResult(tennisResult::displayResult);

        // Посилання на конструктор
        TennisResultFactory tennisResultFactory = TennisResult::new;
        TennisResult tennisResult2 = tennisResultFactory.create("Гравець1", "Гравець2", "Гравець2", 6);
        displayResult(tennisResult2::displayResult);

        tennisResult.setWinner("Гравець2");
        tennisResult.setScore(6);
        displayResult(tennisResult::displayResult);

        // Виклик статичного методу
        TennisResult.staticMethod();
        // Виклик статичного методу через посилання
        Runnable staticMethodReference = TennisResult::staticMethod;
        staticMethodReference.run();

        // Посилання на нестатичний метод класу
        Displayable displayable = tennisResult::nonStaticMethod;
        displayable.display();
    }

    public static void displayResult(Displayable displayable) {
        displayable.display();
    }
}
