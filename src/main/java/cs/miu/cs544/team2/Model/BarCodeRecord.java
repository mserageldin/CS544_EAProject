package cs.miu.cs544.team2.Model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class BarCodeRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "char(13)")
    private String barcode;

    @OneToOne
    @JoinColumn(name = "timeslotId")
    private Timeslot timeslot;

    private LocalDateTime timeStamp;

    @ManyToOne
    @JoinColumn(name = "barcodeId")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student student;

    private String period;
    private String courseCode;
    private String facultyName;

    public BarCodeRecord(String barcode, Timeslot timeslot, LocalDateTime timeStamp, Location location, Student student, String period, String courseCode, String facultyName) {
        this.barcode = barcode;
        this.timeslot = timeslot;
        this.timeStamp = timeStamp;
        this.location = location;
        this.student = student;
        this.period = period;
        this.courseCode = courseCode;
        this.facultyName = facultyName;
    }

    public BarCodeRecord() {

    }
}

