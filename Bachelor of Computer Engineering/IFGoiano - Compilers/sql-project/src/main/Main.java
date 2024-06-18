package main;

import java.io.FileReader;
import java.nio.file.Paths;

import error.ErrorList;

public class Main {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        String rootPath = Paths.get("").toAbsolutePath().toString();
        String subPath = "/src/main/";
        
        try {
            ErrorList errorList = new ErrorList();
            FileReader in = new FileReader(rootPath + subPath + "input.txt");
            Scanner scanner = new Scanner(in, errorList);
            Parser parser = new Parser(scanner);
            parser.parse();
            
            if(!errorList.hasErrors())
                System.out.println("Syntax correct");
            else {
                System.out.println("Errors found:");
                errorList.dump();
            }

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}