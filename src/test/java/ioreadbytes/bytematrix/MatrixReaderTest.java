package ioreadbytes.bytematrix;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatrixReaderTest {
    MatrixReader matrixReader = new MatrixReader();

//    @BeforeAll
//    public static void createFile() throws IOException {
//        Path file = Path.of("D:/dnload/github/training-solutions/src/main/resources/matrix.dat");
//        BufferedWriter bw = Files.newBufferedWriter(file, StandardOpenOption.CREATE_NEW);
//        Random rnd = new Random();
//        for (int i = 0; i<5500;i++) {
//            bw.write((char) rnd.nextInt(2));
//        }
//        bw.close();
//    }


    @Test
    public void readBytesAndCreateMatrixTest() {
        assertEquals(0, matrixReader.getMyMatrix().size());
        matrixReader.readBytesAndCreateMatrix("/matrix.dat");

        assertEquals(6, matrixReader.getMyMatrix().size());
        assertEquals(1000, matrixReader.getMyMatrix().get(5).length);
    }


    @Test
    public void numberOfColumnsWhereMoreZeros() {
        matrixReader.readBytesAndCreateMatrix("/matrix.dat");
        assertEquals(493, matrixReader.numberOfColumnsWhereMoreZeros());
    }

}