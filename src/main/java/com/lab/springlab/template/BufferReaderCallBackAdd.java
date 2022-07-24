package com.lab.springlab.template;

import java.io.BufferedReader;
import java.io.IOException;

public class BufferReaderCallBackAdd implements BufferReaderCallBack {

    @Override
    public int doSomethingWithReader(BufferedReader br) throws IOException {
        int sum = 0;
        String line = null;
        while ((line = br.readLine()) != null) {
            sum += Integer.parseInt(line);
        }
        return sum;
    }
}
