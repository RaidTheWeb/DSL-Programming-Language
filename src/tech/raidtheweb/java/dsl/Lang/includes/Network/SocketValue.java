package tech.raidtheweb.java.dsl.Lang.includes.Network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import tech.raidtheweb.java.dsl.lib.NumberValue;
import tech.raidtheweb.java.dsl.lib.StringValue;
import tech.raidtheweb.java.dsl.lib.Value;

public final class SocketValue implements Value {

	private final Socket socket;
	
	private BufferedReader input;
	private BufferedWriter output;
	
	public SocketValue(Socket socket) {
		this.socket = socket;
		try {	
			this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			this.output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Value isConnected() {
		return new NumberValue(socket.isConnected());
	}
	
	public Value close() {
		try {
			socket.close();
			return new NumberValue(1);
		} catch(IOException e) {
			return new NumberValue(0);
		}
	}
	
	public Value writeString(Value msg) {
		try {
			output.write(msg.asString());
			output.flush();
			return new NumberValue(true);
		} catch (IOException e) {
			return new NumberValue(false);
		}
	}
	
	public Value readLine() {
		try {
			return new StringValue(input.readLine());
		} catch (IOException e) {
			return new NumberValue(0);
		}
	}
	
	@Override
	public double asDouble() {
		return 0;
	}

	@Override
	public String asString() {
		return "Socket[address=" + socket.getRemoteSocketAddress() + ", port=" + socket.getPort() + "]";
	}

	@Override
	public int asInt() {
		return 0;
	}

}
