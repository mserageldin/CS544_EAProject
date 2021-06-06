package cs.miu.cs544.team2.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Generator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="student_id", columnDefinition = "char(11)")
    private String studentId;

    @Column(columnDefinition = "char(14)")
    private String barCode;

    public Generator(String studentId, String barCode) {
        this.studentId = studentId;
        this.barCode = barCode;
    }

    public Generator() {

    }
}
