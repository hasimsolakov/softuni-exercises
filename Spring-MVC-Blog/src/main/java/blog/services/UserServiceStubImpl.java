package blog.services;

import blog.models.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceStubImpl implements UserService {
    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public User edit(User user) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public boolean authenticate(String username, String password) {
        return Objects.equals(username, password);
    }

    @Override
    public User login(String username, String password) {
        return null;
    }

    @Override
    public User register(String username, String password, String fullNmame) {
        return null;
    }

    @Override
    public void setPassword(String username, String newPassword) {

    }
}
