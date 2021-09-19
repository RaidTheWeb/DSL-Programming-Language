package tech.raidtheweb.java.dsl.Lang;

public class Token {
	
	private TokenType type;
	private String text;
	
	public Token(TokenType type, String text) {
		this.setType(type);
		this.setText(text);
	}

	public TokenType getType() {
		return type;
	}

	public void setType(TokenType type) {
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public String toString() {
		return "DSLTOKEN " + getType() + " " + getText();
	}
}
