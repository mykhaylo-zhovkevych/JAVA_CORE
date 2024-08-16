package digitalOcean;



public class Overriding {

	public static void main(String[] args) {
		
		Slave slave = new Slave();
		
		slave.work();
	}
	
	
}


class King {
	public void work() {
		System.out.println("no");
	}
}


class Slave extends King {
	//@Override
	public void work() {
		System.out.println("work!!!");
	}
}



