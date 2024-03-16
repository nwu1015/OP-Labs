import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String input = "D:/lab5_text.txt";
        String output = "D:/result.txt";
        checkingWords(input, output);
    }

    public static void checkingWords(String input, String output){
        Map<String, Integer> wordFrequency = new HashMap<>();
        try {
            File file = new File(input);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            File outputFile = new File(output);
            FileWriter fileWriter = new FileWriter(outputFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String text;
            while((text = bufferedReader.readLine()) != null) {
                String[] words = text.split("\\s+");
                for (String word : words) {
                    wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                }
            }

            for(Map.Entry<String, Integer> entry : wordFrequency.entrySet()){
                String key = entry.getKey();
                Integer value = entry.getValue();
                if(value <= 1){
                    bufferedWriter.write(key);
                    bufferedWriter.newLine();
                }
            }

            bufferedReader.close();
            bufferedWriter.close();

        } catch (NullPointerException e) {
            System.err.println("NullPointerException occurred: " + e.getMessage());
        } catch (IOException e1) {
            System.err.println("IOException occurred: " + e1.getMessage());
        }
    }
}