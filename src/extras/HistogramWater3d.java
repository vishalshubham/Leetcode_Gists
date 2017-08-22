// https://leetcode.com/submissions/detail/114909976/
import java.util.*;

class Cell{
    int i;
    int j;
    int height;
    
    public Cell(int i, int j, int height){
        this.i = i;
        this.j = j;
        this.height = height;
    }
}

public class HistogramWater3d {
	public int trapRainWater(int[][] heightMap) {
        if(heightMap.length<3 || heightMap[0].length<3) return 0;
        
        boolean[][] visited = new boolean[heightMap.length][heightMap[0].length];
        
        PriorityQueue<Cell> minQueue = new PriorityQueue<Cell>(10, new Comparator<Cell>(){
            public int compare(Cell c1, Cell c2){
                return c1.height - c2.height;
            }
        });
        
        int m = heightMap.length;
        int n = heightMap[0].length;
        
        for(int i=0; i<n; i++){
            addCell(0, i, heightMap[0][i], visited, minQueue);
            addCell(m-1, i, heightMap[m-1][i], visited, minQueue);
        }
        
        for(int i=0; i<m; i++){
            addCell(i, 0, heightMap[i][0], visited, minQueue);
            addCell(i, n-1, heightMap[i][n-1], visited, minQueue);
        }
        int max = Integer.MIN_VALUE;
        int total = 0;
        
        while(!minQueue.isEmpty()){
            Cell cell = minQueue.remove();
            max = Math.max(max, cell.height);
            int i = cell.i;
            int j = cell.j;
            // Left
            if(j>0 && visited[i][j-1]==false){
                addCell(i, j-1, heightMap[i][j-1], visited, minQueue);
                if(max>heightMap[i][j-1]) total += Math.abs(max-heightMap[i][j-1]);
            }
            // Right
            if(j<heightMap[0].length-1 && visited[i][j+1]==false){
                addCell(i, j+1, heightMap[i][j+1], visited, minQueue);
                if(max>heightMap[i][j+1]) total += Math.abs(max-heightMap[i][j+1]);
            }
            // Top
            if(i>0 && visited[i-1][j]==false){
                addCell(i-1, j, heightMap[i-1][j], visited, minQueue);
                if(max>heightMap[i-1][j]) total += Math.abs(max-heightMap[i-1][j]);
            }
            // Bottom
            if(i<heightMap.length-1 && visited[i+1][j]==false){
                addCell(i+1, j, heightMap[i+1][j], visited, minQueue);
                if(max>heightMap[i+1][j]) total += Math.abs(max-heightMap[i+1][j]);
            }
        }
        return total;
    }
    
    public void addCell(int i, int j, int height, boolean[][] visited, PriorityQueue<Cell> minQueue){
        visited[i][j] = true;
        minQueue.add(new Cell(i, j, height));
    }
}
