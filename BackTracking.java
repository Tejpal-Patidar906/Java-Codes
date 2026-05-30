public class BackTracking {
    public static void changeArr(int arr[] , int i , int val){
        //base case
        if(i == arr.length){
             printArr(arr);
             return;
        }
        //recursion
        arr[i] = val;
        changeArr(arr, i+1, val+1);
        arr[i] = arr[i]-2;
    }

    public static void strSubset(String str , String ans , int i){
         if(i == str.length()){
             if(ans.length() == 0){
                System.out.println("null");
             }else{
                System.out.println(ans);
             }
             return;
         }
         //recursion
         strSubset(str, ans+str.charAt(i), i+1);
         strSubset(str, ans, i+1);
    }

    public static void findPermution(String str , String ans){
         if(str.length() == 0){
             System.out.println(ans);
             return;
         }
         //recursion
         for(int i=0; i<str.length(); i++){
             char curr = str.charAt(i);
             String newStr = str.substring(0 , i) + str.substring(i+1);
             findPermution(newStr, ans+curr);
         }
    }

    public static boolean isSafe(char arr[][] , int row , int col){
          //vertical Up
          for(int i=row-1; i>=0; i--){
              if(arr[i][col] == 'Q'){
                return false;
              }
          }

          // left diagonal up
          for(int i=row-1, j=col-1; i>=0 && j>=0; i--,j--){
             if(arr[i][j] == 'Q'){
                 return false;
             }
          }

          //right up diagonal
          for(int i=row-1,j=col+1; i>=0 && j<arr.length; i--,j++){
             if(arr[i][j] == 'Q'){
                 return false;
             }
          }
          return true;
    }

    static int count = 0;

    public static boolean nQueens(char board[][] , int row){
         //base
         if(row == board.length){
            //  printBoard(board);
            count++;
            return true;
         }
         for(int j=0; j<board.length; j++){         // column
            if(isSafe(board , row, j)){
                board[row][j] = 'Q';
                if(nQueens(board, row+1)){   //function call)
                    return true;
                }
                board[row][j] = 'X';   //backtarcking step   !Most Important Step;
            } 
         }
         return false;
    }


    public static void printBoard(char arr[][]){
         System.out.println("-----------chess board ------------");
         for(int i=0; i<arr.length; i++){
             for(int j=0; j<arr.length; j++){
                 System.out.print(arr[i][j] + " ");
             }
             System.out.println();
         }
    }

    public static void printArr(int arr[]){
         for(int i=0; i<arr.length; i++){
             System.out.print(arr[i] + " ");
         }
    }

    public static int gridWays(int i , int j , int n , int m){
         if(i == n-1 && j == m-1){
            return 1;
         }else if(i == n || j == m){
             return 0;
         }
         int w1 = gridWays(i+1, j, n, m);
         int w2 = gridWays(i, j+1, n, m);
         return w1+w2;
    }
    public static int fact(int n){
        int f = 1;
        for(int i=n; i>=1; i--){
            f = f * i;
        }
        return f;
    }
    public static int optgridWays(int i , int j , int n , int m ){
         int nm1nmm1 = fact(n-1+m-1);
         int nm1 = fact(n-1);
         int mm1 = fact(m-1);
         return nm1nmm1 / (nm1 * mm1);
    }

    public static boolean sudokuSolver(int sudoku[][] , int row , int col){
          //base case
          if(row == 9){
              return true;
          }
          
          //recursion
          int nextRow = row , nextCol = col+1;
          if(col+1 == 9){
              nextRow = row+1;
              nextCol = 0;
          }

          if(sudoku[row][col] != 0){
              return sudokuSolver(sudoku, nextRow, nextCol);
          }

          for(int digit = 1; digit<=9;  digit++){
              if(isSaffe(sudoku , row , col , digit)){
                 sudoku[row][col] = digit;
                 if(sudokuSolver(sudoku, nextRow, nextCol)){
                    return true;
                 }
                 sudoku[row][col]=  0;
              }
          }
          return false;
    }

    public static boolean isSaffe(int sudoku[][] , int row , int col , int digit){
          // column
          for(int i=0; i<9; i++){
             if(sudoku[i][col] == digit){
                 return false;
             }
          }

          //row
          for(int j=0; j<9; j++){
              if(sudoku[row][j] == digit){
                  return false;
              }
          }

          //grid
          int sr = (row/3)*3;
          int sc = (col/3)*3;

          for(int i=sr; i<sr+3; i++){
              for(int j=sc; j<sc+3; j++){
                 if(sudoku[i][j] == digit){
                     return false;
                 }
              }
          }
          return true;
    }

    public static void printBoardsudoku(int arr[][]){
         System.out.println("-----------chess board ------------");
         for(int i=0; i<arr.length; i++){
             for(int j=0; j<arr.length; j++){
                 System.out.print(arr[i][j] + " ");
             }
             System.out.println();
         }
    }


    public static void main(String[] args) {
        int arr[][] = {
            {0,0,8,0,0,0,0,0,0},
            {4,9,0,1,5,7,0,0,2},
            {0,0,3,0,0,4,1,9,0},
            {1,8,5,0,6,0,0,2,0},
            {0,0,0,0,2,0,0,6,0},
            {9,6,0,4,0,5,3,0,0},
            {0,3,0,0,7,2,0,0,4},
            {0,4,9,0,3,0,0,5,7},
            {8,2,7,0,0,9,0,1,3},
        };
        sudokuSolver(arr , 0 , 0);
        printBoardsudoku(arr);
        
    }
}
