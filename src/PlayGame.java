package games;

import java.util.Scanner;

public class PlayGame {

    public static void main(String args[]) {

        int noOfIteration = 0;

        Scanner sc = new Scanner(System.in);
        noOfIteration = sc.nextInt();

        while (sc.hasNext()) {

            int playerOneWidth = 0, playerTwoWidth = 0,
                    gameDealCount = 0, playerOneHitCount = 0,
                    playerTwoHitCount = 0, playerOneShipCount = 0,
                    playerTwoShipCount = 0;
            int gamePlanArray[] = new int[3];

            int ap[][];

            String[] boardInput;

            char[][] playerOneBoard;
            char[][] playerTwoBoard;

            for (int i = 0; i < gamePlanArray.length; i++) {
                gamePlanArray[i] = sc.nextInt();
            }

            playerOneWidth = gamePlanArray[0];
            playerTwoWidth = gamePlanArray[1];
            gameDealCount = gamePlanArray[2];

            playerOneBoard = new char[playerOneWidth][playerOneWidth];
            playerTwoBoard = new char[playerTwoWidth][playerTwoWidth];
            boardInput = new String[playerTwoWidth];

            for (int i = 0; i < playerOneWidth; i++) {
                boardInput[i] = sc.next();
            }

            //Player One Board Input
            char temp[];
            for (int i = 0; i < playerOneWidth; i++) {
                temp = boardInput[i].toCharArray();

                for (int j = 0; j < temp.length; j++)
                    playerOneBoard[i][j] = temp[j];
            }

            //Player Two Board Input
            for (int i = 0; i < playerTwoWidth; i++) {
                boardInput[i] = sc.next();
            }


            for (int i = 0; i < playerTwoWidth; i++) {
                temp = boardInput[i].toCharArray();

                for (int j = 0; j < temp.length; j++)
                    playerTwoBoard[i][j] = temp[j];
            }


            ap = new int[gameDealCount][2];
            for (int i = 0; i < gameDealCount; i++) {
                for (int j = 0; j < 2; j++) {
                    ap[i][j] = sc.nextInt();
                }

            }

            System.out.println("Board One->");
            printTwoDimenArray(playerOneBoard);

            System.out.println("Board Two->");
            printTwoDimenArray(playerTwoBoard);

            playerOneShipCount = totalShipCountInArray(playerOneBoard);
            playerTwoShipCount = totalShipCountInArray(playerTwoBoard);


            for (int i = 0; i < ap.length; i++) {
                char guess = playerOneBoard[ap[i][1]][ap[i][0]];
                    System.out.println("PlayerOne->" + ap[i][0] + "," + ap[i][1] + " " + guess);
                    if (guess == '#') {
                        playerOneHitCount++;
                        playerOneBoard[ap[i][1]][ap[i][0]]='X';
                    }

            }


        for (int i = 0; i < ap.length; i++) {
            char guess = playerTwoBoard[ap[i][1]][ap[i][0]];
            System.out.println("PlayerTwo->" + ap[i][0] + "," + ap[i][1] + " " + guess);
            if (guess == '#') {
                playerTwoHitCount++;
                playerTwoBoard[ap[i][1]][ap[i][0]]='X';

            }
        }



            int playerOneShipLeft = playerOneShipCount - playerOneHitCount;
            int playerTwoShipLeft = playerTwoShipCount - playerTwoHitCount;

            System.out.println("playerOneShipCount " + playerOneShipCount);
            System.out.println("playerTwoShipCount " + playerTwoShipCount);
            System.out.println("playerOneHitCount " + playerOneHitCount);
            System.out.println("playerTwoHitCount " + playerTwoHitCount);
            System.out.println();


            if (playerOneShipLeft == 0 && playerTwoShipLeft > 0)
                System.out.println("player two wins");
            else if (playerOneShipLeft > 0  && playerTwoShipLeft == 0)
                System.out.println("player one wins");
            else
                System.out.println("draw");


        }

    }
////////////////////////////SOME UTILS///////////////////

    public static void printTwoDimenArray(char matrix[][]) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println();
        }
    }

    public static int totalShipCountInArray(char matrix[][]) {
        int count = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                if (matrix[row][column] == '#')
                    count++;
            }
        }
        return count;

    }

    public static void printTwoDimenArray(int matrix[][]) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println();
        }
    }

    public static void printOneDimenArray(String matrix[]) {
        for (int row = 0; row < matrix.length; row++) {
            System.out.print(matrix[row] + " ");
        }
        System.out.println();
    }

    public static void printOneDimenArray(int matrix[]) {
        for (int row = 0; row < matrix.length; row++) {
            System.out.print(matrix[row] + " ");
        }
        System.out.println();
    }

}


