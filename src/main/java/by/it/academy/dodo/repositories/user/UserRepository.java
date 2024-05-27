package by.it.academy.dodo.repositories.user;

import by.it.academy.dodo.entities.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for performing CRUD operations on {@link User} entities.
 */
public interface UserRepository extends MongoRepository<User, ObjectId>{
}
