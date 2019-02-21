package com.bartdebever.twetter.logging;

import com.bartdebever.twetter.logging.interfaces.ILogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JLogger implements ILogger {
    private Logger logger;

    public JLogger(String name) {
        logger = LogManager.getLogger(name);
    }

    @Override
    public void info(String message, Object... formatObjects) {
        logger.info(message, formatObjects);
    }

    @Override
    public void error(String message, Object... formatObjects) {
        logger.error(message, formatObjects);
    }

    @Override
    public void warning(String message, Object... formatObjects) {
        logger.warn(message, formatObjects);
    }

    @Override
    public void debug(String message, Object... formatObjects) {
        logger.debug(message, formatObjects);
    }

    @Override
    public String getName() {
        return logger.getName();
    }
}
