package tech.raidtheweb.java.dsl;

import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;

import javax.script.AbstractScriptEngine;
import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptException;
import javax.script.SimpleBindings;

public class DSLScriptEngine extends AbstractScriptEngine {
	private final ScriptEngineFactory factory;
	
	/**
	 * Create an instance of the DSLScriptEngine class
	 * 
	 * @param factory Instance of ScriptEngineFactory
	 */
	public DSLScriptEngine(ScriptEngineFactory factory) {
		this.factory = factory;
	}
	
	
	@Override
	public Object eval(String script, ScriptContext context) throws ScriptException {
		try {
			DSLScriptEvaluator dslScript = new DSLScriptEvaluator(script, context); 
			Object result = dslScript.eval();
			return result;
		} catch(Exception e) {
			throw new ScriptException(e.getMessage());
		}
	}

	@Override
	public Object eval(Reader reader, ScriptContext context) throws ScriptException {
		BufferedReader br = new BufferedReader(reader);
		
		String script = "";
		try {
			String str;
			while ((str = br.readLine()) != null) {
				script = script + str;
			}
		} catch(IOException e) {
			throw new ScriptException(e);
		}
		return eval(script, context);
	}

	@Override
	public Bindings createBindings() {
		return new SimpleBindings();
	}

	@Override
	public ScriptEngineFactory getFactory() {
		return factory;
	}

}
