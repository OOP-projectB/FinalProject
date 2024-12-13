package universitySystem;

import users.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UniversitySystem {
	private String name;
	
	public UniversitySystem(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void start() {
		while(true) {
			Database.accessDB();
			System.out.println("How do you want to login? Choose a number:\n1.Admin\n2.Student\n3.Teacher\n4.Manager\n5.TechSupporter\n6.Quit");
			int account;
			try {
				BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
				account = Integer.parseInt(input.readLine());
				if (account == 1) {
					System.out.println("Hello, admin!");
					//Admin.adminning().userMenu(input);
				} else if (account == 2) {
					System.out.println(" Write login and password of Student:");
					String loginAndPassword = input.readLine();
					String authentication = User.logIn(loginAndPassword);
					if(authentication == null) {
						System.out.println("Empty input");
						} else {
							StringTokenizer st = new StringTokenizer(authentication);
							Student s = Database.accessDB().findStudentByLogin(st.nextToken());
							if(!s.checkPassword(st.nextToken())) {
								System.out.println("Wrong password. Bye!");
								break;
							}
							//s.userMenu(input);
						}
				} else if (account == 3) {
					System.out.println(" Write login and password of Teacher:");
					String loginAndPassword = input.readLine();
					String authentication = User.logIn(loginAndPassword);
					if(authentication == null) {
						System.out.println("Empty input");
						} else {
						StringTokenizer st = new StringTokenizer(authentication);
						Teacher t = Database.accessDB().findTeacherByLogin(st.nextToken());
						if(!t.checkPassword(st.nextToken())) {
							System.out.println("Wrong password. Bye!");
							break;
						}
						//t.userMenu(input);
					}
				} else if (account == 4) {
						System.out.println("Hello! Write login and password of Manager:");
						String loginAndPassword = input.readLine();
						String authentication = User.logIn(loginAndPassword);
						if(authentication == null) {
							System.out.println("Empty input");
							} else {
							StringTokenizer st = new StringTokenizer(authentication);
							Manager m = Database.accessDB().findManagerbyLogin(st.nextToken());
							if(!m.checkPassword(st.nextToken())) {
								System.out.println("Wrong password. Bye!");
								break;
							}
							//m.userMenu(input);
						}
						
				} else if (account == 5) {
					System.out.println("Hello! Write login and password of TechSupporter:");
					String loginAndPassword = input.readLine();
					String authentication = User.logIn(loginAndPassword);
					if(authentication == null) {
						System.out.println("Empty input");
						} else {
						StringTokenizer st = new StringTokenizer(authentication);
						TechSupporter t = Database.accessDB().findTechSupporterbyLogin(st.nextToken());
						if(!t.checkPassword(st.nextToken())) {
							System.out.println("Wrong password. Bye!");
							break;
						}
						//t.userMenu(input);
					}
				}
				else if (account == 6) {
					System.out.print("See you next time!");
					Database.saveDatabase();
					break;
				}
			}
			catch(IOException ioe) {
				System.out.print("Error");
				ioe.printStackTrace();
				Database.saveDatabase();
				break;
			}
		}
			
		}

	
	public static void main(String[] args){
		UniversitySystem uniSystem = new UniversitySystem("Research-Oriented University");
		uniSystem.start();
	}
}
