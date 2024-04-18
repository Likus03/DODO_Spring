package by.it.academy.dodo.repositories.client;

import by.it.academy.dodo.entities.Client;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repository interface for performing CRUD operations on {@link Client} entities.
 */
public interface ClientRepository extends MongoRepository<Client, ObjectId>{
}
