import java.util.concurrent.*;

public class lab6 {
    public static void main(String[] args) throws InterruptedException {
        long n = 3; // Номер бригади/команди == варіант
        long N = 100_000_000;

        System.out.println("ОБЧИСЛЕННЯ АРИФМЕТИЧНОЇ ПРОГРЕСІЇ ЗА ФОРМУЛОЮ:");
        System.out.println();

        long startTime0 = System.currentTimeMillis();

        long sum = calculateArithmeticSeriesSumFormula(n, N);
        System.out.println("Сума арифметичної прогресії: " + sum);

        long endTime0 = System.currentTimeMillis();
        long elapsedTime0 = endTime0 - startTime0;
        System.out.println("Час, що був витрачений на виконання (мс) " + elapsedTime0);

        System.out.println();
        System.out.println("ОБЧИСЛЕННЯ АРИФМЕТИЧНОЇ ПРОГРЕСІЇ В ЛОБ (ЦИКЛ):");
        System.out.println();

        long startTime1 = System.currentTimeMillis();

        long sum2 = calculateArithmeticSeriesSumFor(n, N);
        System.out.println("Сума арифметичної прогресії: " + sum2);
        long endTime1 = System.currentTimeMillis();
        long elapsedTime1 = endTime1 - startTime1;
        System.out.println("Час, що був витрачений на виконання (мс) " + elapsedTime1);

        System.out.println();
        System.out.println("ОБЧИСЛЕННЯ АРИФМЕТИЧНОЇ ПРОГРЕСІЇ В ЛОБ (ТРЕДИ):");
        System.out.println();

        int[] threads = {2, 4, 8, 16, 32};

        for (int k : threads) {
            ExecutorService executor = Executors.newFixedThreadPool(k);
            int chunkSize = (int) (N / k);
            CalculatingWithThreads[] workers = new CalculatingWithThreads[k];

            long startTime2 = System.currentTimeMillis();

            for (int i = 0; i < k; i++) {
                int start = i * chunkSize + 1;
                int end = (i == k - 1) ? (int) N : (i + 1) * chunkSize;
                workers[i] = new CalculatingWithThreads(start, end, (int) n);
                executor.execute(workers[i]);
            }

            executor.shutdown();
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);

            long totalSum = 0;
            for (CalculatingWithThreads worker : workers) {
                totalSum += worker.getResult();
            }

            long endTime2 = System.currentTimeMillis();
            long elapsedTime2 = endTime2 - startTime2;

            System.out.println("Кількість тредів: " + k);
            System.out.println("Сума арифметичної прогресії: " + totalSum);
            System.out.println("Час, що був витрачений на виконання (мс): " + elapsedTime2);
            System.out.println();
        }

    }



    public static long calculateArithmeticSeriesSumFormula(long n, long N) {
        // Формула розрахунку суми арифметичної прогресії: S = (n/2)(2a + (n-1)d),
        long a = n;
        long d = n;
        long sum = (N / 2) * (2 * a + (N - 1) * d);
        return sum;
    }

    public static long calculateArithmeticSeriesSumFor(long n, long N){
        long sum = 0;
        for(long i = 1; i<=N; i++){
            sum += n*i;
        }
        return sum;
    }
}

class CalculatingWithThreads implements Runnable {
    private final int start;
    private final int end;
    private final int n;
    private long result;

    public CalculatingWithThreads(int start, int end, int n) {
        this.start = start;
        this.end = end;
        this.n = n;
        this.result = 0;
    }

    public long getResult() {
        return result;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            result += (long) i * n;
        }
    }
}