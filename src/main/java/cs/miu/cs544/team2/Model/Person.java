package cs.miu.cs544.team2.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Data
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Component
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
	private String username;
	
	private String password;

    @Column(name = "firstname", columnDefinition = "nvarchar(50)")
    private String firstName;

    @Column(name = "lastname", columnDefinition = "nvarchar(50)")
    private String lastName;

    @Column(name = "emailaddress", columnDefinition = "nvarchar(50)")
    private String emailAddress;
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "Person_Role",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles = new LinkedList<>();

}
