package tech.raidtheweb.java.dsl.Lang.includes.HTTPModule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import tech.raidtheweb.java.dsl.Lang.ast.Library;
import tech.raidtheweb.java.dsl.lib.Function;
import tech.raidtheweb.java.dsl.lib.Functions;
import tech.raidtheweb.java.dsl.lib.NumberValue;
import tech.raidtheweb.java.dsl.lib.StringValue;
import tech.raidtheweb.java.dsl.lib.Value;

public final class HTTPModule implements Library {
	public HTTPModule() {
		Functions.set("GetRequest", (Function) (Value... args) -> {
			if(args.length == 1) {
				try {
					URL url = new URL(args[0].asString());
					HttpURLConnection con = (HttpURLConnection) url.openConnection();
					con.setRequestMethod("GET");
					int status = con.getResponseCode();
					if(status == 200) {
						BufferedReader in = new BufferedReader(
								new InputStreamReader(con.getInputStream()));
						String inputLine;
						StringBuffer content = new StringBuffer();
						while ((inputLine = in.readLine()) != null) {
						    content.append(inputLine);
						}
						String response = content.toString();
						in.close();
						return new StringValue(response);
					}
				} catch (MalformedURLException e) {
					throw new RuntimeException("Exception occured during request");
				} catch (IOException e) {
					throw new RuntimeException("Exception occured during request");
				}
			} else {
				throw new RuntimeException("Invalid number of arguments");
			}
			return new NumberValue(0);
		});
	}
}
