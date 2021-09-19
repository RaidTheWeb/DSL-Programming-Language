package tech.raidtheweb.java.dsl.Lang.ast;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import tech.raidtheweb.java.dsl.Lang.includes.DateMethods.DateMethods;
import tech.raidtheweb.java.dsl.Lang.includes.FileIO.FileIO;
import tech.raidtheweb.java.dsl.Lang.includes.HTTPModule.HTTPModule;
import tech.raidtheweb.java.dsl.Lang.includes.Network.Network;
import tech.raidtheweb.java.dsl.Lang.includes.Standard.Standard;
import tech.raidtheweb.java.dsl.Lang.includes.StringMethods.StringMethods;
import tech.raidtheweb.java.dsl.lib.Value;


public final class IncludeStatement implements Statement {

	private final Expression expression;
	
	@SuppressWarnings("rawtypes")
	private Map<String, Class> includes;
	
	public IncludeStatement(Expression expression) throws ClassNotFoundException {
		this.expression = expression;
		includes = new HashMap<>();
		includes.put("string", StringMethods.class);
		includes.put("fileio", FileIO.class);
		includes.put("http", HTTPModule.class);
		includes.put("networking", Network.class);
		includes.put("date", DateMethods.class);
		includes.put("std", Standard.class);
	}
	
	@Override
	public void execute() {
		loadProgram(expression.eval());
	}

	private void loadProgram(Value value) {
		if(!includes.containsKey(value.asString())) {
			throw new RuntimeException("Unknown include " + value.asString());
		} else {
			try {
				@SuppressWarnings("unchecked")
				Constructor<?> thing = includes.get(value.asString()).getConstructor();
				@SuppressWarnings("unused")
				Object library = thing.newInstance();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}
		}
	}

}
