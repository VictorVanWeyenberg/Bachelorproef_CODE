package io;

import measure.Measurement;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class MeasurementWriter {

    private static final String measurementFileName = "measurements.csv";

    public static void write(Measurement measurement) {
        try (FileWriter writer = new FileWriter(measurementFileName, true)) {
            writer.write(measurement.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void reset() {
        new File(measurementFileName).delete();
    }
}
