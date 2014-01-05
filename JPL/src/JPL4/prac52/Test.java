package JPL4.prac52;

class Test{
	public static void main(String[] args) {
		BankAccount account = new BankAccount();
		
		for(int i=0;i<6 ; i++)account.deposit(100);
		for(int i=0;i<10 ;i++)System.out.println(account.history().next());
		for(int i=0;i<5 ; i++)account.deposit(100);
		account.withdraw(200);
		account.withdraw(330);
		account.deposit(50);
		
		account.history().view();
		account.history().index =0;
		for(int i=0;i<11 ; i++)
			System.out.println(account.history().next());
	}
}