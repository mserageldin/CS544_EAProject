package cs.miu.cs544.team2.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Student extends Person {
	
	@Column(name="personid", columnDefinition = "char(11)")
	private String studentId;
	
	@Column(name="visastatus", columnDefinition = "nvarchar(50)")
	private String visaStatus;
	
	@Column(columnDefinition = "nvarchar(50)")
	private String status;
	
	@Column(columnDefinition = "varchar(50)")
	private String track;
	
	@Column(name="entry", columnDefinition = "datetime")
	private LocalDate entryDate;
	
	@Column(columnDefinition = "char(13)")
	private String barcode;
	
}
