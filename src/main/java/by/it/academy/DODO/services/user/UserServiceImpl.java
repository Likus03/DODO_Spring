package by.it.academy.DODO.services.user;

import by.it.academy.DODO.entities.User;
import by.it.academy.DODO.repositories.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Transactional
    @Override
    public boolean create(User user) {
        try {
            userRepository.save(user);
        } catch (DataAccessException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Transactional
    @Override
    public boolean update(User user) {
        try {
            userRepository.save(user);
        } catch (DataAccessException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Transactional
    @Override
    public boolean delete(UUID id) {
        try {
            userRepository.deleteById(id);
        } catch (DataAccessException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Transactional(readOnly = true)
    @Override
    public User getLoggedUser(String login, String password) {
        return userRepository.findByLoginAndPassword(login, password).orElse(null);
    }
}
