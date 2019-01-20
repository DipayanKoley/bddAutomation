package utility;

import org.apache.log4j.Logger;

public class Logging
{
	public static Logger Log = Logger.getLogger(Logger.class.getName());
	
	public static void info(String message)
	{
		Log.info(message);
	}
}