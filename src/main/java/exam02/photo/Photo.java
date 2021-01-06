package exam02.photo;

public class Photo implements Qualified{

    private String Name;
    private Quality quality;

    public Photo(String name) {
        Name = name;
        quality = Quality.NO_STAR;
    }

    public Photo(String name, Quality quality) {
        Name = name;
        this.quality = quality;
    }

    @Override
    public Quality getQuality() {
        return quality;
    }

    @Override
    public void setQuality(Quality quality) {

        this.quality = quality;

    }

    public String getName() {
        return Name;
    }
}
