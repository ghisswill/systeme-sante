package fr.ghisswill.systemeSante.repository;

import fr.ghisswill.systemeSante.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {
}
