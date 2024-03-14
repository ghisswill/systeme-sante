package fr.ghisswill.systemeSante.service.impl;

import fr.ghisswill.systemeSante.model.User;
import fr.ghisswill.systemeSante.repository.UserRepository;
import fr.ghisswill.systemeSante.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("User not found with id " + id));
    }

    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        for (User user : userRepository.findAll()) {
            users.add(user);
        }
        return users;
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(UUID id) {
        if (userRepository.findById(id).isEmpty()){
            throw new RuntimeException("User not found with id " + id);
        }
        userRepository.deleteById(id);
    }
}
