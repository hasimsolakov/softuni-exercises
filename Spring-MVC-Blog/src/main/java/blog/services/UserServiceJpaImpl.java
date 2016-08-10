package blog.services;

import blog.models.User;
import blog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class UserServiceJpaImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return this.userRepository.findOne(id);
    }

    @Override
    public User create(User user) {
        // TODO: encrypt the password here
        return this.userRepository.save(user);
    }

    @Override
    public User edit(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        this.userRepository.delete(id);
    }


    @Override
    public boolean authenticate(String username, String password) {
        throw new UnsupportedOperationException("Operation not implemented");
    }

    @Override
    public User login(String username, String password) {
        throw new UnsupportedOperationException("Operation not implemented");
    }

    @Override
    public User register(String username, String password, String fullName) {
        throw new UnsupportedOperationException("Operation not implemented");
    }

    @Override
    public void setPassword(String username, String newPassword) {
        throw new UnsupportedOperationException("Operation not implemented");
    }
}
