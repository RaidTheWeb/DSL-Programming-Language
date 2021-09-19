package tech.raidtheweb.java.dsl.Lang.includes.StringMethods;

import tech.raidtheweb.java.dsl.Lang.ast.Library;
import tech.raidtheweb.java.dsl.lib.StringValue;
import tech.raidtheweb.java.dsl.lib.Variables;

public final class StringMethods implements Library {
	public StringMethods() {
		Variables.set("string_ASCIIALPHA", new StringValue("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"));
		Variables.set("string_ASCIIALPHANUM", new StringValue("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"));
		Variables.set("string_ASCIISYMBOLS", new StringValue("`~!@#$%^&*()_+-={}[]|\\:;\"'<>,.?/"));
		Variables.set("string_ESCAPECODES", new StringValue("\\n\\" + "\\" + "\\\"\\'\\r\\t"));
	}
}
