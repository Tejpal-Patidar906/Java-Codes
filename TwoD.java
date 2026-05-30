import java.util.Scanner;

public class TwoD {

    public static void printArr(int matrix[][]){
          for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
         }
    }
    public static boolean search2d(int matrix[][] , int key){
          for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == key){
                    System.out.println("Found at index ("+i+","+j+")");
                    return true;
                }
            }
         }
        System.out.println("Not found");
        return false;
    }

    public static void spiralMatrix(int matrix[][]){
         int startRow = 0;
         int endRow = matrix.length-1;
         int startCol = 0;
         int endCOl = matrix[0].length-1;
         while(startRow <= endRow && startCol <= endCOl){
             //top
             for(int j=startCol; j<=endCOl; j++){
                 System.out.print(matrix[startRow][j] + " ");
             }
             //right
             for(int i=startRow+1; i<=endRow; i++){
                 System.out.print(matrix[i][endCOl] + " ");
             }
             //bottom
             for(int j=endCOl-1; j>=startCol; j--){
                if(startRow == endRow){
                    break;
                }
                 System.out.print(matrix[endRow][j] + " ");
             }

             //left
             for(int i=endRow-1; i>=startRow+1; i--){
                if(startCol == endCOl){
                    break;
                }
                 System.out.print(matrix[i][startCol] + " ");
             }

             startRow++;
             startCol++;
             endCOl--;
             endRow--;
         }
         System.out.println();
    }

    public static int diagonalSum(int matrix[][]){
         int n = matrix.length;
         int sum = 0;
         for(int i=0; i<n; i++){
             sum += matrix[i][i];
             if(i != n-i-1){
                sum += matrix[i][n-i-1];
             } 
         }
         return sum;
    }

    public static boolean staircaseSearchtopright(int matrix[][] , int key){
         int row = 0 , col = matrix[0].length-1;
         while(row < matrix.length && col >= 0){
             if(matrix[row][col] == key){
                System.out.println("Found at (" + row + "," + col + ")");
                return true;
             }else if(matrix[row][col] > key){
                 col--;
             }else{
                row++;
             }
         }
         System.out.println("Not found!");
         return false;
    }

    public static boolean staircaseSearchbottomleft(int matrix[][] , int key){
         int row = matrix.length-1 , col = 0;
         while(row >= 0 && col < matrix[0].length){
             if(matrix[row][col] == key){
                System.out.println("Found at (" + row + "," + col + ")");
                return true;
             }else if(matrix[row][col] > key){
                 row--;
             }else{
                col++;
             }
         }
         System.out.println("Not found!");
         return false;
    }


    public static void main(String[] args){
         Scanner sc = new Scanner(System.in);
        int matrix[][] =  { {10,20,30,40},
                            {15,25,35,45},
                            {27,29,37,48},
                            {32,33,39,50}
                          };
        int key = 40;
        printArr(matrix);
        staircaseSearchbottomleft(matrix, key);
    }
}
