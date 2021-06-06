package cs.miu.cs544.team2.Model;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Student extends Person {

    @Column(name="personid", columnDefinition = "char(11)")
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
    private List<Registration> registrations;

}
