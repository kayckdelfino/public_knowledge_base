package error;

import java.util.ArrayList;
import java.util.List;

public class ErrorList {
    private List<Error> errors;
    
    public ErrorList() {
        this.errors = new ArrayList<Error>();
    }
    
    public void addError(int line, int column, String message) {
        Error e = new Error(line, column, message);
        this.errors.add(e);
    }
    
    public void addError(int line, int column) {
        this.addError(line, column, null);
    }
    
    public void addError(String message) {
        this.addError(0, 0, message);
    }
    
    public void dump() {
        for(Error e: this.errors)
            e.print();
    }
    
    public boolean hasErrors() {
        return this.errors.size() > 0;
    }
}