package week07.d04;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ShoppingList {
    public static final String FIELD_SEPARATOR = ";";
    List<Item> items = new ArrayList<>();


    private Item processLine(String itemStr) {
        String[] strValues;
        strValues = itemStr.split(FIELD_SEPARATOR);
        return new Item(strValues[0], Double.parseDouble(strValues[1]),Double.parseDouble(strValues[2]));
    }


    private long calculate(){
        long sum = 0;
        for (Item item : items) {
            sum += item.getAmount();
        }
        return sum;
    }

    private void getItemsFromFile(String filePath)  {
        Path file = Path.of(filePath);
        List<String> itemStrs;
        try {
//            itemStrs =Files.readAllLines(file, Charset.forName("UTF-8")); // ez is jó
            itemStrs =Files.readAllLines(file, StandardCharsets.UTF_8);
            for (String itemStr : itemStrs) {
                items.add(processLine(itemStr));
            }
        }
        catch (IOException e) {
            throw new IllegalStateException("Cannot read file",e);
        }
    }

    public long calculateSum(String path) {
        if (path == null || path.isBlank()) {
            throw new IllegalArgumentException("Az elérési út nem lehet null, vagy üres");
        }
        getItemsFromFile(path);
        return calculate();
    }
 }
