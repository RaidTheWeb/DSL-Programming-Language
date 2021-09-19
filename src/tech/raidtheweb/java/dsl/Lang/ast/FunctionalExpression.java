package tech.raidtheweb.java.dsl.Lang.ast;

import java.util.ArrayList;
import java.util.List;

import tech.raidtheweb.java.dsl.lib.Function;
import tech.raidtheweb.java.dsl.lib.Functions;
import tech.raidtheweb.java.dsl.lib.UserDefinedFunction;
import tech.raidtheweb.java.dsl.lib.Value;
import tech.raidtheweb.java.dsl.lib.Variables;

public final class FunctionalExpression implements Expression {

	private final String name;
	private List<Expression> arguments;
	
	public FunctionalExpression(String name) {
		this.name = name;
		this.arguments = new ArrayList<>();
	}
	
	public FunctionalExpression(String name, List<Expression> arguments) {
		this.name = name;
		this.arguments = arguments;
	}
	
	public void addArgument(Expression arg) {
		arguments.add(arg);
	}
	
	@Override
	public Value eval() {
		final int size = arguments.size();
		final Value[] values = new Value[size];
		for (int i = 0; i < size; i++) {
			values[i] = arguments.get(i).eval();
		}
		final Function function = Functions.get(name);
		if(function instanceof UserDefinedFunction) {
			final UserDefinedFunction userFunction = (UserDefinedFunction) function;
			if (size != userFunction.getArgsCount()) throw new RuntimeException("Argument count mismatch for function call.");
			
			Variables.push();
			for (int i = 0; i < size; i++) {
				Variables.set(userFunction.getArgsName(i), values[i]);
			}
			final Value result = userFunction.execute(values);
			Variables.pop();
			return result;
		}
		return function.execute(values);
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

}
