package com.epam.cdp.multithreading.file;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 * ReentrantLock is used for synchronization.
 * </p>
 * @author kisel.nikolay@gmail.com
 * @since 26.10.2014
 */
public class FileWorkerImpl2 implements FileWorker {

    public static final Logger logger = Logger.getLogger(FileWorkerImpl2.class);
    public static final String DEFAULT_FILENAME = "/home/mikalai/test.txt";

    private String fileName = DEFAULT_FILENAME;

    private final ReentrantLock readLock = new ReentrantLock();
    private final ReentrantLock writeLock = new ReentrantLock();

    @Override
    public void write(String str) throws IOException {
        readLock.lock();
        writeLock.lock();
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName, true))) {
            Thread.sleep(10000);
            fileWriter.append(str).append("\n");
            logger.info(str + " was appended to file.");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
            readLock.unlock();
        }
    }

    @Override
    public List<String> read() {
        writeLock.lock();
        List<String> results = new ArrayList<>();
        try {
            String line;
            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
            while ((line = fileReader.readLine()) != null) {
                logger.info(line + " was read from file.");
                results.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }

        return results;
    }
}
