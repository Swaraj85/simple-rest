import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class Demo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //basicThreadDemo();
        /*log.info("hello thread");
        Thread thread = new Thread(new MyTask());
        thread.start();
        thread.join();*/
        //ExecutorService executorService = Executors.newFixedThreadPool(10);
//        int processors = Runtime.getRuntime().availableProcessors();
//        ExecutorService executorService = Executors.newFixedThreadPool(processors);
//        //ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
//
//        Future<String> submit = executorService.submit(() -> "result");
//        executorService.execute(new MyTask());
//        System.out.println("processors = " + processors);
//
//        String futureResult = submit.get();
//        System.out.println("futureResult = " + futureResult);
//        executorService.shutdown();
        int param1 = 456;
        int param2 = 1734;
        System.out.println(solution(param1, param2));
    }

    public static int solution(int param1, int param2) {
        int result = 0; // Initialize the result
        int carry = 0;  // Initialize the carry

        // Iterate through the digits of both numbers from right to left
        while (param1 > 0 || param2 > 0 || carry > 0) {
            // Add the last digits of both numbers and the carry
            int sum = (param1 % 10) + (param2 % 10) + carry;

            // If sum exceeds 9, calculate carry
            if (sum >= 10) {
                carry = 1;
                sum -= 10;
            } else {
                carry = 0;
            }

            // Update the result with the current sum
            result = result * 10 + sum;

            // Move to the next digits of both numbers
            param1 /= 10;
            param2 /= 10;
        }

        return result; // Return the final result
    }

    private static void basicThreadDemo() throws InterruptedException {
        System.out.println("starting new thread");
        Thread thread = new Thread(() -> {

            try {
                Thread.sleep(5000L);
                System.out.println("sleep finished");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread.start();
        System.out.println("waiting in main thread");
        thread.join();
        System.out.println("main thread finished");
    }
}

@Slf4j
class MyTask implements Runnable {

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        log.info("executing task on thread {}", threadName);
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("thread {} finished", threadName);
    }
}