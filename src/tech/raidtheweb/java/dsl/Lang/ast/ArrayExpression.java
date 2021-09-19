package tech.raidtheweb.java.dsl.Lang.ast;

import java.util.List;

import tech.raidtheweb.java.dsl.lib.ArrayValue;
import tech.raidtheweb.java.dsl.lib.Value;

public final class ArrayExpression implements Expression {
    
    private final List<Expression> elements;

    public ArrayExpression(List<Expression> arguments) {
        this.elements = arguments;
    }
    
    @Override
    public Value eval() {
        final int size = elements.size();
        final ArrayValue array = new ArrayValue(size);
        for (int i = 0; i < size; i++) {
            array.set(i, elements.get(i).eval());
        }
        return array;
    }

    @Override
    public String toString() {
        return elements.toString();
    }
}