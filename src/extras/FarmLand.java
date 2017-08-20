import java.util.*;

public class FarmLand {
	
	public int numberOfHours(char[][] mat) {
		int eSpaces = 0;
		int hours = 0;
		for(int i=0; i<mat.length; i++) {
			for(int j=0; j<mat[0].length; j++) {
				if(mat[i][j] == 'E') eSpaces++;
			}
		}
		
		while(eSpaces>0) {
			hours++;
			boolean[][] visited = new boolean[mat.length][mat[0].length];
			
			for(int i=0; i<mat.length; i++) {
				for(int j=0; j<mat[0].length; j++) {
					if(mat[i][j] == 'E') visited[i][j] = true;
				}
			}
			
			for(int i=0; i<mat.length; i++) {
				for(int j=0; j<mat[0].length; j++) {
					if(!visited[i][j] && mat[i][j] == 'W') {
						// Top
						if(i!=0 && mat[i-1][j] == 'E') {
							eSpaces--;
							mat[i-1][j] = 'W';
						}
						// Bottom
						if(i!=mat.length-1 && mat[i+1][j] == 'E') {
							eSpaces--;
							mat[i+1][j] = 'W';
						}
						// Left
						if(j!=0 && mat[i][j-1] == 'E') {
							eSpaces--;
							mat[i][j-1] = 'W';
						}
						// Right
						if(j!=mat[0].length-1 && mat[i][j+1] == 'E') {
							eSpaces--;
							mat[i][j+1] = 'W';
						}
					}
				}
			}
		}
		return hours;
	}
	
	public static void main(String[] args) {
		FarmLand fl = new FarmLand();
		char[][] arr = {{'E','E','E'},{'E','#','E'},{'E','W','E'}};
		System.out.println(fl.numberOfHours(arr));
	}
}
