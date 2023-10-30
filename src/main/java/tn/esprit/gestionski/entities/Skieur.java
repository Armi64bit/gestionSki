package tn.esprit.gestionski.entities;

import jakarta.persistence.*;
import lombok.*;

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
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private String ville;
    @OneToOne
    private Abonnement abonnement;
    @ManyToMany (mappedBy = "skieurs")
    private Set<Piste> pistes;
    @OneToMany(mappedBy = "skieur")//one to many mapped by fili 3Ndou cardinalié a9al
    private Set<Inscription> inscripions;

}
