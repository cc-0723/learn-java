import java.util.*;

public class Printer {
    public int[] clockwisePrint(int[][] mat, int n, int m) {
        int[] a = new int[n*m];
        int index = 0;
        int topX = 0, topY = 0, lowX = n - 1, lowY = m - 1;
        while(topX <= lowX && topY <= lowY){
            if(topX == lowX){    //只剩下一行时
                for(int i = topY;  i <= lowY;  i++)
                    a[index++] = mat[topX][i];
                return a;
            }
            if(topY == lowY){  //只剩下一列时
                for(int i = topX;  i <= lowX;  i++)
                    a[index++] = mat[i][topY];
                return a;
            }
            for(int i = topY;  i < lowY; i++)
                a[index++] = mat[topX][i];
            for(int i = topX; i < lowX;  i++)
                a[index++] = mat[i][lowY];
            for(int i = lowY; i > topY;  i--)
                a[index++] = mat[lowX][i];
            for(int i = lowX; i > topX; i--)
                a[index++] = mat[i][topY];
            topX++; topY++; lowX--; lowY--;
        }
        return a;
    }
}