import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Main {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog-db");
    static EntityManager em = emf.createEntityManager();
    public static void main(String[] args) {

        try {
            createUser();
            createUserWithPosts();
            listAlPosts();
            getPostsByUsername();
            editExistingUser();
            delteExistingUser();
            executeNativeSQL();
        }
        finally {
            em.close();
            emf.close();
        }
    }

    private static void createUser(){
        User newUser = new User();
        newUser.setUsername("Pesho");
        em.getTransaction().begin();
        em.persist(newUser);
        em.getTransaction().commit();
        System.out.println("Created new user #" + newUser.getId());
    }

    private static void executeNativeSQL(){
        LocalDateTime startDate = LocalDateTime.parse("2016-05-19T12:00:00");
        LocalDateTime endDate = LocalDateTime.now();

        Query postsQuery = em.createNativeQuery(
                "Select id, title, date, body, author_id from posts " +
                        "where CONVERT (date, DATE )" +
                        "BETWEEN :startDate AND :endDate", Post.class)
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate);

        List<Post> posts = postsQuery.getResultList();

        for (Post post : posts) {
            System.out.println(post);
        }

    }

    private static void delteExistingUser(){
        User firstUser = em.find(User.class, 1L);

        em.getTransaction().begin();
        for (Post post : firstUser.getPosts()) {
            em.remove(post);
        }

        em.getTransaction().commit();

        System.out.println("Deleted existing user #" + firstUser.getId());
    }

    private static void editExistingUser(){
        User firstUser = em.find(User.class, 1L);

        firstUser.setPasswordHash("" + new Date().getTime());
        firstUser.setFullName(firstUser.getFullName() + "2");

        em.getTransaction().begin();
        em.persist(firstUser);
        em.getTransaction().commit();

        System.out.println("Edited existing user #" + firstUser.getId());
    }

    private static void getPostsByUsername(){
        Query peshoPosts = em.createQuery(
                "From Post p JOIN fetch p.author where p.author.username like concat(:username, '%') ")
                .setParameter("username", "Pesho");

        List<Post> posts = peshoPosts.getResultList();

        for (Post post : posts) {
            System.out.println(post);
        }
    }

    private static void listAlPosts(){
        Query allPostsQuerySlow = em.createQuery(
                "SELECT p from Post p"
        );
        Query allPostsQuery = em.createQuery(
                "select p From Post p JOIN Fetch p.author"
        );

        List<Post> posts = allPostsQuery.getResultList();

        for (Post post : posts) {
            System.out.println(post);
        }
    }

    private static void createUserWithPosts(){
        em.getTransaction().begin();

        User newUser = new User();
        newUser.setUsername("Pesho" + new Date().getTime());
        newUser.setPasswordHash("pass12345");
        newUser.setFullName("P.Petrov");
        em.persist(newUser);
        System.out.println("Created new user #" + newUser.getId());

        for (int i = 0; i <= 10; i++) {
            Post newPost = new Post();
            newPost.setTitle("Post Title " + i);
            newPost.setBody("<p>Body" + i + "</p>");
            newPost.setAuthor(newUser);
            em.persist(newPost);
            System.out.println("Created new post #" + newPost.getId());
        }

        em.getTransaction().commit();
    }
}
