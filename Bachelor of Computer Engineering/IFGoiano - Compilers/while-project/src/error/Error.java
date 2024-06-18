package error;

public class Error {
    private int line, column;
    private String msg;

    public Error(int line, int column, String msg) {
        this.line = line;
        this.column = column;
        this.msg = msg;
    }

    public void print() {
        String aux = "line: " + (this.line + 1) + ", column: " + (this.column + 1) + ", message: ";
        aux += (this.msg == null ? " undefined error!" : this.msg);
        System.out.println(aux);
    }
}