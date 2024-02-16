package by.it.academy.dodo.repositories.user;

import java.util.UUID;

public interface UserRepositoryCustom {
    boolean deleteUser(UUID id);
    boolean updateUserPassword(UUID workerId, String password);
}
