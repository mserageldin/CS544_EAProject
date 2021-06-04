package cs.miu.cs544.team2.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
public class ClassSession {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@ManyToOne(fetch=FetchType.EAGER)
	private Timeslot timeslot;

	@Column(nullable=false)
    private LocalDate date;
	
	@ManyToOne
	@JoinColumn(name = "offerId")
	private CourseOffering offering;
	
}
