package cs.miu.cs544.team2.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.LinkedList;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "firstname", columnDefinition = "nvarchar(50)")
    private String firstName;

    @Column(name = "lastname", columnDefinition = "nvarchar(50)")
    private String lastName;

    @Column(name = "emailaddress", columnDefinition = "nvarchar(50)")
    private String emailAddress;
    @ManyToMany
    @JoinTable(name = "Person_Role",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles = new LinkedList<>();

}
