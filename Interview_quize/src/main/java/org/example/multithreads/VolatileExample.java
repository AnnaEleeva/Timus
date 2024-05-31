package org.example.multithreads;

public class VolatileExample {
    private static volatile boolean running = true;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (running) {
                // Выполнение работы в цикле
            }
            System.out.println("Thread terminated.");
        });

        thread.start();

        // Даем потоку время на выполнение
        Thread.sleep(1000);

        // Изменяем значение переменной `running`, что приведет к завершению потока
        running = false;

        // Ожидаем завершения потока
        thread.join();
        System.out.println("Main thread terminated.");
    }
}
