package com.epam.cdp.memorymanagement;


import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Ivan_Spresov
 * Date: 3/3/14
 */
public class MemoryEater {
    static final Logger logger = Logger.getLogger(MemoryEater.class);

    public static void main(String[] args) {
        List v = new ArrayList();
        int arraySize = 1048576;

        long counter = 0;
        while (true) {
            counter++;
            Runtime rt = Runtime.getRuntime();
            long freeMemory = rt.freeMemory();
            if (freeMemory <= arraySize * 13) {
                break;
            }
            v.add(new byte[arraySize]);

            System.out.println("free memory: " + freeMemory + " Counter: " + counter);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
    }
}
