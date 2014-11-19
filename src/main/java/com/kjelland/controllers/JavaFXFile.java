package com.kjelland.controllers;

import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.io.File;

public class JavaFXFile {

    private Shape shape;
    private File file;

    public JavaFXFile(File file) {
        if (file.isDirectory()) {
            shape = new Polygon();
        } else if (file.canExecute()) {
            shape = new Rectangle();
        } else {
            shape = new Line();
        }
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(final Shape shape) {
        this.shape = shape;
    }

    public File getFile() {
        return file;
    }

    public void setFile(final File file) {
        this.file = file;
    }
}
