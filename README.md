# CS544_EAproject-Team Two

Rest API that will automate the process of manage student attendance online. 

### Requirements

This system has a database of users and roles and based on roles, users will be able to perform actions. 
<br />

* This system supports four roles: Student,Faculty,Personnal,Administrative. 
* A “Person” is a user of the system, we need to keep track of person ID, first and last name, email 
address and obviously username, password and set of roles. Person can have multiple roles. 
* A Faculty can :<br />
  -Show Students Attendance History<br />
  -Show My Last 6 Courses<br />
* A student can Register To:<br />
   -Course-Show Course Offering<br />
   -Show Registered Courses<br />
   -Take Attendance-Show Attendance Record<br />
* A Administrator can :<br />
  -Add Course<br />
  -Drop Course<br />
  -Add Course Offering<br />
  -Drop Course Offering<br />
  -Register Student<br />
  -Drop Student<br />
  -Register Faculty<br />
  -Drop Faculty<br />
  -Register Personnel<br />
  -Drop Personnel<br />
  -Register Administrator<br />
  -Drop Administrator<br />
  -Add Role<br />
  -Drop Role<br />
  -Add Location<br />
  -Drop Location<br />
  -Add Timeslot<br />
* A Personnel can :<br />
  -Show All Time Attendance Record Of A Student<br />
  -Update Student Attendance Record<br />
  



### Class Diagram
<p>
    <img src="https://github.com/mserageldin/CS544_EAProject/blob/main/src/main/resources/diagram.png" alt="Logo" width="500" height="400">
</p>

### Technologies

This section should list any major frameworks used to built the project.
* Spring boot
* JPA & Hibernate
* Spring Security
* Spring Validation
* MySql
* lombok
* JMS & ActiveMQ
* Restful API
* Deployment(heroku)
* JWS
