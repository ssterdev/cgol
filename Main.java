import java.util.Scanner;

public class Main{

	public static void main(String[] args){
		
		Grid test = new Grid(10,10);
		test.add(3,2);
		test.add(4,2);
		test.add(5,2);

		test.add(7,6);
		test.add(7,7);
		test.add(7,8);



	
		int counter = 1;
	while (counter != 4){
		Scanner reader = new Scanner(System.in);
		
		counter = Integer.parseInt(reader.nextLine());
		switch (counter) {
			case 1: 
				System.out.println("Meniu: ");
				break;

			case 2:
				test.print();
				break;
			case 3: 
				test.checkAlive();
				test.checkDead();
				test.print();
				break;
			case 4: 
				break;

			case 5: 
				test.updateGrid();
				break;
			case 6: 
				test.printTemp();
				break;
			case 7: 
				test.print();
				break;
			default:

				System.out.println("incepem: ");
				
				break;
		}


	}
	}

} 
