import java.util.*;
import java.util.stream.Collectors;


public class Lab12 {
    public static void main(String[] args) {
        List<Enrollee> enrollees = new ArrayList<>();
        enrollees.add(new Enrollee("Петров", 70));
        enrollees.add(new Enrollee("Іванов", 80));
        enrollees.add(new Enrollee("Сидоров", 50));
        enrollees.add(new Enrollee("Коваленко", 90));
        enrollees.add(new Enrollee("Семенов", 65));
        enrollees.add(new Enrollee("Козлов", 55));
        enrollees.add(new Enrollee("Михайленко", 75));
        enrollees.add(new Enrollee("Зайцев", 85));

        // Завдання 1. Список абітурієнтів, які поступили на бюджет
        int budgetSeats = 5;
        List<Enrollee> budgetEnrollees = enrollees.stream()
                .filter(enrollee -> enrollee.getScore() >= 60)
                .sorted(Comparator.comparing(Enrollee::getSurname))
                .limit(budgetSeats)
                .collect(Collectors.toList());

        System.out.println("Список абітурієнтів на бюджет:");
        budgetEnrollees.forEach(enrollee -> System.out.println(enrollee.getSurname() + ": " + enrollee.getScore()));

        // Завдання 3. Список абітурієнтів, які не можуть бути зараховані в інститут (кількість балів < 60)
        List<Enrollee> ineligibleEnrollees = enrollees.stream()
                .filter(enrollee -> enrollee.getScore() < 60)
                .sorted(Comparator.comparing(Enrollee::getSurname))
                .collect(Collectors.toList());

        System.out.println("\nСписок абітурієнтів, які не можуть бути зараховані:");
        ineligibleEnrollees.forEach(enrollee -> System.out.println(enrollee.getSurname() + ": " + enrollee.getScore()));
    }
}

class Enrollee {
    private String surname;
    private int score;

    public Enrollee(String surname, int score) {
        this.surname = surname;
        this.score = score;
    }

    public String getSurname() {
        return surname;
    }

    public int getScore() {
        return score;
    }
}