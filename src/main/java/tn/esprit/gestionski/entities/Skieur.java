package tn.esprit.gestionski.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Skieur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numSkieur;

    private String nomS;
    private String prenomS;
    private LocalDate dateNaissance;
    private String ville;
    @OneToOne
    private Abonnement abonnement;
    @JsonIgnore

    @ManyToMany
    private Set<Piste> pistes;
    @JsonIgnore

    @OneToMany(mappedBy = "skieur",cascade = CascadeType.ALL)//one to many mapped by fili 3Ndou cardinalié a9al

    private Set<Inscription> inscripions;

}
