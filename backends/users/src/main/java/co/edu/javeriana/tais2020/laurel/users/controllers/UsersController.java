package co.edu.javeriana.tais2020.laurel.users.controllers;

import co.edu.javeriana.tais2020.laurel.users.entities.User;
import co.edu.javeriana.tais2020.laurel.users.entities.Users;
import co.edu.javeriana.tais2020.laurel.users.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return usersService.getUser(id);
    }

    @GetMapping
    public ResponseEntity<Users> getUsers() {
        Users users = new Users();
        users.setUsers(usersService.getAllUsers());
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<User> createUser(User user) {
        User created = usersService.createUser(user);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        User updated = usersService.updateUser(user);

        if (updated != null) return ResponseEntity.ok(updated);

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        if (usersService.deleteUser(id)) return ResponseEntity.accepted().build();

        return ResponseEntity.notFound().build();
    }

}
