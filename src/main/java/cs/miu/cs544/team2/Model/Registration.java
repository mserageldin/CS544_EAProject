package cs.miu.cs544.team2.Model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "datetime")
    private LocalDate date;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="offerid")
    private CourseOffering offering;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="studentid")
    private Student student;

    public Registration(LocalDate date, CourseOffering offering, Student student) {
        this.date = date;
        this.offering = offering;
        this.student = student;
    }

    public Registration() {

    }
}
