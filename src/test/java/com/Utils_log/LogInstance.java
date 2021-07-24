package com.Utils_log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogInstance {
    // Initialize Log4j instance
    private static final Logger log = LogManager.getLogger(LogInstance.class);

    //info level logs
    public static void info(String message) {

        log.info(message);
    }

    //warn level logs
    public static void warn(String message) {

        LogInstance.warn(message);
    }

    //error level log
    public static void error(String message) {

        LogInstance.error(message);
    }

    //fatal_error level logs
    public static void fatal(String message) {

        LogInstance.fatal(message);
    }

    //debug level logs
    public static void debug(String message) {
        LogInstance.debug(message);
    }
}
