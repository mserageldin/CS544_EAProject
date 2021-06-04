package cs.miu.cs544.team2.model;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class Registration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(columnDefinition = "datetime")
	private LocalDate date;
	
	@ManyToOne
	@JoinColumn(name="offerid")
	private CourseOffering offering;
	
	@ManyToOne
	@JoinColumn(name="studentid")
	private Student student;

}
