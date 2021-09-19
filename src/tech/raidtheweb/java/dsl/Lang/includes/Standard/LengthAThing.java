package tech.raidtheweb.java.dsl.Lang.includes.Standard;

import tech.raidtheweb.java.dsl.lib.ArrayValue;
import tech.raidtheweb.java.dsl.lib.Function;
import tech.raidtheweb.java.dsl.lib.NumberValue;
import tech.raidtheweb.java.dsl.lib.StringValue;
import tech.raidtheweb.java.dsl.lib.Value;

public final class LengthAThing implements Function {

	@Override
	public Value execute(Value... args) {
		if(args[0] instanceof StringValue) {
			return new NumberValue(args[0].asString().length());
		} else if (args[0] instanceof ArrayValue) {
			ArrayValue array = (ArrayValue) args[0];
			return new NumberValue(array.size());
		} else {
			return new NumberValue(0);
		}
	}
	
}
