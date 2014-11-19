package com.kjelland.configuration;


import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.configuration.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration.builder.XMLBuilderParametersImpl;
import org.apache.commons.configuration.ex.ConfigurationException;

import java.io.File;
import java.io.IOException;

public class ConfigurationHandler {

    public static final String FS_SEPARATOR = System.getProperty("file.separator");
    public static final String CONFIG_FOLDER = ".javafxplorer";
    public static final String CONFIG_FILE_NAME = "settings.xml";
    private static final Object threadLock = new Object();
    private static volatile ConfigurationHandler instance;
    private final Configuration configuration;
    private final FileBasedConfigurationBuilder<XMLConfiguration> builder;

    private ConfigurationHandler() throws ConfigurationException {
        File file = new File(System.getProperty("user.home")
                + FS_SEPARATOR
                + CONFIG_FOLDER
                + FS_SEPARATOR
                + CONFIG_FILE_NAME);
        builder = new FileBasedConfigurationBuilder<>(XMLConfiguration.class)
                .configure(new XMLBuilderParametersImpl());
        try {
            builder.getFileHandler().load(file);
            builder.setAutoSave(true);
        } catch (ConfigurationException e) {
            try {
                if (file.createNewFile()) {
                    builder.getFileHandler().setFile(file);
                    builder.getFileHandler().load();
                } else {
                    System.exit(0);
                    throw new RuntimeException();
                }
            } catch (ConfigurationException | IOException ignored) {
            }
        } finally {
            configuration = builder.getConfiguration();
        }

    }

    public static ConfigurationHandler getInstance() throws ConfigurationException {
        if (instance == null) {
            synchronized (threadLock) {
                if (instance == null) {
                    instance = new ConfigurationHandler();
                }
            }
        }
        return instance;
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
