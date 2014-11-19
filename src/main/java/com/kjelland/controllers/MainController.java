package com.kjelland.controllers;

import com.kjelland.configuration.ConfigurationHandler;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ex.ConfigurationException;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainController {

    Configuration configuration;

    public MainController() throws ConfigurationException {
        configuration = ConfigurationHandler.getInstance().getConfiguration();
        List<JavaFXFile> files = new ArrayList<>();

        File homeDir = new File(System.getProperty("user.dir"));
        File[] fileArray = homeDir.listFiles();
        List<File> listFiles = Arrays.asList(fileArray != null ? fileArray : new File[0]);
        listFiles.forEach(file -> files.add(new JavaFXFile(file)));
    }
}
