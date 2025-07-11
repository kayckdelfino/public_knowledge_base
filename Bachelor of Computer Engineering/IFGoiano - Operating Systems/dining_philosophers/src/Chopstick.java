import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Classe que representa um Hashi
// Cada Hashi é tratado como um recurso compartilhado (Lock) que pode ser acessado por no máximo um filósofo por vez
public class Chopstick {
    private final int id;
    private final Lock lock = new ReentrantLock();

    public Chopstick(int id) {
        this.id = id;
    }

    public void lock() {
        lock.lock();
    }

    public void unlock() {
        lock.unlock();
    }

    public int getId() {
        return id;
    }
}
