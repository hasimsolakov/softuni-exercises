import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    private Integer id;

    private String username;

    private String fullname;

    private String passwordHash;

    private Set<Post> posts = new HashSet<>(0);

    private Set<Comment> comments = new HashSet<>(0);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    @Column(nullable = false)
    public String getUsername(){
        return this.username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getFullname(){
        return this.fullname;
    }

    public void setFullname(String fullName){
        this.fullname = fullName;
    }

    @Column(nullable = false)
    public String getPasswordHash(){
        return this.passwordHash;
    }

    public void setPasswordHash(String passwordHash){
        this.passwordHash = passwordHash;
    }

    @OneToMany(mappedBy = "author")
    public Set<Post> getPosts(){
        return this.posts;
    }

    public void setPosts(Set<Post> posts){
        this.posts = posts;
    }

    @OneToMany(mappedBy = "author")
    public Set<Comment> getComments(){
        return this.comments;
    }

    public void setComments(Set<Comment> comments){
        this.comments = comments;
    }
}
