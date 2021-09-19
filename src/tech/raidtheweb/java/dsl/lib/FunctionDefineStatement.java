package tech.raidtheweb.java.dsl.lib;

import java.util.List;

import tech.raidtheweb.java.dsl.Lang.ast.Statement;

public final class FunctionDefineStatement implements Statement {

	private final String name;
	private final List<String> argNames;
	private final Statement body;
	
	public FunctionDefineStatement(String name, List<String> argNames, Statement body) {
		this.name = name;
		this.argNames = argNames;
		this.body = body;
	}
	
	@Override
	public void execute() {
		Functions.set(name, new UserDefinedFunction(argNames, body));
	}

}
