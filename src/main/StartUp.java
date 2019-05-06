/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import beads.BeadsTemplate;
import jsyn.JSynTemplate;
import net.beadsproject.beads.core.io.JavaSoundAudioIO;

/**
 *
 * @author Reznov
 */
public class StartUp {
    
    private static Object[][] data = new Object[][] {
        {"Hobbyist", 4, 0, 0, 0},
        {"Live band", 10, 0, 2, 5},
        {"Metal band", 40, 40, 3, 15},
        {"Jazz concert", 50, 50, 5, 20},
        {"Video productie", 150, 150, 0, 0}
    };
    
    private static Template[] benchmarks = new Template[] {
        new JSynTemplate(),
        new BeadsTemplate(),
    };

    public static void main(String[] args) throws InterruptedException {
        new StartUp();
        // JavaSoundAudioIO.printMixerInfo();
    }
    
    public StartUp() throws InterruptedException {
        Set<Thread> firstSet = Thread.getAllStackTraces().keySet();
        firstSet.stream().map(Thread::getName).filter(thread -> thread.equals("Thread-0")).forEach(System.out::println);
        for (Object[] args : data) {
            for (Template benchmark : benchmarks) {
                benchmark.reset();
                benchmark.setup((int) args[1], (int) args[2], (int) args[3], (int) args[4]);
                System.out.printf("%s: Measuring case \"%s\".%n", benchmark.getName(), args[0]);
                TimeUnit.SECONDS.sleep(1);
                benchmark.run();
                TimeUnit.SECONDS.sleep(2);
                benchmark.stop();
                benchmark.tearDown();
            }
        }
    }
}
