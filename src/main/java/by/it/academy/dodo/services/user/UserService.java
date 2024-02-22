package by.it.academy.dodo.services.user;

import by.it.academy.dodo.dto.request.UserWorkerRequestDto;
import by.it.academy.dodo.dto.request.user.UserRequestDto;
import by.it.academy.dodo.dto.request.user.UserRequestPutDto;
import by.it.academy.dodo.entities.User;
import by.it.academy.dodo.exceptions.ClientInvalidDataException;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.UUID;

public interface UserService {
    /**
     * Creates a new user with associated worker data.
     *
     * @param userWorkerRequestDTO The DTO containing user and worker data.
     * @return {@code true} if the user is created successfully, {@code false} otherwise.
     * @throws DataIntegrityViolationException If there is a data integrity violation.
     * @throws ClientInvalidDataException      If the user or worker data is invalid.
     */
    boolean createUser(UserWorkerRequestDto userWorkerRequestDTO);
    /**
     * Saves the provided user to the repository.
     *
     * @param user The user to save.
     * @return {@code true} if the user is saved successfully, {@code false} otherwise.
     * @throws DataIntegrityViolationException If there is a data integrity violation.
     */
    boolean saveUser(User user);

    /**
     * Updates the user associated with the specified worker ID using the provided {@link UserRequestDto}.
     *
     * @param workerId          The ID of the associated worker.
     * @param userRequestPutDto The updated user data.
     * @return {@code true} if the user is updated successfully, {@code false} otherwise.
     */
    boolean updateUser(UUID workerId, UserRequestPutDto userRequestPutDto);

    /**
     * Deletes the user associated with the specified worker ID.
     *
     * @param workerId The ID of the associated worker.
     * @return {@code true} if the user is deleted successfully, {@code false} otherwise.
     */
    boolean deleteUser(UUID workerId);
}
