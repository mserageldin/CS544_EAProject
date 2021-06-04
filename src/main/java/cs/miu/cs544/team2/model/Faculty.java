package cs.miu.cs544.team2.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Faculty extends Person {
	
	@Column(name="title", columnDefinition = "nvarchar(50)")
	private String title;

	@OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<CourseOffering> offering = new ArrayList<>();

}
