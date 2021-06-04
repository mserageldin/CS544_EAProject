package cs.miu.cs544.team2.Model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class ClassSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch= FetchType.EAGER)
    private Timeslot timeslot;

    @Column(nullable=false)
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "offerId")
    private CourseOffering offering;

}
