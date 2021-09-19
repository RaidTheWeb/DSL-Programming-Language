package tech.raidtheweb.java.dsl.Lang;

public enum TokenType {

    NUMBER,
    HEX_NUMBER,
    WORD,
    TEXT,
    
    //keyword
    PRINT,
    IF,
    ELSE,
    WHILE,
    FOR,
    CONTINUE,
    BREAK,
    RETURN,
    DEF,
    INCLUDE,
    
    
    PLUS,
    MINUS,
    STAR,
    SLASH,
    EQ,
    LT,
    GT,
    EXCL,
    AMP,
    BAR,
    EQEQ,
    EXCLEQ,
    LTEQ,
    GTEQ,
    AMPAMP,
    BARBAR,
    COMMA,
    
    LPAREN, // (
    RPAREN, // )
    LBRACE,
    RBRACE,
    LBRACKET,
    RBRACKET,
    
    EOF,
}