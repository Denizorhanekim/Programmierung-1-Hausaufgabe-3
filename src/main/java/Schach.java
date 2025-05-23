import java.util.Scanner;
public class Schach {
    public static void main(String[] args) {

        char[][] board = createBoard();   // Brett erstellen
        showBoard(board);                 // Brett anzeigen


            System.out.println("\nZug: e2 nach e4");
            move(board, 'e', 2, 'e', 4);      // Zug von e2 nach e4
            showBoard(board);                 // Brett neu anzeigen


    }

    public static char[][] createBoard(){
        char[][] board = new char[8][8];

        //Schwarze Figuren befinden sich oben
        board[0]=new char[]{
                '♜', '♞', '♝', '♛', '♚', '♝', '♞', '♜'

        };
        board[1]=new char[]{
                '♟', '♟', '♟', '♟', '♟', '♟', '♟', '♟'
        };

        //Leere Felder befinden sich zwischen schwarze und weiße Figuren
        for(int i=2;i<6;i++) {
            board[i] = new char[]{
                    '0', '0', '0', '0', '0', '0', '0', '0',
            };
        }
        /*
        Praktischer:
        for (int i = 2; i <= 5; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = '0';
            }
        }
         */


        //Weiße Figuren befinden sich unten
        board[6] = new char[] {
                '♙', '♙', '♙', '♙', '♙', '♙', '♙', '♙'
        };
        board[7] = new char[] {
                '♖', '♘', '♗', '♕', '♔', '♗', '♘', '♖'
        };

        return board;
    }

    public static void showBoard(char[][] board) {
        for(int row=0;row<board.length;row++) {
            System.out.print((8 - row) + " "); // neben die row-nummern steht ein leerzeichen bevor dir figuren dargestellt sind, 8-row sicherstelllt dass die nummerierun mit 8 beginnt und mit 1 am ende beendet

            for (int col = 0; col < board[row].length; col++) {
                char piece = board[row][col];
                boolean weißesFeld = (row + col) % 2 == 0;
                if (piece == '0') {
                    System.out.print(weißesFeld ? "⬜ " : "⬛");
                } else {
                    System.out.print(piece + " ");
                }
            }
            System.out.println();
        }


        //Spaltenbeschriftung
        System.out.println(" ");
        for(char col='a';col<='h';col++){
            System.out.print(col+" "); //col hier ist eine Variable die nur in dieser Schleife definiert ist und Platzhalter für unsere columns und wir beschriften die Columns und die werden ganz am Ende nach dem Schachboard beschriftet in einer Zeile
        }
    }

    public static void move(char[][] board, char fromCol, int fromRow, char toCol, int toRow) {
        int fromRowIndex = 8 - fromRow;
        int fromColIndex = fromCol - 'a';

        int toRowIndex = 8 - toRow;
        int toColIndex = toCol - 'a';

        // Prüfen, ob überhaupt eine Figur auf dem Startfeld steht
        if (board[fromRowIndex][fromColIndex] == '0') {
            System.out.println("Kein Stein auf dem Feld " + fromCol + fromRow);
            return;
        }

        // Figur bewegen
        board[toRowIndex][toColIndex] = board[fromRowIndex][fromColIndex];

        // Startfeld entleeren (auf '0' setzen – damit showBoard ⬜ oder ⬛ anzeigt)
        board[fromRowIndex][fromColIndex] = '0';
    }


}
