package cs.miu.cs544.team2.model;
import java.time.LocalTime;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "Timeslot")
public class Timeslot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private LocalTime startTime;

    @Column(nullable = false)
    private LocalTime endTime;

}
