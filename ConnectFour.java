import java.util.Scanner;
public class ConnectFour
{
    public static void main(String[] args)
    {
        System.out.println("I added this line!");
        Scanner input = new Scanner(System.in);
        int height, length, turn = 0, row, col;
        char player1 = 'x', player2 = 'o';
        System.out.print("What would you like the height of the board to be? ");
        height = input.nextInt();
        System.out.print("What would you like the length of the board to be? ");
        length = input.nextInt();
        char[][] board = new char[height][length];
        initializeBoard(board);
        printBoard(board);
        System.out.println("Player 1: " + player1);
        System.out.println("Player 2: " + player2 + "\n");
        do
        {
            if(turn % 2 == 0)
            {
                System.out.print("Player 1: Which column would you like to choose? ");
                col = input.nextInt();
                row = insertChip(board, col, player1);
                printBoard(board);
                if(checkIfWinner(board, col, row, player1))
                {
                    System.out.println("Player 1 won the game!");
                    break;
                }
            }
            if(turn % 2 == 1)
            {
                System.out.print("Player 2: Which column would you like to choose? ");
                col = input.nextInt();
                row = insertChip(board, col, player2);
                printBoard(board);
                if(checkIfWinner(board, col, row, player2))
                {
                    System.out.println("Player 2 won the game!");
                    break;
                }
            }
            turn++;
            if(turn == length * height)
            {
                System.out.println("Draw. Nobody wins.");
                break;
            }
        }while(true);
    }

    public static void printBoard(char[][] array)
    {
        for(int i = array.length - 1; i >= 0; i--)
        {
            for(int j = 0; j < array[0].length; j++)
            {
                System.out.print(array[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static void initializeBoard(char[][] array)
    {
        for(int i = 0; i < array.length; i++)
        {
            for(int j = 0; j < array[0].length; j++)
            {
                array[i][j] = '-';
            }
        }
    }

    public static int insertChip(char[][] array, int col, char chipType)
    {
        int row = -1;
        for(int i = 0; i < array.length; i++)
        {
            if (array[i][col] == '-')
            {
                array[i][col] = chipType;
                row = i;
                break;
            }
        }
        return row;
    }

    public static boolean checkIfWinner(char[][] array, int col, int row, char chipType)
    {
        int count = 1;
        for(int i = 1; i < array.length; i++)
        {
            if((array[i - 1][col] == array[i][col]) && array[i][col] != '-')
            {
                count++;
            }
            else
                count = 1;
            if(count >= 4)
                return true;
        }
        count = 1;
        for(int i = 1; i < array[0].length; i++)
        {
            if((array[row][i - 1] == array[row][i]) && array[row][i] != '-')
            {
                count++;
            }
            else
                count = 1;
            if(count >= 4)
                return true;
        }
        return false;
    }
}
