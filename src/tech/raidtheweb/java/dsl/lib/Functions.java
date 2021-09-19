package tech.raidtheweb.java.dsl.lib;

import java.util.HashMap;
import java.util.Map;

import tech.raidtheweb.java.dsl.Lang.includes.Standard.LengthAThing;
import tech.raidtheweb.java.dsl.Lang.includes.Standard.ReadAThing;
import tech.raidtheweb.java.dsl.Lang.includes.Standard.SplitString;

public final class Functions {

    private static final Map<String, Function> functions;
    
    static {
        functions = new HashMap<>();
        functions.put("PrintLine", (Function) (Value... args) -> {
        	for (Value arg : args) {
        		System.out.print(arg.asString());
        	}
        	System.out.println();
        	return new NumberValue(1);
        });
        functions.put("NewArray", args -> {
        	return new ArrayValue(args);
        });
        functions.put("ReadLine", new ReadAThing());
        functions.put("Length", new LengthAThing());
        functions.put("Split", new SplitString());
    }
    
    public static boolean isExists(String key) {
        return functions.containsKey(key);
    }
    
    public static Function get(String key) {
        if (!isExists(key)) throw new RuntimeException("Unknown function " + key);
        return functions.get(key);
    }
    
    public static void set(String key, Function function) {
    	functions.put(key, function);
    }
}
