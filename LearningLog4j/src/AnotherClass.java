import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AnotherClass {
	static Logger logger = LogManager.getLogger();
	
	public void testLogger(){
		logger.log(Level.FATAL, "FATAL Event");
		logger.log(Level.INFO, "Info Event");

	}

}
