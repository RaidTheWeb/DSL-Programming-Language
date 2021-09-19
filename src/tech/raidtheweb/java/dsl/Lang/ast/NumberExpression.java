package tech.raidtheweb.java.dsl.Lang.ast;

import tech.raidtheweb.java.dsl.lib.NumberValue;
import tech.raidtheweb.java.dsl.lib.Value;

public final class NumberExpression implements Expression {
	private final NumberValue value;

	public NumberExpression(double value) {
		this.value = new NumberValue(value);
	}
	
	@Override
	public Value eval() {
		return value;
	}
	
	@Override
	public String toString() {
		return value.asString();
	}
	
}
