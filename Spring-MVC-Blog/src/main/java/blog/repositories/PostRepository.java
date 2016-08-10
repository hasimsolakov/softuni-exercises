package blog.repositories;

import blog.models.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Hashim on 10.8.2016 г..
 */
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT p FROM Post p LEFT join fetch p.author order by p.date desc")
    List<Post> findLatest5Posts(Pageable pageable);
}

