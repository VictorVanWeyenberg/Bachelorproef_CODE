package measure;

import io.MeasurementWriter;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

public class Measurer {

    private static final Sigar sigar = new Sigar();
    private static CpuPerc cpuMeasurer;
    private static Mem memMeasurer;

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

    public static void measure(Parameter parameter) {
        Measurement measurement = new Measurement(parameter, getCpuLoadPercentage(), getMemoryLoadPercentae());
        MeasurementWriter.write(measurement);
    }

}
