import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

// Utilitário para registrar logs com timestamp, em console e arquivo local
public class Logger {
    private static final String LOG_FILE = "simulation.log";
    private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
    private static PrintWriter writer;

    // Inicializa o escritor de arquivo (com append)
    static {
        try {
            writer = new PrintWriter(new FileWriter(LOG_FILE, true), true);
        } catch (IOException e) {
            System.err.println("Erro ao abrir o arquivo de log.");
            e.printStackTrace();
        }
    }

    // Método sincronizado para que múltiplas threads possam registrar mensagens sem
    // conflito
    public static synchronized void log(String message) {
        String timestamp = sdf.format(new Date());
        String logMessage = "[" + timestamp + "] " + message;
        System.out.println(logMessage);
        writer.println(logMessage);
    }

    // Encerra o writer após a simulação
    public static void close() {
        writer.close();
    }
}
