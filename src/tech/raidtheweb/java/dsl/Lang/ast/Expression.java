package tech.raidtheweb.java.dsl.Lang.ast;

import tech.raidtheweb.java.dsl.lib.Value;

public interface Expression {
	Value eval();
}
