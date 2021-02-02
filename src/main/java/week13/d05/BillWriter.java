package week13.d05;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class BillWriter {

    public String writeBills(List<BillItem> items, RowWriter rowWriter) {
        String lines ="";
        for (BillItem billItem :items) {
           lines = lines + rowWriter.writeRow(billItem);
        }
        return lines;
    }


    public static void main(String[] args) {
        List<BillItem> items= new ArrayList<>();
        items.add(new BillItem("kenyér",3,10));
        items.add(new BillItem("tej",5,8));
        items.add(new BillItem("Tejföl",2,6));
        items.add(new BillItem("Gépsonka (dkg)",20,2));
        BillWriter billWriter = new BillWriter();
        String itemList = billWriter.writeBills(items,
                billItem -> format("%20s%15d%15d%15d%n",
                        billItem.getName(),
                        billItem.getNumber(),
                        billItem.getUnitPrice(),
                        billItem.getUnitPrice()+ billItem.getNumber()
                )
        );
        System.out.println(itemList);

        itemList = billWriter.writeBills(items, new RowWriter() {
            @Override
            public String writeRow(BillItem billItem) {
                return new SimpleLineWriter().writeRow(billItem);
            }
        });
        System.out.println(itemList);

    }
}
//Legyen egy BillItem osztály, mely tartalmazza a name, number, unitPrice attribútumokat.
//Legyen egy BillWriter osztály, melynek van egy writeBills() metódusa.
//Ennek a számlatételeket egymás alatt szövegesen vissza kell adnia.
//Ennek első paramétere egy List<BillItem>, azaz megkapja a számlatételeket.
//A második paraméterét neked kell kitalálni! A lényeg, hogy bármit át tudj adni, hogy egy
//számla tételt, hogy lehet kiírni. Ugyanis van, hogy egymás után kell kiírni a 3 attribútumot,
//van, hogy tabokkal elválasztva, van, hogy mögé kell írni az összes árat is. Szóval változhat,
//gyakorlatilag a sor kiirásának algoritmusát kell paraméterül átadni.
//A visszatérési értéke egy String.
//Sem a BillItem, sem a BillWriter metódust nem módosíthatod, és a következő
//kiírási formákat kell megvalósítanod:
//3 kenyér, darabja 10 Ft
//5 tej, darabja 20 Ft
//Megnevezés (20 karakter) Egységár (Ft) Darab Összeg
//kenyer                              10     3     30
//tej                                 20     5    100