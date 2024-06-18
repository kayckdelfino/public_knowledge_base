package main;

import java.nio.file.Paths;

public class RunParser {
	public static void main(String[] args) {
		String rootPath = Paths.get("").toAbsolutePath().toString();
		String subPath = "/src/main/";
		
		try {
			String cupFile[] = {"-destdir", rootPath + subPath, "-parser", "Parser", "-symbols", "Sym", rootPath + subPath + "parser.cup"};
			java_cup.Main.main(cupFile);	
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}