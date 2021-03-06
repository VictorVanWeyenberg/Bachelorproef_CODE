package jass.contact;
import jass.engine.*;
import jass.generators.*;

public interface RollForce extends Source {
    // ref values correspond to normal loop speed in wav file, or to
    // reference setting of AR filter, etc.
    void setRollForceReference(float val);
    void setRollSpeedReference(float val);
    void setRollGain(float gain);
}


