/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Reznov
 * @param <Voice>
 * @param <Effect>
 */
public abstract class Template<Voice, Equalizer, Compressor, Effect> {
    
    private String name;
    
    protected List<Voice> voices = new ArrayList<>();
    protected List<Equalizer> equalizers = new ArrayList<>();
    protected List<Compressor> compressors = new ArrayList<>();
    protected List<Effect> effects = new ArrayList<>();
    
    public Template(String name) {
        this.name = name;
    }
    
    public void reset() {
        voices.clear();
        equalizers.clear();
        compressors.clear();
        effects.clear();
    }
    
    public String getName() {
        return this.name;
    }
   
    public abstract void setup(int voices, int voicesToEQAndComp, int effects, int voicesToEffects);
    
    public abstract void run();
    
    public abstract void stop();
    
    public abstract void tearDown();

    protected abstract void initLibrary();
    
}
