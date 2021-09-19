package tech.raidtheweb.java.dsl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


import tech.raidtheweb.java.dsl.Lang.Lexer;
import tech.raidtheweb.java.dsl.Lang.Parser;
import tech.raidtheweb.java.dsl.Lang.Token;
import tech.raidtheweb.java.dsl.Lang.ast.Statement;

public class Main {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		final String input = new String(Files.readAllBytes(Paths.get(args[0])));
		final List<Token> tokens = new Lexer(input).tokenize();
		
		final Statement program = new Parser(tokens).parse();
        program.execute();
	}
	
}
