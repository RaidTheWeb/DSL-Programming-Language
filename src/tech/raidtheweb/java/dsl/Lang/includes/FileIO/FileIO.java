package tech.raidtheweb.java.dsl.Lang.includes.FileIO;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import tech.raidtheweb.java.dsl.Lang.ast.Library;
import tech.raidtheweb.java.dsl.lib.Function;
import tech.raidtheweb.java.dsl.lib.Functions;
import tech.raidtheweb.java.dsl.lib.NumberValue;
import tech.raidtheweb.java.dsl.lib.StringValue;
import tech.raidtheweb.java.dsl.lib.Value;

public final class FileIO implements Library {
	public FileIO() {
		Functions.set("fileio_readAll", (Function) (Value... args) -> {
			if(args.length == 1) {
				try {
					return new StringValue( new String(Files.readAllBytes(Paths.get(args[0].asString()))) );
				} catch (IOException e) {
					throw new RuntimeException("IOException occured when reading file.");
				}
			} else {
				throw new RuntimeException("Invalid number of arguments");
			}
			
		});
		
		Functions.set("fileio_write", (Function) (Value... args) -> {
			if(args.length == 2) {
				try {
					Files.writeString(Paths.get(args[0].asString()), args[1].asString(), StandardCharsets.UTF_8);
					return new NumberValue(args[0].asString().length());
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			} else {
				throw new RuntimeException("Invalid number of arguments");
			}
			return new NumberValue(0);
			
		});
	}
}
