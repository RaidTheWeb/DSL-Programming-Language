package tech.raidtheweb.java.dsl;

import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;

public class DSLScriptEngineFactory implements ScriptEngineFactory {

	@Override
	public String getEngineName() {
		return "DSL Script Engine";
	}

	@Override
	public String getEngineVersion() {
		return "DSL Engine 1.0";
	}

	@Override
	public List<String> getExtensions() {
		return List.of("dsl");
	}

	@Override
	public List<String> getMimeTypes() {
		return List.of("text/dslscript");
	}

	@Override
	public List<String> getNames() {
		return List.of("dsl", "DSL", "DSLScript", "dslscript");
	}

	@Override
	public String getLanguageName() {
		return "DSLScript";
	}

	@Override
	public String getLanguageVersion() {
		return "DSL 1.1";
	}

	@Override
	public Object getParameter(String key) {
		switch (key) {
			case ScriptEngine.ENGINE:
				return getEngineName();
			case ScriptEngine.ENGINE_VERSION:
				return getEngineVersion();
			case ScriptEngine.NAME:
				return getEngineName();
			case ScriptEngine.LANGUAGE:
				return getLanguageName();
			case ScriptEngine.LANGUAGE_VERSION:
				return getLanguageVersion();
			case "THREADING":
				return "MULTITHREADED";
			default:
				return null;
		}
	}

	@Override
	public String getMethodCallSyntax(String obj, String m, String... args) {
		return "Not implemented";
	}

	@Override
	public String getOutputStatement(String toDisplay) {
		return "println(\"" + toDisplay + "\");";
	}

	@Override
	public String getProgram(String... statements) {
		return "Not implemented";
	}

	@Override
	public ScriptEngine getScriptEngine() {
		return new DSLScriptEngine(this);
	}

}
