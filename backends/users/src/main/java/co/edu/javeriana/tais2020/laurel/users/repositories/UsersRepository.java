package co.edu.javeriana.tais2020.laurel.users.repositories;

import co.edu.javeriana.tais2020.laurel.users.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends MongoRepository<User, Long> {
}
