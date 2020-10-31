package co.edu.javeriana.tais2020.laurel.users.services;

import co.edu.javeriana.tais2020.laurel.users.entities.User;

import java.util.List;

public interface UsersService {
    List<User> getAllUsers();
    User getUser(Long id);
    User createUser(User user);
    User updateUser(User user);
    boolean deleteUser(Long id);
}
