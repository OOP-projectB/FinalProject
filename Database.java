package universitySystem;

import java.io.*;
import java.util.Vector;
import users.*;
import services.*;
import researchPack.*;

public class Database implements Serializable {
    private static Database db; 
    protected String name = "KBTU_database";
    protected Vector<Student> students;
    protected Vector<Teacher> teachers;
    protected Vector<Manager> managers;
    protected Vector<TechSupporter> techSupporters;
    protected Vector<News> news;
    protected Vector<Course> courses;
    protected Vector<TechOrder> techOrders;
    protected Vector<ResearchJournal> researchJournals;
    protected Vector<Query> queries;
    private static final long serialVersionUID = 1L; 

    static {
    	System.out.println("Hello!");
        if (new File("database.ser").exists()) { 
            try {
                db = readDatabase();
            } catch (Exception e) {
                System.out.println("Error reading database: " + e.getMessage());
            }
        } else {
            db = new Database();
        }
    }

    private Database() { }

    private static Database readDatabase() {
        try (FileInputStream fis = new FileInputStream("database.ser");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (Database) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Database file not found");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        } catch (IOException e) {
            System.out.println("IO error occurred");
        }
        return null;
    }

    public static synchronized Database accessDB() {
        if (db == null) {
            db = new Database(); 
        }
        return db;
    }

    public static void saveDatabase() {
        try (FileOutputStream fos = new FileOutputStream("database.ser");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(db);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("IO error occurred");
        }
    }
    
    public void viewAllCourses() {
    	System.out.println("Courses:");
		for(Course c : courses) {
			System.out.println(c);
		}
	}
	
	public void viewAllRequests() {
		System.out.println("Queries:");
		for(Query r : queries) {
			System.out.println(r);
		}
	}
	public void viewAllStudents() {
		System.out.println("Students:");
		for(Student s: students) {
			System.out.println(s);
		}
	}
	public void viewAllTeachers() {
		System.out.println("Teachers:");
		for(Teacher t: teachers) {
			System.out.println(t);
		}
	}
	public void viewAllManagers() {
		System.out.println("Managers:");
		for(Manager m: managers) {
			System.out.println(m);
		}
	}
	
	public void viewAllTechSupporters() {
		System.out.println("TechSupporters:");
		for(TechSupporter t : techSupporters) {
			System.out.println(t);
		}
	}
	
	public void viewAllNews() {
		System.out.println("News: ");
		for(News n: news) {
			System.out.println(n);
		}
	}
	
	public void viewResearchJournals() {
		System.out.println("Research Journals:");
		for(ResearchJournal r : researchJournals) {
			System.out.println(r);
		}
	}
	
	public Student findStudentByLogin(String userLogin) {
		for(Student s : students) {
			if(s.getLogin().equals(userLogin)) {
				return s;
			}
		}
		return null;
	}
	
	public Teacher findTeacherByLogin(String teacherLogin) {
		for(Teacher t : teachers) {
			if(t.getLogin().equalsIgnoreCase(teacherLogin)) {
				return t;
			}
		}
		return null;
	}
	
	public Manager findManagerbyLogin(String userLogin) {
		for(Manager m: managers) {
			if(m.getLogin().equals(userLogin)) {
				return m;
			}
		}
		return null;
	}
	
	public TechSupporter findTechSupporterbyLogin(String userLogin) {
		for(TechSupporter m: techSupporters) {
			if(m.getLogin().equals(userLogin)) {
				return m;
			}
		}
		return null;
	}
	
	public Vector<Student> getStudents(){
		return students;
	}
	
	public Vector<Teacher> getTeachers(){
		return teachers;
	}
	
	public Vector<Manager> getManagers(){
		return managers;
	}
	
	public Vector<TechSupporter> getTechSupporters(){
		return techSupporters;
	}
}
