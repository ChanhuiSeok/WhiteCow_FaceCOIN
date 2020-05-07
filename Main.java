//import java.util.Scanner;

public class Main 
{
	static boolean searched = false;
	static DBManager dbManager;
	static String[] userdata;
	static String pwdata;
	static String idfilename = "id.txt";
	static String pwfilename = "password.txt";
	
	public static void main(String[] args)
	{
		prepare_DB();
		
		if (dbManager.select_with_condition_user_info(userdata[0], userdata[1], userdata[2], pwdata))
		{
			System.out.println("Successfully searched !");
			searched = true;
		}
		else 
		{
			System.out.println("search failed !");
			searched = false;
		}
		
		/*Scanner s = new Scanner(System.in);
		
		while (true)
		{
			String user_name = null;
			String user_birthday = null;
			String user_id = null;
			String user_pw = null;
			String input = null;
			System.out.println("********** DBMS Prototype Program **********");
			System.out.print("1. Select  2. Insert  3. Delete  4. Update  : ");
			input = s.nextLine();
			switch (input)
			{
				case "1":
					System.out.print("1. Select All  2. Select with condition  : ");
					input = s.nextLine();
					switch (input)
					{
						case "1": dbManager.selectAll_user_info();
							break;
						case "2":
							System.out.print("Input user_name : ");
							user_name = s.nextLine();
							System.out.print("Input user birthday : ");
							user_birthday = s.nextLine();
							System.out.print("Input user id : ");
							user_id = s.nextLine();
							System.out.print("Input user pw : ");
							user_pw = s.nextLine();
							dbManager.select_with_condition_user_info(user_name, user_birthday, user_id, user_pw);
							break;
						default: System.err.println("System : Wrong Input, " + input);
							break;
					}
					break;
				case "2":
					System.out.print("Input user_name : ");
					user_name = s.nextLine();
					System.out.print("Input user birthday : ");
					user_birthday = s.nextLine();
					System.out.print("Input user id : ");
					user_id = s.nextLine();
					System.out.print("Input user pw : ");
					user_pw = s.nextLine();
					dbManager.insert_user_info(user_name, user_birthday, user_id, user_pw);
					break;
				case "3":
					System.out.print("1. Delete All  2. Delete with condition  : ");
					input = s.nextLine();
					switch (input)
					{
						case "1": dbManager.delete_all_user_info();
							break;
						case "2":
							System.out.print("Input user_name : ");
							user_name = s.nextLine();
							System.out.print("Input user birthday : ");
							user_birthday = s.nextLine();
							System.out.print("Input user id : ");
							user_id = s.nextLine();
							System.out.print("Input user pw : ");
							user_pw = s.nextLine();
							dbManager.delete_user_info(user_name, user_birthday, user_id, user_pw);
							break;
						default: System.err.println("System : Wrong Input, " + input);
							break;
					}
					break;
				case "4":
					System.out.print("Input user_name : ");
					user_name = s.nextLine();
					System.out.print("Input user birthday : ");
					user_birthday = s.nextLine();
					System.out.print("Input user id : ");
					user_id = s.nextLine();
					System.out.print("Input user previous pw : ");
					user_pw = s.nextLine();
					System.out.print("Input user new pw : ");
					String set_value = s.nextLine();
					dbManager.update_pw_user_info(set_value, user_name, user_birthday, user_id, user_pw);
					break;
				default: System.err.println("System : Wrong Input, " + input);
					break;
			}
		}*/
	}
	
	public static void prepare_DB()
	{
		String rawString = null;
		dbManager = new DBManager();
		
		if ((rawString = dbManager.loadData(idfilename)) == null)
		{
			System.err.println(idfilename + "파일을 읽는 도중 오류가 발생했습니다.");
			return;
		}
		
		userdata = rawString.split("_");
		
		if ((pwdata = dbManager.loadData(pwfilename)) == null)
		{
			System.err.println(pwfilename + "파일을 읽는 도중 오류가 발생했습니다.");	
			return;
		}
	}
}
