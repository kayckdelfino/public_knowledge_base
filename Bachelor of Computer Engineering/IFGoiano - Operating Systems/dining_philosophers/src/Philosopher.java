import java.util.concurrent.atomic.AtomicBoolean;
import java.util.Random;

// Classe que representa um Filósofo
// Cada Filósofo é executado em sua própria thread e alterna entre pensar e comer, tentando pegar dois hashis para comer
public class Philosopher extends Thread {
    private final int id;
    private final Chopstick leftChopstick;
    private final Chopstick rightChopstick;
    private final AtomicBoolean running;
    private final Random random = new Random();

    public Philosopher(int id, Chopstick left, Chopstick right, AtomicBoolean runningFlag) {
        this.id = id;
        this.leftChopstick = left;
        this.rightChopstick = right;
        this.running = runningFlag;
    }

    // Método principal da thread, controla o ciclo de vida do Filósofo
    @Override
    public void run() {
        while (running.get()) {
            try {
                Logger.log("Filósofo " + (id + 1) + " está pensando.");
                Thread.sleep(random.nextInt(1000) + 1); // Pensa entre 1ms e 1000ms

                Logger.log("Filósofo " + (id + 1) + " está com fome.");

                // Estratégia anti-deadlock: filósofos pares pegam a esquerda primeiro,
                // filósofos ímpares pegam a direita primeiro
                Chopstick first = ((id + 1) % 2 == 0) ? leftChopstick : rightChopstick;
                Chopstick second = ((id + 1) % 2 == 0) ? rightChopstick : leftChopstick;

                // Tenta pegar os dois hashis
                first.lock();
                Logger.log("Filósofo " + (id + 1) + " pegou o hashi " +
                        (first.getId() + 1) + ".");

                second.lock();
                Logger.log("Filósofo " + (id + 1) + " pegou o hashi " +
                        (second.getId() + 1) + ".");

                // Come por um tempo aleatório
                Logger.log("Filósofo " + (id + 1) + " está comendo.");
                Thread.sleep(random.nextInt(496) + 5); // Entre 5ms e 500ms
                Logger.log("Filósofo " + (id + 1) + " terminou de comer.");

                // Libera os hashis
                second.unlock();
                Logger.log("Filósofo " + (id + 1) + " devolveu o hashi " +
                        (second.getId() + 1) + ".");

                first.unlock();
                Logger.log("Filósofo " + (id + 1) + " devolveu o hashi " +
                        (first.getId() + 1) + ".");

                Logger.log("Filósofo " + (id + 1) + " voltou a pensar.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}