package tech.raidtheweb.java.dsl.Lang.includes.Standard;

import java.util.Scanner;

import tech.raidtheweb.java.dsl.lib.Function;
import tech.raidtheweb.java.dsl.lib.StringValue;
import tech.raidtheweb.java.dsl.lib.Value;

public final class ReadAThing implements Function {

	@Override
	public Value execute(Value... args) {
		try (Scanner sc = new Scanner(System.in)) {
            return new StringValue(sc.nextLine());
        }
	}

}
