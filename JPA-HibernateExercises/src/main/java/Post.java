import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "posts")
public class Post {

    private Integer id;

    private String title;

    private String content;

    private User author;

    private LocalDateTime date;

    private Set<Comment> comments = new HashSet<>(0);

    private Set<Tag> tags = new HashSet<>(0);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    @Column(nullable = false)
    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    @ManyToOne
    public User getAuthor(){
        return this.author;
    }

    public void setAuthor(User author){
        this.author = author;
    }

    @Column(nullable = false)
    public String getContent(){
        return this.content;
    }

    public void setContent(String content){
        this.content = content;
    }

    @Column(nullable = false)
    public LocalDateTime getDate(){
        return this.date;
    }

    public void setDate(LocalDateTime date){
        this.date = date;
    }

    @OneToMany(mappedBy = "post")
    public Set<Comment> getComments(){
        return this.comments;
    }

    public void setComments(Set<Comment> comments){
        this.comments = comments;
    }

    @ManyToMany()
    @JoinTable(
            name = "posts_tags",
            joinColumns = {@JoinColumn(name="post_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "tags_id", referencedColumnName = "id")})
    public Set<Tag> getTags(){
        return this.tags;
    }

    public void setTags(Set<Tag> tags){
        this.tags = tags;
    }
}
