package tn.esprit.gestionski.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Inscription implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numInscription;
    private int numSeamiane;
    @JsonIgnore
    @ManyToOne
    private Skieur skieur;
    @JsonIgnore
    @ManyToOne
    private Cours cours;

}
