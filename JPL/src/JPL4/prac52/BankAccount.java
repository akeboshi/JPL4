package JPL4.prac52;

import java.awt.List;
import java.util.ArrayList;

public class BankAccount {
	private long number;
	private long balance;
	private Action lastAct;
	private History history = new History();
	
	public class Action {
		private String act;
		private long amount;
		Action(String act, long amount){
			this.act = act;
			this.amount = amount;
		}
		@Override
		public String toString() {
			return number + ": " + act + " " +amount;
		}
	}
	public void deposit(long amount){
		balance += amount;
		lastAct = new Action("deposit", amount);
		history.addHistory(lastAct);
	}
	
	public void withdraw(long amount){
		balance -= amount;
		lastAct = new Action("withdraw", amount);
		history.addHistory(lastAct);
	}
	
	public void transfar (BankAccount other, long amount) {
		other.withdraw(amount);
		deposit(amount);
		lastAct = this.new Action("transfer", amount);
		other.lastAct = other.new Action("transfer", amount);
		history.addHistory(lastAct);
	}
	
	public History history(){
		return history;
	}
	
	 public static class History {
           ArrayList<Action> actionHistory = new ArrayList<Action>();
           int index = 0;
           
           public void addHistory(Action action){
        	   if (actionHistory.size() < 10){
        		   actionHistory.add(action);
	           } else {
	        	   actionHistory.remove(0);
	        	   actionHistory.add(action);
	           }
           }
           public void view(){
        	   for (int i = 0; i < 10; i++) {
				System.out.println(i + ": " + "(act)" + actionHistory.get(i).act + "(amount)"+actionHistory.get(i));
			}
           }
           
           public Action next(){
        	   if( index < actionHistory.size()){
        		   return actionHistory.get(index++);
        	   }else{
        		   return null;
        	   }
           }
	 }
}