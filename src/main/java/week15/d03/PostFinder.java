package week15.d03;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class PostFinder {

    private List<Post> posts;
    private String user;

    public PostFinder(List<Post> posts) {
        this.posts = posts;
    }

    private boolean filterPost(Post post) {
        LocalDate now = LocalDate.now();
        return  (post.getPublishedAt().isBefore(now) || post.getOwner().equals(user))
                && (post.getContent()!=null && !post.getContent().isBlank())
                && (post.getTitle() !=null && !post.getTitle().isBlank())
                && (post.getDeletedAt()==null || post.getDeletedAt().isAfter(now));
    }


    public List<Post> findPost(String user) {
        this.user =user;
        return posts.stream()
                .filter(this::filterPost)
                .collect(Collectors.toList());
    }
}

//Implementáljunk a PostFinder osztályban egy public List<Post> findPosts(String user) metódust az alábbi módon:
//- A Post publishedAt dátuma korábbi kell, hogy legyen, mint a LocalDate.now()
//- Ha a Post publishedAt dátuma későbbi, mint a LocalDate.now(), akkor csak azokat a Post-okat adjuk vissza,
// melyek owner-e megegyezik a megadott user-rel.
//- A content és a title nem lehet üres
//- A deletedAt értéke null kell, hogy legyen, vagy későbbi, mint a LocalDate.now().
//- Használjunk stream-eket az implementációhoz!
//Tároljunk egy List<Post> objektumot a PostFinder osztályban, melyet konstruktor paraméterként kap meg és ezt használjuk!