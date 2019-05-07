package measure;

public class Measurement extends Tuple {

    public Measurement (int ID, int index, Parameter parameter, double cpuLoad, double memLoad) {
        super(ID, index, parameter.getVoices(), parameter.getVoicesToEQandComp(), parameter.getEffects(), parameter.getVoicesToEffects(), cpuLoad, memLoad);
    }

}
