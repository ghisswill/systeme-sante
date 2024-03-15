package fr.ghisswill.systemeSante.model;

import fr.ghisswill.systemeSante.enums.RoleType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String lastName;
    private String firstName;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private RoleType role;
    private String  username;
    private String phone;

}
