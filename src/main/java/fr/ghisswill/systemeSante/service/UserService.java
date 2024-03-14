package fr.ghisswill.systemeSante.service;

import fr.ghisswill.systemeSante.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    User create(User user);
    User getUserById(UUID id);
    List<User> getUsers();
    User update(User user);
    void deleteById(UUID id);
}
