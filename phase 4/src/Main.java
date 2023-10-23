public class Main {
    public static void main(String[] args) {
        // Create an instance of the DBMS with a specified max level for the Skip List
        DBMS dbms = new DBMS(4); // You can choose an appropriate max level

        // Create Student objects
        Student student1 = new Student("S00001", "student 1", 50.0);
        Student student2 = new Student("S00002", "student 2", 55.5);
        Student student3 = new Student("S00003", "student 3", 58.0);
        Student student4 = new Student("S00004", "student 4", 58.5);

        // Insert student records into the DBMS
        dbms.insertRecord(student1.getStudentID(), student1);
        dbms.insertRecord(student2.getStudentID(), student2);
        dbms.insertRecord(student3.getStudentID(), student3);
        dbms.insertRecord(student4.getStudentID(), student4);

        // Retrieve a student record
        Student retrievedStudent = dbms.getRecord("S00003");
        if (retrievedStudent != null) {
            System.out.println("Retrieved Student: " + retrievedStudent);
        }

        // Get the record count
        int recordCount = dbms.getRecordCount();
        System.out.println("Record Count: " + recordCount);

        // Delete a student record
        dbms.deleteRecord("S003");

        // Get the updated record count
        recordCount = dbms.getRecordCount();
        System.out.println("Updated Record Count: " + recordCount);
    }
}
