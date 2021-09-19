package tech.raidtheweb.java.dsl.Lang.includes.Standard;

import tech.raidtheweb.java.dsl.lib.ArrayValue;
import tech.raidtheweb.java.dsl.lib.Function;
import tech.raidtheweb.java.dsl.lib.StringValue;
import tech.raidtheweb.java.dsl.lib.Value;

public final class SplitString implements Function {

	@Override
	public Value execute(Value... args) {
		if (args.length == 2) {
			final String input = args[0].asString();
	        final String regex = args[1].asString();
	
	        final String[] parts = input.split(regex, 0);
	        Value[] partsTranslated = new Value[parts.length];
	        for (int i = 0; i < parts.length; i++) {
	        	partsTranslated[i] = new StringValue(parts[i]);
	        }
	        return new ArrayValue(partsTranslated);
		} else {
			throw new RuntimeException("Invalid number of arguments");
		}
	}

}
