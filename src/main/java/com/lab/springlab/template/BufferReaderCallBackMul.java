package com.lab.springlab.template;

import java.io.BufferedReader;
import java.io.IOException;

public class BufferReaderCallBackMul implements BufferReaderCallBack {

    @Override
    public int doSomethingWithReader(BufferedReader br) throws IOException {
        int mul = 1;
        String line = null;
        while ((line = br.readLine()) != null) {
            mul *= Integer.parseInt(line);
        }
        return mul;
    }
}
