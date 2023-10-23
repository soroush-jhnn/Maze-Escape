public class DBMS {
    private SkipList<String, Student> skipList;

    public DBMS(int maxLevel) {
        this.skipList = new SkipList<>(maxLevel);
    }

    public void insertRecord(String studentID, Student student) {
        skipList.insert(studentID, student);
    }

    public Student getRecord(String studentID) {
        return skipList.search(studentID);
    }

    public void deleteRecord(String studentID) {
        skipList.delete(studentID);
    }

    public int getRecordCount() {
        return skipList.size();
    }


}
