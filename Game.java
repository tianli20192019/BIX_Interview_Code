package test;

import java.util.Scanner;

public class Game {
	
	private String[][] grid;
	
	private final String FIRST_PERSION_WIN = "First Person Win";
	private final String SECOND_PERSION_WIN = "Secodn Person Win";
	private final String NO_PERSION_WIN = "No Persion Win";
	private final String CONTINUE = "continue";
	private final String X = "X";
	private final String O = "O";
	public Game() {
		this.grid = new String[3][3];
	}
	
	public void start() {
		String inputValue = X;
		while(CONTINUE.equals(checkResult())) {
			input(inputValue);
			if(X.equals(inputValue)) {
				inputValue = O;
			}else if(O.equals(inputValue)) {
				inputValue = X;
			}
		}
	}
	
	public String checkResult() {

		int emptyValue = 0;
		int xDiaXNumber_1 = 0;
		int oDiaNumber_1 = 0;
		int xDiaXNumber_2 = 0;
		int oDiaNumber_2 = 0;
		for(int i = 0; i < grid.length; i++) {	
			int xRowNumber = 0;
			int oRowNumber = 0;
			int xColumnNumber = 0;
			int oColumnNumber = 0;
			for(int j = 0; j< grid.length; j++) {
				//statistic row number
				if(grid[i][j] == X) {
					xRowNumber++;
					if(xRowNumber == 3) {
						System.out.println(FIRST_PERSION_WIN);
						return FIRST_PERSION_WIN;
					}
				}else if(grid[i][j] == O) {
					oRowNumber++;
					if(oRowNumber == 3) {
						System.out.println(SECOND_PERSION_WIN);
						return SECOND_PERSION_WIN;
					}
				}else {
					emptyValue ++;
				}
				//statistic column number
				if(grid[j][i] == X) {
					xColumnNumber++;
					if(xColumnNumber == 3) {
						System.out.println(FIRST_PERSION_WIN);
						return FIRST_PERSION_WIN;
					}
				}else if(grid[j][i] == O) {
					oColumnNumber++;
					if(oColumnNumber == 3) {
						System.out.println(SECOND_PERSION_WIN);
						return SECOND_PERSION_WIN;
					}
				}
				//statistic diag number
				if( i == j) {
					if(grid[i][j] == X) {
						xDiaXNumber_1++;
						if(xDiaXNumber_1 == 3) {
							System.out.println(FIRST_PERSION_WIN);
							return FIRST_PERSION_WIN;
						}
					}else if(grid[i][j] == O) {
						oDiaNumber_1++;
						if(oDiaNumber_1 == 3) {
							System.out.println(SECOND_PERSION_WIN);
							return SECOND_PERSION_WIN;
						}
					}
				}
				//statistic diag1 number
				if( i+j == 2) {
					if(grid[i][j] == X) {
						xDiaXNumber_2++;
						if(xDiaXNumber_2 == 3) {
							System.out.println(FIRST_PERSION_WIN);
							return FIRST_PERSION_WIN;
						}
					}else if(grid[i][j] == O) {
						oDiaNumber_2++;
						if(oDiaNumber_2 == 3) {
							System.out.println(SECOND_PERSION_WIN);
							return SECOND_PERSION_WIN;
						}
					}
				}
			}
		}
		if(emptyValue == 0) {
			System.out.println(NO_PERSION_WIN);
			return NO_PERSION_WIN;
		}else {
			return CONTINUE;
		}
		
	}
	
	private void input(String value) {
	        Scanner in = new Scanner(System.in);
	        boolean locationHasValue = false;
	        while(!locationHasValue) {
		        System.out.println("Please input your location,it should be like 1,2 and 2,1 and each number should between 1-3");
		        String location = in.nextLine();
		        try {
			        String[] ll = location.split(",");
			        int row = Integer.valueOf(ll[0]);
			        int col = Integer.valueOf(ll[1]);
			        if(grid[row-1][col-1] == null){
			        	locationHasValue = true;
				        grid[row-1][col-1] = value;
				        System.out.println("You put "+value +" at "+ll[0]+","+ll[1]);
				        printGrid();
			        }else {
			        	locationHasValue = false;
			        	System.out.println("location "+ll[0]+","+ll[1]+" has value");
			        }
		        }catch(Exception e) {
		        	e.printStackTrace();
		        }

	        }
	}
	
	private void printGrid() {
		for(int i = 0; i < grid.length; i++) {	
			System.out.print("[");
			for(int j = 0; j< grid.length; j++) {
				if( j == grid.length-1) {
					System.out.print(grid[i][j]+"]");
				}else {
					System.out.print(grid[i][j]+",");
				}
			}
			System.out.println("");
		}
	}

}
