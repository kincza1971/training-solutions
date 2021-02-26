package week17.d02;

import java.time.LocalDateTime;

public class TrackPoint {
    private long id;
    private LocalDateTime time;
    private double lat;
    private double lon;


    public TrackPoint(long id, LocalDateTime time, double lat, double lon) {
        this.id = id;
        this.time = time;
        this.lat = lat;
        this.lon = lon;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }
}

//Az aktivitásokhoz pontokat is lehet felvinni, ha pl. GPS-szel nyomon követtük a mozgásunk, pl. a futásunk.
//
//Írj egy TrackPoint osztályt, melynek attribútumai:
//
//id - egyedi azonosító
//time - LocalDate
//lat és lon - koordináták, szélességi és hosszúsági fok
//Az Activity tartalmazzon egy List<TrackPoint> attribútumot! Módosítsd a saveActivity() metódust,
// hogy egy tranzakcióban mentse le a TrackPoint objektumokat is a track_point táblába. Hozd létre a táblát!
// A track_point táblának egy külső kulcsot kell tartalmaznia az activities táblára.
// Módosítsd a findActivityById() metódust, hogy betöltse a TrackPoint értékeket is!
//
//Írj rá tesztesetet!
//
//Szabályok a koordinátákra:
//
//Szélesség : +90 - -90
//Hosszúság : +180 - -180
//Amennyiben valamelyik pont nem felel meg a szabályoknak, vissza kell görgetni a tranzakciót, és kivételt kell dobni.