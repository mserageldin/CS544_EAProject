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

}

