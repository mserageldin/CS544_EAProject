package cs.miu.cs544.team2.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "Location")
public class Location {

    @Id
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String building;

    @Column(nullable = false)
    private String roomNumber;


    @Column(nullable = false)
    private Integer capacity;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<BarCodeRecord> barcodes = new ArrayList<>();

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CourseOffering> offerings = new ArrayList<>();

    public Location(String name, String building, String roomNumber, Integer capacity) {
        this.name = name;
        this.building = building;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
    }

    public Location() {

    }
}
