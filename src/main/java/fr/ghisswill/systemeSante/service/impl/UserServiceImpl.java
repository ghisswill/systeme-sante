package fr.ghisswill.systemeSante.service.impl;

import fr.ghisswill.systemeSante.enums.RoleType;
import fr.ghisswill.systemeSante.model.User;
import fr.ghisswill.systemeSante.repository.UserRepository;
import fr.ghisswill.systemeSante.repository.dto.UserDTO;
import fr.ghisswill.systemeSante.service.UserService;
import fr.ghisswill.systemeSante.service.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDTO create(UserDTO dto) {
        if(userRepository.findByEmail(dto.getEmail()).isEmpty()) {
            User user = dto.getRole().equals("secretaire") ? UserMapper.INSTANCE.toUserEntity(dto, RoleType.SECRETARY) :
                    UserMapper.INSTANCE.toUserEntity(dto, RoleType.DOCTOR);

            return UserMapper.INSTANCE.toUserDTO(userRepository.save(user));
        }
        throw new RuntimeException("L'email est deja utilisé");
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
