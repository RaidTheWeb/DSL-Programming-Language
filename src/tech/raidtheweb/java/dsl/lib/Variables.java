package tech.raidtheweb.java.dsl.lib;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public final class Variables {

    private static Map<String, Value> variables;
    private static final Stack<Map<String, Value>> stack;
    
    static {
    	stack = new Stack<>();
        variables = new HashMap<>();
        variables.put("PI", new NumberValue(3.141592653589793));
        variables.put("E", new NumberValue(2.718281828459045));
        variables.put("GOLDEN_RATIO", new NumberValue(1.618));
    }
    
    public static void push() {
    	stack.push(new HashMap<>(variables));
    }
    
    public static void pop() {
    	variables = stack.pop();
    }
    
    public static boolean isExists(String key) {
        return variables.containsKey(key);
    }
    
    public static Value get(String key) {
        if (!isExists(key)) return new NumberValue(0);
        return variables.get(key);
    }
    
    public static void set(String key, Value value) {
    	variables.put(key, value);
    }
}
