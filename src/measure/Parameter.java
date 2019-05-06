package measure;

public class Parameter extends Tuple {

    private int voices;
    private int voicesToEQandComp;
    private int effects;
    private int voicesToEffects;

    public Parameter(int voices, int voicesToEQandComp, int effects, int voicesToEffects) {
        super(voices, voicesToEQandComp, effects, voicesToEffects);
        this.voices = voices;
        this.voicesToEQandComp = voicesToEQandComp;
        this.effects = effects;
        this.voicesToEffects = voicesToEffects;
    }

    public int getVoices() {
        return voices;
    }

    public int getVoicesToEQandComp() {
        return voicesToEQandComp;
    }

    public int getEffects() {
        return effects;
    }

    public int getVoicesToEffects() {
        return voicesToEffects;
    }

}
