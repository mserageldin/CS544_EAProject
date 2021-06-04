package cs.miu.cs544.team2.model;

import lombok.Data;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
public class BarCodeRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "char(13)")
    private String barcode;

    private LocalDateTime timeStamp;

    @ManyToOne
    @JoinColumn(name = "barcodeId")
    private Location location;
}
