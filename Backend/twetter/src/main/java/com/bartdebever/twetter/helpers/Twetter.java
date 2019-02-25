package com.bartdebever.twetter.helpers;

import com.bartdebever.twetter.logging.JLogger;
import com.bartdebever.twetter.logging.interfaces.ILogger;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class Twetter {

    /**
     * Gets a logger object for the given name.
     * @param name the name for the logger object.
     * @return an instance of a logger object.
     */
    public static ILogger getLogger(String name) {
        return new JLogger(name);
    }

    /**
     * Gets a ModelMapper object with the STRICT matching strategy.
     * @return a ModelMapper instance.
     */
    public static ModelMapper getMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return mapper;
    }
}
