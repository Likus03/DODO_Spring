package by.it.academy.dodo.services.user;

import by.it.academy.dodo.dto.request.UserWorkerRequestDto;
import by.it.academy.dodo.dto.request.user.UserRequestDto;
import by.it.academy.dodo.dto.request.user.UserRequestPutDto;
import by.it.academy.dodo.entities.User;
import by.it.academy.dodo.exceptions.ClientInvalidDataException;
import org.bson.types.ObjectId;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.UUID;

public interface UserService {
    /**
     * Creates a new user with associated worker data.
     *
     * @param userWorkerRequestDTO The DTO containing user and worker data.
     */
    void createUser(UserWorkerRequestDto userWorkerRequestDTO);
    /**
     * Updates the user associated with the specified worker ID using the provided {@link UserRequestDto}.
     *
     * @param workerId          The ID of the associated worker.
     * @param userRequestPutDto The updated user data.
     * @return {@code true} if the user is updated successfully, {@code false} otherwise.
     */
    boolean updateUser(ObjectId workerId, UserRequestPutDto userRequestPutDto);

    /**
     * Deletes the user associated with the specified worker ID.
     *
     * @param workerId The ID of the associated worker.
     */
    void deleteUser(ObjectId workerId);
}
