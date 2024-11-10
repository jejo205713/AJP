
//1,2,3
import java.util.*; class 
Classroom   
{  
private List<Map<String, String>> attendanceList;     
public Classroom()  
{  
    attendanceList = new ArrayList<>();  
}  

public void addStudent(String studentName)   
{  
Map<String, String> studentRecord = new HashMap<>();         
studentRecord.put("Name", studentName);         
studentRecord.put("Status", "Absent");          
attendanceList.add(studentRecord);  
System.out.println("Student " + studentName + " has been added.");  
}  
  
    public void markAttendance(String studentName, String status)   
    {  
        boolean studentFound = false;  
        for (Map<String, String> studentRecord : attendanceList)   
        {  
            if (studentRecord.get("Name").equals(studentName))   
            {  
                studentRecord.put("Status", status);                 
studentFound = true;  
                System.out.println("Attendance for " + studentName + " has been marked as " + status + ".");  
                break;  
            }  
        }  
        if (!studentFound){  
            System.out.println("Student " + studentName + " not found.");  
        }  
    }  
  
    public void displayAttendance()   
    {  
        System.out.println("\nAttendance Records:");         for 
(Map<String, String> studentRecord : attendanceList) {  
            System.out.println("Student: " + studentRecord.get("Name") + " | Status: " + studentRecord.get("Status"));  
        }  
    }  
  
    public static void main(String[] args)   
   {  
        Scanner scanner = new Scanner(System.in);  
        Classroom classroom = new Classroom();  
  
        String studentName = scanner.nextLine();         
       classroom.addStudent(studentName);  
  
        studentName = scanner.nextLine();         
        String status = scanner.nextLine();  
        classroom.markAttendance(studentName, status);  
  
        classroom.displayAttendance();  
    }  
}  

______
