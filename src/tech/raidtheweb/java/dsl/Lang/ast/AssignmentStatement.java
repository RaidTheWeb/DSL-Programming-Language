package tech.raidtheweb.java.dsl.Lang.ast;

import tech.raidtheweb.java.dsl.lib.Value;
import tech.raidtheweb.java.dsl.lib.Variables;

public final class AssignmentStatement implements Statement {
	private final String variable;
	private final Expression expression;
	
	public AssignmentStatement(String variable, Expression expression) {
		this.variable = variable;
		this.expression = expression;
	}
	
	@Override
	public void execute() {
		final Value result = expression.eval();
		Variables.set(variable, result);
	}

	public String toString() {
		return String.format("%s = %s", this.variable, this.expression);
	}
}
