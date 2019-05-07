package io;

import measure.Measurement;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class MeasurementWriter {

    private static final String CSV = ".csv";
    private static FileWriter writer;

    public static void open(String fileName) {
        try {
            writer = new FileWriter(String.format("%s%s", fileName, CSV));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write(Measurement measurement) {
        try {
            writer.write(measurement.toString().endsWith("\n") ?
                    measurement.toString() :
                    new StringBuilder(measurement.toString()).append("\n").toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void flush() {
        try {
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
