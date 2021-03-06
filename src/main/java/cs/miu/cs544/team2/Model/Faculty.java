package cs.miu.cs544.team2.Model;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Getter
@RequiredArgsConstructor
public class Faculty extends Person {

    @Column(name="title", columnDefinition = "nvarchar(50)")
    private String title;

    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OrderColumn(name = "sequence")
    private List<CourseOffering> offering = new ArrayList<>();

    public Faculty(String firstName, String lastName, String emailAddress, String title) {
        super(firstName, lastName, emailAddress);
        this.title = title;
    }
}
