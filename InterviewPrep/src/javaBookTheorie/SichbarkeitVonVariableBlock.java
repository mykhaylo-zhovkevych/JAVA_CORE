package javaBookTheorie;

public class SichbarkeitVonVariableBlock {

	
	public void zugriff() {
		int aussen = 7;
		
		if (aussen == 7)
		{
			int innen = 8;
			System.out.print("Zugriff aud die Variable");
			System.out.println(" des äusseren Blocks: " + aussen);
			System.out.print("Zugriff aud die Variable");
			System.out.println(" des inneren Blocks: " + innen);
		}
	}
	
	
	
	public static void main(String [] args) {
		
		SichbarkeitVonVariableBlock ref = new SichbarkeitVonVariableBlock();
		ref.zugriff();
	}
	
}
