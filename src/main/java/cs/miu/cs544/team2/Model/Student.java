package cs.miu.cs544.team2.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
public class Student extends Person {

    @Column(name="student_id", columnDefinition = "char(11)")
    private String studentId;

    @Column(name="visastatus", columnDefinition = "nvarchar(50)")
    private String visaStatus;

    @Column(columnDefinition = "nvarchar(50)")
    private String status;

    @Column(columnDefinition = "varchar(50)")
    private String track;

    @Column(name="entry", columnDefinition = "datetime")
    private LocalDate entryDate;

    @Column(columnDefinition = "char(14)")
    private String barcode;

    @OneToMany
    @JoinColumn(name = "studentid")
    @Fetch(FetchMode.SUBSELECT)
    private List<Registration> registrations= new ArrayList<>();

    public Student(String firstName, String lastName, String emailAddress, String studentId, String visaStatus, String status, String track, LocalDate entryDate, String barcode) {
        super(firstName, lastName, emailAddress);
        this.studentId = studentId;
        this.visaStatus = visaStatus;
        this.status = status;
        this.track = track;
        this.entryDate = entryDate;
        this.barcode = barcode;
    }

    public Student() {
        super();
    }

    public void addRegistration(Registration registration){
        registrations.add(registration);
    }
}
