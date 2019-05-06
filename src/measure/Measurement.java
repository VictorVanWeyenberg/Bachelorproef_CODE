package measure;

public class Measurement extends Tuple {

    public Measurement (Parameter parameter, double cpuLoad, double memLoad) {
        super(parameter.getVoices(), parameter.getVoicesToEQandComp(), parameter.getEffects(), parameter.getVoicesToEffects(), cpuLoad, memLoad);
    }

}
