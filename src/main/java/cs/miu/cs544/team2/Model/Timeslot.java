package cs.miu.cs544.team2.Model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalTime;

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

    public Timeslot(String code, String title, LocalTime startTime, LocalTime endTime) {
        this.code = code;
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
