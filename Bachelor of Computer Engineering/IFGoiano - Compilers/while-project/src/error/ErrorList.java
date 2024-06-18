package error;

import java.util.ArrayList;
import java.util.List;

public class ErrorList {
    private List<Error> errors;
    
    public ErrorList() {
        this.errors = new ArrayList<>();
    }
    
    public void defineError(int line, int column, String msg) {
        Error e = new Error(line, column, msg);
        this.errors.add(e);
    }
    
    public void defineError(int line, int column) {
        this.defineError(line, column, null);
    }
    
    public void defineError(String msg) {
        this.defineError(0, 0, msg);
    }
    
    public void dump() {
        for(Error e: this.errors)
            e.print();
    }
    
    public boolean hasErrors() {
        return this.errors.size() > 0;
    }
}