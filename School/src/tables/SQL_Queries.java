package tables;

public class SQL_Queries {
	public static String Data_Path = "C:\\\\Users\\\\Mabel\\\\workspace\\\\Java_Learning\\\\School\\\\src\\\\data\\";

	public static String createCourse = "create table course(P_Id int, course varchar(50), grade varchar(25))";
	public static String createStudent = "create table student(P_Id int, first_name varchar(50), last_name varchar(50), GPA varchar(10), phone_no varchar(50))";
	public static String populateCouse = "Load Data LOCAL infile '" + Data_Path + "\\coursestaken.data' into table course FIELDS TERMINATED BY ';' ";
	public static String populateStudent = "Load Data LOCAL infile '" + Data_Path + "\\student.data' into table student FIELDS TERMINATED BY ';' ";
	public static String primaryKeyCourse = "ALTER TABLE course ADD id INT NOT NULL AUTO_INCREMENT PRIMARY KEY";
	public static String primaryKeyStudent = "ALTER TABLE student ADD id INT NOT NULL AUTO_INCREMENT PRIMARY KEY";
	public static String calculateAvgGPA =
										"create table reportCard as" +
										"(select student.P_Id, student.first_name, student.last_name, student.phone_no, gpaCalc.GPA from student " +
										"left outer join " +
										"(select P_Id, sum(case grade " +
                     					"when 'A' then 4 " +
                     					"when 'B' then 3 " +
                     					"when 'C' then 2 " +
                     					"when 'D' then 1 " +
                     					"else 0 end" +
                     					")/count(*) gpa " +
                     					"from learning.course " +
                     					"where P_Id in ('1','2','3') group by P_Id) as gpaCalc " +
                     					"on student.P_Id = gpaCalc.P_Id);";
	
	public static String GPAScoreCol = "ALTER TABLE course ADD GPA_Score int;";
	public static String GPAScore =	"update course " +
									"set GPA_Score = (case "   +
									"when grade='A' then 4 "  +
									"when grade='B' then 3 "  +
									"when grade='C' then 2 "  +
									"when grade='D' then 1 "  +
									"else GPA_Score end);";
											
	
}
