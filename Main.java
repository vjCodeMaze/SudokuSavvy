import java.util.Random;
import java.util.Scanner;
class Main
{
   public static boolean done = false;
   public static boolean error = false;
    public static void main(String[] args)
    {
        Matrix matrix = new Matrix();
        while(matrix.play)
        {
            matrix.insert();
            matrix.print(); 
            while(!done)
            {
               matrix.move();
            }
             matrix.print();
             matrix.identify();
        }
    }
}
class Matrix
{
     static Main m = new Main();
     static int[][] sudoko = new int[9][9];
      static boolean play = true;
     Scanner scanner = new Scanner(System.in);
     static boolean isComplete() 
     {
          for (int i = 0; i < 9; i++) {
              for (int j = 0; j < 9; j++) {
               if (sudoko[i][j] == 0) 
                   return false;
               }
          }
            return true;
     }

     static boolean issafe(int row, int col, int val)
     {
         for(int i = 0; i<9; i++)
         {
            if(sudoko[row][i] == val || sudoko[i][col] == val)
                return false;
         }
            int startRow = row - row % 3;
            int startCol = col - col % 3;
         for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                   if (sudoko[i][j] == val)
               return false;
            }
        }

         return true;
     }
     void insert()
     {
         Random random = new Random(); 
         int s = 0;
         while(s<61)
         {
             int row = random.nextInt(9);
             int col = random.nextInt(9);
             int val = random.nextInt(9)+1;
             if(issafe(row, col, val))
                 sudoko[row][col] = val;
             s++;
         }
     }
    void print()
    {
        System.out.printf("\t");
        for(int i = 0; i<9; i++)
             System.out.printf("|%d|\t", i);
        System.out.println();
        for(int i = 0; i<9; i++)
        {
             System.out.printf("|%d|", i);
            for(int j=0; j<9; j++)
            {
                System.out.printf("\t%d ", sudoko[i][j]);
            }
            System.out.println();
        }
    }
    void identify()
    {
        if(isComplete())
        {
           System.out.println("ERRORS ARE:");
           for (int i = 0; i < 9; i++) {
             for (int j = 0; j < 9; j++) {
               int val = sudoko[i][j];
               if (val != 0 && !issafe(i, j, val)) {
                System.out.printf("Invalid value %d at (%d, %d)\n", val, i, j);
                m.error = true;
                }
              }
           }
        }
        else if(isComplete() && !m.error)
        {
            System.out.println("YOU WON THE GAME!");
            System.out.println("Thanks for playing, wanna continue(true/false): ");
             play = scanner.nextBoolean();
        }
        else
        {
        System.out.println("Game isn't Completed!");
         play = false;
        }
    }
    void move()
    {
        int user_moves = 0;
        int i, j, num;
        if(!m.done)
        {
             System.out.printf("\nEnter the element: ");
             num = scanner.nextInt();
             System.out.printf("\nEnter the i'th and j'th column to add the element: " );
             i = scanner.nextInt();
             j = scanner.nextInt();
             if(sudoko[i][j] == 0)
             {
                 sudoko[i][j] = num; user_moves++;
             }
             else
                 System.out.println("Already filled: ");
                 System.out.printf("\nWanna QUIT(true/false): ");
                 m.done = scanner.nextBoolean();
        }
    }
}