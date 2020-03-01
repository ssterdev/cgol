public class Grid {
	private int [][] grid;
	private int [][] tempGrid = new int[10][10];

	public Grid (int x, int y){
		this.grid = new int[x][y];
	}

	public void updateGrid (){
		this.grid = tempGrid;
	}
	
	public void clearScreen(){
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public void printTemp (){
		System.out.println("---------------------------------");
		for (int [] a: this.tempGrid){
			for (int i : a){
				System.out.print(i+"  ");
			}
		System.out.println("\n");
		}
	}

	public void print (){
		System.out.println("---------------------------------");
		for (int [] a: this.grid){
			for (int i : a) {
				System.out.print(i+"  ");
			}

		System.out.println("\n");
		}
	}

	public void addToTempGrid (int x,int y, int z){
		tempGrid[x][y]=z;
	}

	public void add (int x, int y){
		this.grid[x][y] = 1;
	}
	
	public void remove (int x, int y){
		this.grid[x][y] = 0;
	}
	
	public void checkAlive (){
		for (int i=0; i<grid.length; i++){
			for (int j=0; j<grid[0].length; j++){
				if (grid[i][j] == 1){				
				int n = checkNeighbor(i,j,1);
				System.out.print(n);
				if (parseLiveCell(n)){
					addToTempGrid(i,j,1);
				}
				else {
					addToTempGrid(i,j,0);
				}
			
				}
			}
		}
	}

	public void checkDead (){
		System.out.println("");
		for (int i=0; i<grid.length; i++){
			for (int j=0; j<grid[0].length; j++){
				if (grid[i][j] == 0){				
				int n = checkNeighbor(i,j,0);
				System.out.print(n);
				if (parseDeadCell(n)){
					System.out.print("test");
					addToTempGrid(i,j,1);
				}
				}
			}
		}

	}

	public int checkNeighbor (int x, int y, int aliveOrDead){
		int neighbors = aliveOrDead;

		if (aliveOrDead == 1){
			neighbors = -1;
		}
		else if (aliveOrDead == 0){ 
			neighbors = 0;
		}
		
		for (int origX = checkMin(x); origX <= checkMax(x); origX++){
			for (int origY = checkMin(y); origY <= checkMax(y); origY++){
					if (grid[origX][origY] == 1){
						neighbors++;
					}
			}
		}
		return neighbors;
	}

	public int checkMin (int x){
		if (x == 0){
			return x;
		}
		
		return x - 1;
	}

	public int checkMax (int x){
		if (x == 9){
			return x;
		}

		return x + 1;
	}

	public boolean parseLiveCell (int x){
		if (x == 2 || x == 3){
			return true;
		}
		else 
			return false;
	}

	public boolean parseDeadCell (int x){
		if (x == 3){
			return true;
		}
		else 
			return false;
	}

}


