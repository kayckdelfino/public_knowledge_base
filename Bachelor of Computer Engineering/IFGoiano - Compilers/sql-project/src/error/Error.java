package error;

public class Error {
    private int line, column;
    private String message;
    
    public Error(int line, int column, String message) {
        this.line = line;
        this.column = column;
        this.message = message;
    }

    public void print() {
        String aux = "line: " + (this.line + 1) + ", column: " + (this.column + 1) + ", ";
        aux += (this.message == null ? " undefined error!" : this.message);
        System.out.println(aux);
    }
}