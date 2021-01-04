package ioconvert.products;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

public class ProductWriter {
    public void saveProduct(OutputStream os, List<Product> products){

        try (PrintStream ps = new PrintStream(os)){
            for (Product product : products) {
                ps.println(product);
            }
        }

    }
}
