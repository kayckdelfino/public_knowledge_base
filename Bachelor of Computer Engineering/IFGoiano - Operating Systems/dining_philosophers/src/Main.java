import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    public static final int NUM_PHILOSOPHERS = 5;
    public static final int SIMULATION_TIME = 60000; // 60 segundos

    public static void main(String[] args) throws InterruptedException {
        // Criação dos hashis como locks independentes (um para cada posição na mesa)
        Chopstick[] chopsticks = new Chopstick[NUM_PHILOSOPHERS];
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            chopsticks[i] = new Chopstick(i);
        }

        // Flag compartilhada entre threads para controlar o tempo de execução
        AtomicBoolean running = new AtomicBoolean(true);

        Logger.log("Início da simulação.");

        // Inicializa e inicia cada filósofo
        Philosopher[] philosophers = new Philosopher[NUM_PHILOSOPHERS];
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            philosophers[i] = new Philosopher(i, chopsticks[i], chopsticks[(i + 1) % NUM_PHILOSOPHERS], running);
            philosophers[i].start();
        }

        // Espera pelo tempo total de simulação
        Thread.sleep(SIMULATION_TIME);
        running.set(false); // Sinaliza o encerramento

        // Aguarda todos os filósofos finalizarem
        for (Philosopher p : philosophers) {
            p.join();
        }

        Logger.log("Fim da simulação.");
        Logger.close();
    }
}