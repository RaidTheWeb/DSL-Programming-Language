package tech.raidtheweb.java.dsl.Lang.ast;

import tech.raidtheweb.java.dsl.lib.NumberValue;
import tech.raidtheweb.java.dsl.lib.StringValue;
import tech.raidtheweb.java.dsl.lib.Value;

public final class BinaryExpression implements Expression {

	private final Expression expr1, expr2;
	private final char operation;
	
	public BinaryExpression(char operation, Expression expr1, Expression expr2) {
		this.operation = operation;
		this.expr1 = expr1;
		this.expr2 = expr2;
	}
	
	@Override
	public Value eval() {
		final Value value1 = expr1.eval();
		final Value value2 = expr2.eval();
		if (value1 instanceof StringValue) {
			final String string1 = value1.asString();
			switch(operation) {
				case '*': {
					final int iterations = (int) value2.asDouble();
					final StringBuilder buffer = new StringBuilder();
					for (int i = 0; i < iterations; i++) {
						buffer.append(string1);
					}
					return new StringValue(buffer.toString());
				}
				case '+':
				default:
					return new StringValue(string1 + value2.asString());
			}
		}
		
		final double number1 = expr1.eval().asDouble();
		final double number2 = expr2.eval().asDouble();
		switch(operation) {
			case '+': return new NumberValue(number1 + number2);
			case '-': return new NumberValue(number1 - number2);
			case '*': return new NumberValue(number1 * number2);
			case '/': return new NumberValue(number1 / number2);
			default: 
				return new NumberValue(number1 + number2);
		}
	}
	

}
