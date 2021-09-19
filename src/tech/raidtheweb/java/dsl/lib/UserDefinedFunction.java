package tech.raidtheweb.java.dsl.lib;

import java.util.List;

import tech.raidtheweb.java.dsl.Lang.ast.ReturnStatement;
import tech.raidtheweb.java.dsl.Lang.ast.Statement;

public final class UserDefinedFunction implements Function {

	private final List<String> argNames;
	private final Statement body;
	
	public UserDefinedFunction(List<String> argNames, Statement body) {
		this.argNames = argNames;
		this.body = body;
	}
	
	public int getArgsCount() {
		return argNames.size();
	}
	
	public String getArgsName(int index) {
		if (index < 0 || index >= getArgsCount()) return "";
		return argNames.get(index);
	}
	
	@Override
	public Value execute(Value... args) {
		try {
			body.execute();
			return new NumberValue(0);
		} catch(ReturnStatement rt) {
			return rt.getResult();
		}
	}

}
