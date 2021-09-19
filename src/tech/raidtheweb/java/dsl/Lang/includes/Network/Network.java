package tech.raidtheweb.java.dsl.Lang.includes.Network;

import java.net.*;
import java.io.*;
import tech.raidtheweb.java.dsl.Lang.ast.Library;
import tech.raidtheweb.java.dsl.lib.ArrayValue;
import tech.raidtheweb.java.dsl.lib.Function;
import tech.raidtheweb.java.dsl.lib.Functions;
import tech.raidtheweb.java.dsl.lib.NumberValue;
import tech.raidtheweb.java.dsl.lib.Value;
import tech.raidtheweb.java.dsl.lib.StringValue;
import tech.raidtheweb.java.dsl.lib.Variables;

public final class Network implements Library {
	public Network() {
		Value[] LOOPBACKS = new Value[2];
		LOOPBACKS[0] = new StringValue("localhost");
		LOOPBACKS[1] = new StringValue("127.0.0.1");
		Variables.set("LOOPBACKS", new ArrayValue(LOOPBACKS));
		Functions.set("CreateSocket", (Function) (Value[] args) -> {
			if(args.length == 2) {
				try {
					return new SocketValue(new Socket(args[0].asString(), (int) args[1].asDouble()));
				} catch (UnknownHostException e) {
					return new NumberValue(0);
				} catch (IOException e) {
					return new NumberValue(0);
				}
			} else {
				throw new RuntimeException("Invalid number of arguments");
			}
		});
		
		Functions.set("CloseSocket", (Function) (Value[] args) -> {
			if(args.length == 1) {
				if(args[0] instanceof SocketValue) {
					SocketValue socket = (SocketValue) args[0];
					return socket.close();
				} else {
					throw new RuntimeException("Invalid arguments, excepted argument of type Socket");
				}
			} else {
				throw new RuntimeException("Invalid number of arguments");
			}
		});
		
		Functions.set("WriteToSocket", (Function) (Value[] args) -> {
			if(args.length == 2) {
				if(args[0] instanceof SocketValue) {
					SocketValue socket = (SocketValue) args[0];
					return socket.writeString(args[1]);
				} else {
					throw new RuntimeException("Invalid arguments, excepted argument of type Socket");
				}
			} else {
				throw new RuntimeException("Invalid number of arguments");
			}
		});
		
		Functions.set("ReadSocket", (Function) (Value[] args) -> {
			if(args.length == 1) {
				if(args[0] instanceof SocketValue) {
					SocketValue socket = (SocketValue) args[0];
					return socket.readLine();
				} else {
					throw new RuntimeException("Invalid arguments, excepted argument of type Socket");
				}
			} else {
				throw new RuntimeException("Invalid number of arguments");
			}
		});
	}
}
