package com.lab.springlab.template;

import java.io.BufferedReader;
import java.io.IOException;

public interface BufferReaderCallBack {
    int doSomethingWithReader(BufferedReader br) throws IOException;
}
