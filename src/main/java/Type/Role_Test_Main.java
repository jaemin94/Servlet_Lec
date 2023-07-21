package Type;

public class Role_Test_Main {

	public static void main(String[] args) {
		
		System.out.println(Role.Role_Admin);
		System.out.println(Role.Role_User);
		System.out.println(Role.Role_Member);

		System.out.println(Role.Role_User.ordinal());
		System.out.println(Role.Role_Admin.ordinal());
		System.out.println(Role.Role_Member.ordinal());
		
		System.out.println(Role.Role_User.ordinal() <  Role.Role_Admin.ordinal());
		
	}

}
