# CS544_EAproject-Team Two

Rest API that will automate the process of manage student attendance online. 

### Requirements

This system has a database of users and roles and based on roles, users will be able to perform actions. 
<br />

* This system supports four roles: Student,Faculty,Personnal,Administrative. 
* A “Person” is a user of the system, we need to keep track of person ID, first and last name, email 
address and obviously username, password and set of roles. Person can have multiple roles. 
* A Faculty can :
  -Show Students Attendance History
  -Show My Last 6 Courses
* A student can Register To:
   -Course-Show Course Offering
   -Show Registered Courses
   -Take Attendance-Show Attendance Record
* A Administrator can :
  -Add Course
  -Drop Course
  -Add Course Offering
  -Drop Course Offering
  -Register Student
  -Drop Student
  -Register Faculty
  -Drop Faculty
  -Register Personnel
  -Drop Personnel
  -Register Administrator
  -Drop Administrator
  -Add Role
  -Drop Role
  -Add Location
  -Drop Location
  -Add Timeslot
* A Personnel can :
  -Show All Time Attendance Record Of A Student
  -Update Student Attendance Record
  



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
