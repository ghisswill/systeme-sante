package fr.ghisswill.systemeSante.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String lastName;
    private String firstName;
    private Date birthDay;
}
