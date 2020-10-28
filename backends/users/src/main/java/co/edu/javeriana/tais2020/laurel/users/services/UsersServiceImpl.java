package co.edu.javeriana.tais2020.laurel.users.services;

import co.edu.javeriana.tais2020.laurel.users.entities.User;
import co.edu.javeriana.tais2020.laurel.users.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository repository;

    @Override
    public List<User> getAllUsers() {
        List<User> result = new ArrayList<>();
        repository.findAll().forEach(result::add);
        return result;
    }

    public User getUser(Long id) {
        return findUser(id);
    }

    public User createUser(User user) {
        return repository.save(user);
    }

    public User updateUser(User user) {
        User userFound = findUser(user.getId());
        if (userFound == null) return null;

        userFound.setDocumentNumber(user.getDocumentNumber());
        userFound.setDocumentType(user.getDocumentType());
        userFound.setEmail(user.getEmail());
        userFound.setLastName(user.getLastName());
        userFound.setName(user.getName());

        return repository.save(userFound);
    }

    public boolean deleteUser(Long id) {
        User userFound = findUser(id);
        if (userFound == null) return false;

        repository.delete(userFound);
        return true;
    }

    private User findUser(Long id) {
        Optional<User> userOptional = repository.findById(id);
        if (userOptional.isEmpty()) return null;

        return userOptional.get();
    }
}
