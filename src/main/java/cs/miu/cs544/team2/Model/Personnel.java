package cs.miu.cs544.team2.Model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
public class Personnel extends Person {

    @Column(name="title", columnDefinition = "nvarchar(50)")
    private String title;

    public Personnel(String firstName, String lastName, String emailAddress, String title) {
        super(firstName, lastName, emailAddress);
        this.title = title;
    }
}
