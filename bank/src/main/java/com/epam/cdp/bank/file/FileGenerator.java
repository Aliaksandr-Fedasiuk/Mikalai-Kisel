package com.epam.cdp.bank.file;

import java.io.IOException;

/**
 * @author kisel.nikolay@gmail.com
 * @since 26.10.2014
 */
public class FileGenerator extends Thread {

    private FileWorker fileWorker;
    private String text;

    public FileGenerator(FileWorker fileWorker, String text) {
        this.fileWorker = fileWorker;
        this.text = text;
    }

    @Override
    public void run() {
        try {
            fileWorker.write(text);
            Thread.sleep(1000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
