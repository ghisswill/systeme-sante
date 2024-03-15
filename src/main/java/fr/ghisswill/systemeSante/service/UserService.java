package fr.ghisswill.systemeSante.service;

import fr.ghisswill.systemeSante.model.User;
import fr.ghisswill.systemeSante.repository.dto.UserDTO;

import java.util.List;
import java.util.UUID;

public interface UserService {

    UserDTO create(UserDTO user);
    User getUserById(UUID id);
    List<User> getUsers();
    User update(User user);
    void deleteById(UUID id);
}
