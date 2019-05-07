package measure;

import io.MeasurementWriter;
import main.StartUp;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class Measurer {

    private static final Sigar sigar = new Sigar();
    private static CpuPerc cpuMeasurer;
    private static Mem memMeasurer;

    private static final String BASH_COMMAND = "top -b -n1 -d,01 | grep 4338 | awk '{ if ($9 != \"0,0\") print $9 \" \" $10 }'";

    private static double getCpuLoadPercentage() {
        if (cpuMeasurer == null) {
            try {
                cpuMeasurer = sigar.getCpuPerc();
            } catch (SigarException e) {
                e.printStackTrace();
            }
        }
        return cpuMeasurer.getCombined() * 100;
    }

    private static double getMemoryLoadPercentae() {
        if (memMeasurer == null) {
            try {
                memMeasurer = sigar.getMem();
            } catch (SigarException e) {
                e.printStackTrace();
            }
        }
        return memMeasurer.getUsedPercent();
    }

    public static void measureSigar(int ID, Parameter parameter) throws InterruptedException {
        for (int index = 0; index < 50; index++) {
            Measurement measurement = new Measurement(ID, index, parameter, getCpuLoadPercentage(), getMemoryLoadPercentae());
            MeasurementWriter.write(measurement);
            System.out.println(measurement);
            TimeUnit.MILLISECONDS.sleep(10);
        }
    }

    public static void measureTop(int ID, Parameter parameter) throws InterruptedException, IOException {
        int index = 0;
        String[] command = new String[] {"/bin/sh", "-c", String.format(BASH_COMMAND, StartUp.getPID())};
        Process process; BufferedReader reader; String output;
        Runtime runtime = Runtime.getRuntime();
        while (index < 50) {
            process = runtime.exec(command);
            reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            output = reader.readLine();
            reader.close();
            process.waitFor();
            double cpuLoad = 0;
            try {
                cpuLoad = Float.valueOf(output.replaceAll(",", ".").split(" ")[0]);
                if (cpuLoad > 0) {
                    double memLoad = Float.valueOf(output.replaceAll(",", ".").split(" ")[1]);
                    Measurement measurement = new Measurement(ID, index, parameter, cpuLoad, memLoad);
                    MeasurementWriter.write(measurement);
                    index++;
                }
            } catch (NullPointerException ex) {

            } catch (NumberFormatException ex) {

            }
        }
    }

}
