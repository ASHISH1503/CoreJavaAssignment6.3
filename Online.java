import java.util.logging.Level;
import java.util.logging.Logger;


public class Online extends Thread implements Runnable{

	private Person P;
	public Online(Person P) {
	    this.P = P;	    
	}

	public static void main(String[] args) {
	
		Online obj1 = new Online(new Person("P1"));
	    obj1.start();
	   
	    Online obj2 = new Online(new Person("P2"));
	    obj2.start();
	}

	public void run() {
	    for (int i = 0; i < 2; i++) {
	        try {
	          
				Account acc = Account.getAccount(P);
	            acc.withdraw(200);
	            try {
	                Thread.sleep(200);
	            } catch (InterruptedException ex) {
	                Logger.getLogger(Online.class.getName()).log(Level.SEVERE, null, ex);
	            }
	            if (acc.getBal() < 0) {
	                System.out.println("account is overdrawn!");
	            }
	            acc.deposit(200);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    System.out.println("Final Acc balance is Rs." + Account.getBal());
	}
	
}
