package cs.miu.cs544.team2.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.Data;

@Data
@Entity
public class CourseOffering {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @Column(columnDefinition = "nvarchar(50)")
    private String period;

    @Column(nullable = false)
    private LocalDate beginDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @OneToMany
    @JoinColumn(name = "offerid")
    @Fetch(FetchMode.SUBSELECT)
    private List<Registration> registrations;

    @Column
    private int capacity;

    @ManyToOne
    @JoinColumn(name = "facultyId")
    private Faculty faculty;

    @ManyToOne
    @JoinColumn(name = "sessionId")
    private ClassSession session;

    @ManyToOne
    @JoinColumn(name = "locationId")
    private Location location;

}
