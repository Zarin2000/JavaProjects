package Assignment_object;

public class DanceSchool {
    
    // Attributes
    private int schoolID;
    private String schoolName;
    private String location;
    private int numberOfStudents;
    private String danceStyle;
    private static int totalSchools = 0;
    
    // Constructors
    public DanceSchool() {
        totalSchools++;
    }
    
    public DanceSchool(int schoolID) {
        this();
        this.schoolID = schoolID;
    }
    
    public DanceSchool(int schoolID, String schoolName) {
        this(schoolID);
        this.schoolName = schoolName;
    }
    
    public DanceSchool(int schoolID, String schoolName, String location) {
        this(schoolID, schoolName);
        this.location = location;
    }
    
    public DanceSchool(int schoolID, String schoolName, String location, int numberOfStudents) {
        this(schoolID, schoolName, location);
        this.numberOfStudents = numberOfStudents;
    }
    
    // Getter and Setter Methods
    public int getSchoolID() {
        return schoolID;
    }

    public void setSchoolID(int schoolID) {
        this.schoolID = schoolID;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public String getDanceStyle() {
        return danceStyle;
    }

    public void setDanceStyle(String danceStyle) {
        this.danceStyle = danceStyle;
    }
    
    // Static Function
    public static int getTotalSchools() {
        return totalSchools;
    }
    
    // Non-Static Function
    public void enrollStudent(int numberOfStudents) {
        this.numberOfStudents += numberOfStudents;
        System.out.println(numberOfStudents + " students enrolled in " + schoolName);
    }
    
    // Main Method
    public static void main(String[] args) {
        DanceSchool school1 = new DanceSchool(1, "Fantastic Feet");
        school1.setLocation("Aftabnagar");
        school1.setDanceStyle("Hip Hop");
        school1.setNumberOfStudents(50);
        
        DanceSchool school2 = new DanceSchool(2, "Twinkle Toes", "Banasree");
        school2.setDanceStyle("Ballet");
        school2.setNumberOfStudents(30);
        
        DanceSchool school3 = new DanceSchool(3, "Rhythm Rascals", "Rampura", 40);
        school3.setDanceStyle("Belly Dance");
        
        DanceSchool school4 = new DanceSchool(4, "Nrittangon");
        school4.setLocation("Badda");
        school4.setDanceStyle("Salsa");
        school4.setNumberOfStudents(45);
        
        DanceSchool school5 = new DanceSchool(5, "Graceful Gestures", "Gulshan", 35);
        school5.setDanceStyle("Contemporary");
        
        System.out.println("Total Schools: " + DanceSchool.getTotalSchools());
        
        school1.enrollStudent(10);
        school2.enrollStudent(5);
        school3.enrollStudent(8);
        school4.enrollStudent(12);
        school5.enrollStudent(7);
        
        System.out.println("School 1 Students: " + school1.getNumberOfStudents());
        System.out.println("School 2 Location: " + school2.getLocation());
        System.out.println("School 3 Style: " + school3.getDanceStyle());
        System.out.println("School 4 Name: " + school4.getSchoolName());
        System.out.println("School 5 ID: " + school5.getSchoolID());
    }
}
