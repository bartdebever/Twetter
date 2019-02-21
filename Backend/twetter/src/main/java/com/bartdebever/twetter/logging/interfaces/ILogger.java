package com.bartdebever.twetter.logging.interfaces;

public interface ILogger {
    void info(String message, Object... formatObjects);

    void error(String message, Object... formatObjects);

    void warning(String message, Object... formatObjects );

    void debug(String message, Object... formatObjects);

    String getName();
}
