package com.lab.springlab.template;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Calculator {

    // 공통된 부분과 다른 부분을 분리해서 나누자 -> interface 사용
    public Integer calcSumOrigin(String filepath) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filepath));
            int sum = 0;
            String line = null;
            while ((line = br.readLine()) != null) {
                sum += Integer.parseInt(line);
            }
            return sum;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public Integer calcSumRefactor(String filepath) throws IOException {
        return lineReadTemplate(filepath, new LineCallBackAdd(), 0);
        //return fileReadTemplate(filepath, new BufferReaderCallBackAdd());
    }

    public Integer calcMulRefactor(String filepath) throws IOException {
        return lineReadTemplate(filepath, new LineCallBackMul(), 1);
        //return fileReadTemplate(filepath, new BufferReaderCallBackMul());
    }

    //  v1
    public int fileReadTemplate(String filepath, BufferReaderCallBack callBack) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filepath));
            int ret = callBack.doSomethingWithReader(br);
            return ret;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    // v2
    public int lineReadTemplate(String filepath, LineCallBack callBack, int initVal) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filepath));
            int ret = initVal;
            String line = null;
            ret = callBack.doSomethingWithLine(line, ret);
            return ret;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
