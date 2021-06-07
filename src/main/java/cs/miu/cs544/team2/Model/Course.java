package cs.miu.cs544.team2.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String code;

    @Column(length = 3)
    private String abbreviation;

    @Column(length = 255)
    private String name;

    @Column(length = 4000)
    private String description;

    public Course(String code, String abbreviation, String name, String description) {
        this.code = code;
        this.abbreviation = abbreviation;
        this.name = name;
        this.description = description;
    }

    public Course() {

    }
}

