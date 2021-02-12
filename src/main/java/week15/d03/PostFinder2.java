package week15.d03;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
public class PostFinder2 {

    private List<Post> posts;

    public PostFinder2(List<Post> posts) {
    this.posts=posts;
    }

    public List<Post> findPosts(String user){
        return posts.stream()
                       .filter(post->post.getPublishedAt().isBefore(LocalDate.now()))
                       .filter(post->post.getTitle()!=null)
                       .filter(post->post.getContent()!=null)
                       .filter(post->post.getDeletedAt()==null||post.getDeletedAt().isAfter(LocalDate.now()))
                       .filter(post->LocalDate.now().isBefore(post.getPublishedAt()) || post.getOwner().equals(user))
                       .collect(Collectors.toList());
    }
}