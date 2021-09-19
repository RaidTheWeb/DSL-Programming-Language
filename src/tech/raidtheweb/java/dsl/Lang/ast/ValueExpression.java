package tech.raidtheweb.java.dsl.Lang.ast;

import tech.raidtheweb.java.dsl.lib.NumberValue;
import tech.raidtheweb.java.dsl.lib.StringValue;
import tech.raidtheweb.java.dsl.lib.Value;

public class ValueExpression implements Expression {

	private final Value value;
	
	public ValueExpression(double value) {
		this.value = new NumberValue(value);
	}
	
	public ValueExpression(String value) {
		this.value = new StringValue(value);
	}
	
	@Override
	public Value eval() {
		return value;
	}
	
	@Override
	public String toString() {
		return value.toString();
	}

}
