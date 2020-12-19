package ioreadbytes.bytematrix;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MatrixReader {

    private List<byte[]> byteMatrix = new ArrayList<>();

    public void readBytesAndCreateMatrix(String path) {
        try {//Files.newInputStream(Path.of(path))
            InputStream ir = new BufferedInputStream(MatrixReader.class.getResourceAsStream(path));
            int size;
            byte[] bytes = new byte[1000];
            while ((size = ir.read(bytes)) >0) {
                byteMatrix.add(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public int numberOfColumnsWhereMoreZeros() {
        int zeros;
        int ones;
        int moreZeros =0;
        for (int i = 0 ; i<1000 ; i++) {
            zeros = 0;
            ones = 0;
            for(byte[] bytes : byteMatrix) {
                if (bytes.length > i) {
                    if (bytes[i] == 0) {
                        zeros++;
                    } else {
                        ones++;
                    }
                }
            }
            if (zeros > ones) {
                moreZeros++;
            }
        }
        return moreZeros;
    }

    public List<byte[]> getMyMatrix() {
        return new ArrayList<>(byteMatrix);
    }
}

