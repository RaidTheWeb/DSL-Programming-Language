package tech.raidtheweb.java.dsl.Lang.includes.DateMethods;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;

import tech.raidtheweb.java.dsl.Lang.ast.Library;
import tech.raidtheweb.java.dsl.lib.ArrayValue;
import tech.raidtheweb.java.dsl.lib.Function;
import tech.raidtheweb.java.dsl.lib.Functions;
import tech.raidtheweb.java.dsl.lib.NumberValue;
import tech.raidtheweb.java.dsl.lib.StringValue;
import tech.raidtheweb.java.dsl.lib.Value;
import tech.raidtheweb.java.dsl.lib.Variables;

public final class DateMethods implements Library {
	public DateMethods() {
		Variables.set("STYLE_FULL", new NumberValue(DateFormat.FULL));
		Variables.set("STYLE_LONG", new NumberValue(DateFormat.LONG));
		Variables.set("STYLE_MEDIUM", new NumberValue(DateFormat.MEDIUM));
		Variables.set("STYLE_SHORT", new NumberValue(DateFormat.SHORT));
		Functions.set("NewDate", (Function) (Value... args) -> {
			final Calendar calendar = Calendar.getInstance();
			calendar.clear();
			switch (args.length) {
				case 0:
					calendar.setTimeInMillis(System.currentTimeMillis());
					break;
				case 1:
					try {
						calendar.setTime(DateFormat.getDateInstance().parse(args[0].asString()));
					} catch (ParseException ignore) { }
					break;
			}
			return DateValue.from(calendar);
		});
		Functions.set("GetDateField", (Function) (Value... args) -> {
			if(args.length == 2) {
				if(args[0] instanceof DateValue && args[1] instanceof StringValue) {
					DateValue date = (DateValue) args[0];
					return date.getField(args[1].asString());
				} else {
					throw new RuntimeException("Invalid arguments, excepted arguments of type Date and String");
				}
			} else {
				throw new RuntimeException("Invalid number of arguments");
			}
		});
		
		Functions.set("GetDateFields", (Function) (Value... args) -> {
			if(args.length == 1) {
				if(args[0] instanceof DateValue) {
					DateValue date = (DateValue) args[0];
					return date.getFields();
				} else {
					throw new RuntimeException("Invalid arguments, excepted arguments of type Date and String");
				}
			} else {
				throw new RuntimeException("Invalid number of arguments");
			}
		});
	}
	
	private static class DateValue implements Value {
		
		public NumberValue YEAR;
		public NumberValue MONTH;
		public NumberValue DAY;
		public NumberValue HOUR;
		public NumberValue MINUTE;
		public NumberValue SECOND;
		public NumberValue MILLISECOND;
		
		public static DateValue from(Calendar calendar) {
			final DateValue value = new DateValue();
			value.YEAR = new NumberValue(calendar.get(Calendar.YEAR));
			value.MONTH = new NumberValue(calendar.get(Calendar.MONTH));
			value.DAY = new NumberValue(calendar.get(Calendar.DAY_OF_MONTH));
			value.HOUR = new NumberValue(calendar.get(Calendar.HOUR_OF_DAY));
			value.MINUTE = new NumberValue(calendar.get(Calendar.MINUTE));
			value.SECOND = new NumberValue(calendar.get(Calendar.SECOND));
			value.MILLISECOND = new NumberValue(calendar.get(Calendar.MILLISECOND));
			return value;
		}
		
		public Value getField(String field) {
			switch(field) {
				case "YEAR":
					return YEAR;
				case "MONTH":
					return MONTH;
				case "DAY":
					return DAY;
				case "HOUR":
					return HOUR;
				case "MINUTE":
					return MINUTE;
				case "SECOND":
					return SECOND;
				case "MILLISECOND":
					return MILLISECOND;
				default:
					return new StringValue("UNKNOWN");
			}
		}
		
		public Value getFields() {
			Value[] fields = new Value[7];
			fields[0] = YEAR;
			fields[1] = MONTH;
			fields[2] = DAY;
			fields[3] = HOUR;
			fields[4] = MINUTE;
			fields[5] = SECOND;
			fields[6] = MILLISECOND;
			return new ArrayValue(fields);
		}

		@Override
		public double asDouble() {
			return 0;
		}

		@Override
		public String asString() {
			return "Date[date=" + MONTH.asInt() + "/" + DAY.asInt() + "/" + YEAR.asInt() + "]";
		}
		
		@Override
		public String toString() {
			return asString();
		}

		@Override
		public int asInt() {
			return 0;
		}
	}
}
