package edu.mum.mpp.util;

import org.slf4j.Logger;

import java.io.PrintWriter;
import java.io.StringWriter;


public class LoggerUtil {

    public static void logError(Logger logger, Exception ex){
        StringWriter sw = new StringWriter();
        ex.printStackTrace(new PrintWriter(sw));
        logger.error(sw.toString());
    }
}
