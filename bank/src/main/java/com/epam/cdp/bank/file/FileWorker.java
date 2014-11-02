package com.epam.cdp.bank.file;

import java.io.IOException;
import java.util.List;

/**
 * @author kisel.nikolay@gmail.com
 * @since 26.10.2014
 */
public interface FileWorker {

    public void write(final String str) throws IOException;

    public List<String> read();
}
