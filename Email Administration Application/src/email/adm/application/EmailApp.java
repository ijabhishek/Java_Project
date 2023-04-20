package email.adm.application;

public class EmailApp {

	public static void main(String[] args) {
		Email em1 = new Email("Mike" , "Jorder");
		em1.setMailboxCapacity(300);
		
		System.out.println(em1.showInfo());
	}

}
