package tech.raidtheweb.java.dsl.Lang.ast;

import tech.raidtheweb.java.dsl.lib.Value;

public final class ReturnStatement extends RuntimeException implements Statement {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4145628429351342296L;
	private final Expression expression;
	private Value result;
	
	public ReturnStatement(Expression expression) {
		this.expression = expression;
	}
	
	public Value getResult() {
		return result;
	}
	
	@Override
	public void execute() {
		result = expression.eval();
		throw this;
	}
	
	@Override
	public String toString() {
		return "return";
	}

}
