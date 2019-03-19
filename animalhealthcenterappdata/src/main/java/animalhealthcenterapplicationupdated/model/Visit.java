package animalhealthcenterapplicationupdated.model;

import java.time.LocalDate;

public class Visit extends BaseEntity {
    private LocalDate date;
    private String description;
    private Animal animal;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
