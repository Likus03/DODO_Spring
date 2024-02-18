package by.it.academy.dodo.repositories.user;

import java.util.UUID;

public interface UserRepositoryCustom {

    /**
     * Deletes a user with the specified ID.
     *
     * @param id The ID of the user to be deleted.
     * @return True if the user is deleted successfully, false otherwise.
     */
    boolean deleteUser(UUID id);

    /**
     * Updates a user with the specified ID.
     *
     * @param workerId       The ID of the user to be updated.
     * @param password The updated user object.
     * @return True if the user is updated successfully, false otherwise.
     */
    boolean updateUserPassword(UUID workerId, String password);
}
