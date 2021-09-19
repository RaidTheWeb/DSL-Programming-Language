package tech.raidtheweb.java.dsl.Lang.ast;

public final class ContinueStatement extends RuntimeException implements Statement {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5841852554281708193L;

	@Override
	public void execute() {
		throw this;

	}
	
	@Override
	public String toString() {
		return "ContinueStatement";
	}

}
