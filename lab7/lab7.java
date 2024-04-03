import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class lab7 {
    public static void main(String[] args) {
        String[] inputFiles = {"D:/lab7_1.txt", "D:/lab7_2.txt"};
        String output = "D:/result.txt";
        int numThreads = Runtime.getRuntime().availableProcessors(); // Отримуємо кількість доступних ядер процесора
        // Створюємо пул потоків
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        try {
            WordFrequency wordFrequency = new WordFrequency();
            List<Future<?>> futures = new ArrayList<>();
            for (String inputFile : inputFiles) {
                Callable<Void> task = () -> {
                    checkingWords(inputFile, wordFrequency);
                    return null;
                };
                futures.add(executor.submit(task));
            }
            for (Future<?> future : futures) {
                future.get(); // Блокуємо, поки завдання не буде завершено
            }
            wordFrequency.writeToFile(output);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    public static void checkingWords(String inputFile, WordFrequency wordFrequency) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile))) {
            String text;
            while ((text = bufferedReader.readLine()) != null) {
                String[] words = text.split("\\s+");
                for (String word : words) {
                    wordFrequency.increment(word);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class WordFrequency {
    private final Map<String, AtomicInteger> wordFrequency = new ConcurrentHashMap<>();

    public void increment(String word) {
        wordFrequency.computeIfAbsent(word, k -> new AtomicInteger()).incrementAndGet();
    }

    public void writeToFile(String output) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(output))) {
            for (Map.Entry<String, AtomicInteger> entry : wordFrequency.entrySet()) {
                if (entry.getValue().get() <= 1) {
                    bufferedWriter.write(entry.getKey());
                    bufferedWriter.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}