package tech.raidtheweb.java.dsl.Lang.ast;

public final class WhileStatement implements Statement {
    
    private final Expression condition;
    private final Statement statement;

    public WhileStatement(Expression condition, Statement statement) {
        this.condition = condition;
        this.statement = statement;
    }
    
    @Override
    public void execute() {
        while (condition.eval().asDouble() != 0) {
        	try {
        		statement.execute();
        	} catch(BreakStatement bs) {
        		break;
        	} catch(ContinueStatement cs) {
        		continue;
        	}
        }
    }

    @Override
    public String toString() {
        return "while " + condition + " " + statement;
    }
}