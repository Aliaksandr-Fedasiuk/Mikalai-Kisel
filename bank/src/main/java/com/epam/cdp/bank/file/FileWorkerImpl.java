package com.epam.cdp.bank.file;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Implements FileWorker. Key word "synchronized" is used for synchronization read/write processing. We can only read or only write at one moment.
 * </p>
 *
 * @author kisel.nikolay@gmail.com
 * @since 26.10.2014
 */
public class FileWorkerImpl implements FileWorker {

    public static final Logger logger = Logger.getLogger(FileWorkerImpl.class);
    public static final String DEFAULT_FILENAME = "/home/mikalai/test.txt";

    private String fileName = DEFAULT_FILENAME;
    private final Object sync = new Object();

    public FileWorkerImpl() {
    }

    public FileWorkerImpl(String fileName) {
        this.fileName = fileName;
    }

    public void write(final String str) throws IOException {
        synchronized (sync) {
            try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName, true))) {
                fileWriter.append(str).append("\n");
                logger.info(str + " was appended to file.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public List<String> read() {
        synchronized (sync) {
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
            }

            return results;
        }
    }

    public String getFileName() {
        return fileName;
    }
}
