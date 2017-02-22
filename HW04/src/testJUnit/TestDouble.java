package testJUnit;
import edu.miracosta.cs113.DoubleLinkedList;

public class TestDouble {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DoubleLinkedList<String> waitList = new DoubleLinkedList<String>();
		
		waitList.addFirst("Matthew");
		waitList.addFirst("john");
		waitList.addFirst("michael");
		System.out.println(waitList);
		
		waitList.addLast("Alex");
		System.out.println(waitList);
		
		waitList.add(2, "kensie");
		System.out.println(waitList);
		
		waitList.remove(2);
		System.out.println(waitList);
		

	}

}
