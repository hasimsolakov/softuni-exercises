import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment {

    private Integer id;

    private String text;

    private Post post;

    private User author;

    private String authorName;

    private LocalDateTime date;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    @Column(nullable = false)
    public String getText(){
        return this.text;
    }

    public void setText(String text){
        this.text = text;
    }

    @ManyToOne
    @JoinColumn(name = "post_id")
    public Post getPost(){
        return this.post;
    }

    public void setPost(Post post){
        this.post = post;
    }

    @ManyToOne
    @JoinColumn(name = "author_id")
    public User getAuthor(){
        return this.author;
    }

    public void setAuthor(User author){
        this.author = author;
    }

    @Column(name = "author_name")
    public String getAuthorName(){
        return this.authorName;
    }

    public void setAuthorName(String authorName){
        this.authorName = authorName;
    }

    @Column(nullable = false)
    public LocalDateTime getDate(){
        return this.date;
    }

    public void setDate(LocalDateTime date){
        this.date = date;
    }
}
