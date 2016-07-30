import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAExercises");
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        try {
            listAllPosts(em, cb);
            listAllUsers(em, cb);
            orderUsersByTwoParameters(em, cb);
            getAuthors(em, cb);
            getAuthorsWithTitle(em, cb);
            getSpecificAuthor(em, cb);
            createNewPost(em);
            editPost(em);
            deletePost(em);
        }
        finally {
            em.close();
            emf.close();
        }

    }

    public static void deletePost(EntityManager em){
        Post post = em.find(Post.class, 5);

        em.getTransaction().begin();

        post.getComments().clear();
        post.getTags().clear();
        em.remove(post);
        em.getTransaction().commit();
    }

    public static void editPost(EntityManager em){
        Post post = em.find(Post.class, 3);

        post.setContent("Random Content should be replaced");

        em.getTransaction().begin();
        em.persist(post);
        em.getTransaction().commit();
    }

    public static void createNewPost(EntityManager em) {
        User user = em.find(User.class, 2);

        LocalDateTime date = LocalDateTime.now();

        Post post = new Post();

        post.setAuthor(user);
        post.setTitle("Random Title");
        post.setContent("Random Content");
        post.setDate(date);

        em.getTransaction().begin();
        em.persist(post);
        em.getTransaction().commit();
    }

    public static void getSpecificAuthor(EntityManager em, CriteriaBuilder cb){
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> userRoot = query.from(User.class);

        query.where(
                cb.equal(userRoot.join("posts").get("id"), 4))
                .select(userRoot);

        List<User> users = em.createQuery(query).getResultList();

        for (User user : users) {
            System.out.println("Username: " + user.getUsername());
            System.out.println("Name: " + user.getFullname());
        }
    }

    public  static void getAuthorsWithTitle(EntityManager em, CriteriaBuilder cb){
        CriteriaQuery<Post> query = cb.createQuery(Post.class);
        Root<Post> postRoot = query.from(Post.class);

        query.select(postRoot);

        List<Post> posts = em.createQuery(query).getResultList();

        for (Post post : posts) {
            System.out.println("Author: " + post.getAuthor().getUsername());
            System.out.println("Title: " + post.getTitle());
        }
    }

    public static void getAuthors(EntityManager em, CriteriaBuilder cb){
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> userRoot = query.from(User.class);

        query.where(
                cb.gt(
                        cb.size(
                                userRoot.get("posts")), 0))
                .select(userRoot);

        List<User> users = em.createQuery(query).getResultList();

        for (User user : users) {
            System.out.println("Username: " + user.getUsername());
            System.out.println("Name: " + user.getFullname());
            System.out.println("Count: " + user.getPosts().size());
        }
    }

    public static void orderUsersByTwoParameters(EntityManager em, CriteriaBuilder cb){
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> userRoot = query.from(User.class);

        query.select(userRoot);
        query.orderBy(cb.desc(userRoot.get("username")), cb.desc(userRoot.get("fullname")));

        List<User> users = em.createQuery(query).getResultList();

        for (User user : users) {
            System.out.println("Username: " + user.getUsername());
            System.out.println("Name: " + user.getFullname());
        }
    }

    public static void listAllUsers(EntityManager em, CriteriaBuilder cb){
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> userRoot = query.from(User.class);

        query.select(userRoot);
        query.orderBy(cb.asc(userRoot.get("username")));

        List<User> users = em.createQuery(query).getResultList();

        for (User user : users) {
            System.out.println("Username " + user.getUsername());
            System.out.println("Name: " + user.getFullname());
        }
    }

    public static void listAllPosts(EntityManager em, CriteriaBuilder cb){
        CriteriaQuery<Post>  query = cb.createQuery(Post.class);
        Root<Post> postRoot = query.from(Post.class);

        query.select(postRoot);
        List<Post> posts = em.createQuery(query).getResultList();

        for (Post post : posts) {
            System.out.println("Title: " + post.getTitle());
            System.out.println("Author ID: " + post.getAuthor().getId());
        }
    }
}
