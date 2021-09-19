package tech.raidtheweb.java.dsl.Lang.ast;

public final class BreakStatement extends RuntimeException implements Statement {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4120639991357797603L;

	@Override
	public void execute() {
		throw this;

	}
	
	@Override
	public String toString() {
		return "BreakStatement";
	}

}
