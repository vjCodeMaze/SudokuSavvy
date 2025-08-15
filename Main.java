import java.util.Random;
import java.util.Scanner;
class Main
{
   public static boolean done = false;
   public static boolean error = false;
    public static void main(String[] args)
    {
        Matrix matrix = new Matrix();
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
class Matrix
{
     static Main m = new Main();
     static int[][] sudoko = new int[9][9];
     Scanner scanner = new Scanner(System.in);
     
     // error in the logic of creating rand element at rand indexes
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
            // sudoko[random.nextInt(9)][random.nextInt(9)] = random.nextInt(9)+1;
            // s++;
             
         }
     }
    void print()
    {
        System.out.printf("\t");
        for(int i = 1; i<10; i++)
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

    static int verify()
    {
        int q = 0;
         int temp = sudoko[q][0];
        for(int i = q; i<++q; i++)
        {
            // To traver the current row and column.
            for(int j =0; j<9; j++)
            {
                if(temp == sudoko[i][j])
                {
                    m.error = true;
                    return sudoko[i][j];
                }
                else if(temp == sudoko[j][i])
                {
                    m.error = true;
                    return sudoko[i][j];
                }
                else if (!issafe(i, j, sudoko[i][j])) {
                    m.error = true;
                    return sudoko[i][j];
                }

            }
        }
        for(int i =q; i<2+q; i++)
        {
            for(int j = 0; j<2+q; j++)
            {
                if(q == sudoko[i][j])
                {
                     m.error = true;
                     return sudoko[i][j];
                }
            }
        }
        return -1;
    }
    void identify() 
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
    void move()
    {
        int i, j, num;
        System.out.printf("\nWanna QUIT(true): ");
        m.done = scanner.nextBoolean();
        if(!m.done)
        {
             System.out.printf("\nEnter the element: ");
             num = scanner.nextInt();
             System.out.printf("\nEnter the i'th and j'th column to add the element(true -> Quit): " );
             i = scanner.nextInt();
             j = scanner.nextInt();
             sudoko[i][j] = num;
             // TO CHECK THE VALIDITY FOR EVERY MOVE:
             // if(issafe(i, j, num))
                //  sudoko[i][j] = num;
              // else
                // System.out.println("INVALID MOVE! ");
        }
    }
}