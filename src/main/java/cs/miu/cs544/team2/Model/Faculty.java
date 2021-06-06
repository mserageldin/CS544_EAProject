package cs.miu.cs544.team2.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Faculty extends Person {

    @Column(name="title", columnDefinition = "nvarchar(50)")
    private String title;

    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OrderColumn(name = "sequence")
    private List<CourseOffering> offering = new ArrayList<>();

}
