package tech.raidtheweb.java.dsl;

import javax.script.ScriptContext;

public class DSLScriptEvaluator {
	private String script;
	private ScriptContext context;
	
	public DSLScriptEvaluator(String script, ScriptContext context) {
		if (script == null || script.trim().equals("")) {
			throw new IllegalArgumentException("script cannot be null.");
		}
		this.script = script;
		
		if(context == null) {
			throw new IllegalArgumentException("ScriptContext cannot be null.");
		}
		this.context = context;
	}
	
	public String getScript() {
		return script;
	}
	
	public ScriptContext getScriptContext() {
		return context;
	}
	
	public Object eval() {
		Object result = null;
		
		
		
		return result;
	}
}
