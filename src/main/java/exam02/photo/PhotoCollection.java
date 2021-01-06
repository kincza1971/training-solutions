package exam02.photo;

import java.util.ArrayList;
import java.util.List;

public class PhotoCollection {

    private List<Photo> photos = new ArrayList<>();


    public List<Photo> getPhotos() {
        return photos;
    }

    public void addPhoto(String name, String... names) {
        photos.add(new Photo(name));
        for (String aName : names) {
            photos.add(new Photo(aName));
        }
    }

    public void starPhoto(String name, Quality quality) {
        for (Photo photo : photos) {
            if (photo.getName().equals(name)) {
                photo.setQuality(quality);
                return;
            }
        }
        throw new PhotoNotFoundException("Photo not found");
    }

    public int numberOfStars() {
        int sumStar = 0;
        for (Photo photo : photos) {
            if(photo.getQuality() != null) {
                sumStar += photo.getQuality().getStars();
            }
        }
        return sumStar;
    }

}
