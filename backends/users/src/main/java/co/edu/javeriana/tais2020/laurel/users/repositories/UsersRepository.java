package co.edu.javeriana.tais2020.laurel.users.repositories;

import co.edu.javeriana.tais2020.laurel.users.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, Long> {
}
