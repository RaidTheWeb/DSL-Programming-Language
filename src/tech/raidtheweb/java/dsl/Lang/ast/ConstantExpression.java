package tech.raidtheweb.java.dsl.Lang.ast;

import tech.raidtheweb.java.dsl.lib.Value;
import tech.raidtheweb.java.dsl.lib.Variables;

public final class ConstantExpression implements Expression {
    
    private final String name;
    
    public ConstantExpression(String name) {
        this.name = name;
    }

    @Override
    public Value eval() {
        if (!Variables.isExists(name)) throw new RuntimeException("Constant does not exists");
        return Variables.get(name);
    }

    @Override
    public String toString() {
//        return String.format("%s [%f]", name, Constants.get(name));
        return String.format("%s", name);
    }
}
