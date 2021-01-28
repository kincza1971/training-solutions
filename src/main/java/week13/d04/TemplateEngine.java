package week13.d04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Map;

public class TemplateEngine {

    public void merge(BufferedReader reader, Map<String, Object> values, BufferedWriter writer) {
        try {
            StringBuilder sb;
            String line;
            String key;
            String newString;
            while ((line = reader.readLine()) != null){
                if (line.contains("{")) {
                    sb=new StringBuilder(line);
                    key = sb.substring(sb.indexOf("{")+1,sb.indexOf("}"));
                    newString = values.get(key).toString();
                    sb.replace(sb.indexOf("{"),sb.indexOf("}")+1,newString);
                    writer.write(sb.toString()+"\n");
                } else {
                    writer.write(line+"\n");
                }
            }
            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
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
