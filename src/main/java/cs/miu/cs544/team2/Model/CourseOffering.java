package cs.miu.cs544.team2.Model;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    private List<Registration> registrations = new ArrayList<>();

    @Column
    private int capacity;

    @ManyToOne
    @JoinColumn(name = "facultyId")
    private Faculty faculty;

    @OneToMany
    @JoinColumn(name = "sessionId")
    private List<ClassSession> session = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "locationId")
    private Location location;



}
