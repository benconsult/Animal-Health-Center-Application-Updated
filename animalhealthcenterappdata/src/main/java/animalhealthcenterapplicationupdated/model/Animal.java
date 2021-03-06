package animalhealthcenterapplicationupdated.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "animals")
public class Animal extends BaseEntity {

 @Column(name = "name")
 private String name;

 @ManyToOne
 @JoinColumn(name = "type_id")
 private AnimalType animalType;

 @ManyToOne
 @JoinColumn(name = "owner_id")
 private Owner owner;

 @Column(name = "birth_date")
 private LocalDate birthDate;

 @OneToMany(cascade = CascadeType.ALL, mappedBy = "animal")
 private Set<Visit> visits = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Set<Visit> getVisits() {
        return visits;
    }

    public void setVisits(Set<Visit> visits) {
        this.visits = visits;
    }
}
