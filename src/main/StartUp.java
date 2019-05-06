/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import beads.BeadsTemplate;
import io.MeasurementWriter;
import jsyn.JSynTemplate;
import measure.Measurer;
import measure.Parameter;
import net.beadsproject.beads.core.io.JavaSoundAudioIO;

/**
 * @author Reznov
 */
public class StartUp {

    private final static List<Parameter> parameters = new ArrayList<>();
    private final Scanner input = new Scanner(System.in);

    static {
        int voices, voicesToEQandComp, effects, voicesToEffects;
        for (voices = 4; voices <= 150; voices += 2) {
            for (voicesToEQandComp = voices / 2; voicesToEQandComp <= voices; voicesToEQandComp++) {
                for (effects = 0; effects <= 5; effects++) {
                    if (effects > 0) {
                        for (voicesToEffects = 1; voicesToEffects <= voices / 2; voicesToEffects++) {
                            parameters.add(new Parameter(voices, voicesToEQandComp, effects, voicesToEffects));
                        }
                    } else {
                        parameters.add(new Parameter(voices, voicesToEQandComp, effects, 0));
                    }
                }
            }
        }
    }

    private static Template[] templates = new Template[]{
            new BeadsTemplate(),
            new JSynTemplate(),
    };

    public static void main(String[] args) throws InterruptedException {
        new StartUp();
        // System.out.println(System.getProperty("java.library.path"));
        // parameters.stream().filter(parameter -> parameter.getVoices() == 4).forEach(System.out::println);
        // JavaSoundAudioIO.printMixerInfo();
    }

    public StartUp() throws InterruptedException {
        // askForNewMeasurement();
        for (Template benchmark : templates) {
            for (Parameter parameter : parameters) {
                benchmark.reset();
                benchmark.setup(parameter.getVoices(), parameter.getVoicesToEQandComp(), parameter.getEffects(), parameter.getVoicesToEffects());
                System.out.printf("%s: Measuring case %s.%n", benchmark.getName(), parameter);
                TimeUnit.SECONDS.sleep(1);
                benchmark.run();
                Measurer.measure(parameter);
                TimeUnit.SECONDS.sleep(2);
                benchmark.stop();
                benchmark.tearDown();
            }
        }
    }

    private void askForNewMeasurement() {
        System.out.print("Delete old measurement? [Y/N]: ");
        String answer = null;
        while (answer != "Y" || answer != "N") {
            answer = input.nextLine();
        }
        if (answer.equals("Y")) {
            MeasurementWriter.reset();
        }
        System.out.println("yep");
    }
}
