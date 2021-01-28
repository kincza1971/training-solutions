package week13.d04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

public class TemplateEngine {

    public static final String START_CHAR = "{";
    public static final String END_CHAR = "}";

    public void merge(BufferedReader reader, Map<String, Object> values, BufferedWriter writer) {
        try {
            StringBuilder sb;
            String line;
            String key;
            String newString;
            while ((line = reader.readLine()) != null){
                writeOneLine(values, writer, line);
            }
            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeOneLine(Map<String, Object> values, BufferedWriter writer, String line) throws IOException {
        String key;
        StringBuilder sb;
        String newString;
        if (line.contains(START_CHAR)) {
            sb=new StringBuilder(line);
            key = sb.substring(sb.indexOf(START_CHAR)+1,sb.indexOf(END_CHAR));
            newString = values.get(key).toString();
            sb.replace(sb.indexOf(START_CHAR),sb.indexOf(END_CHAR)+1,newString);
            writer.write(sb.toString()+"\n");
        } else {
            writer.write(line +"\n");
        }
    }
}

//Írj egy sablonkezelő rendszert! Hozz létre egy TemplateEngine nevezetű osztályt, benne egy
//void merge(BufferedReader reader, Map<String, Object>, BufferedWriter writer)
//metódussal. Az első paraméter a sablon, a második paraméter pedig az értékek, melyeket ki kell cserélni a sablonban.
//Képzeljük el, hogy ez a sablon:
//Kedves {nev}!
//Megküldjük önnek a következő esedékes számláját {datum} dátummal,
//melynek összege: {osszeg} Ft!
//A fizetési határidő {hatarido}.
//Üdvözlettel,
//Ügyfélszolgálat
//A metódus második paraméterként egy Map-ben kapja az értékeket:
//{"nev" = "John Doe", "datum" = LocalDate}
//A feladat, hogy a writer-be ki kell írni a levelet, de már
//kicserélve az értékeket. (edited)
