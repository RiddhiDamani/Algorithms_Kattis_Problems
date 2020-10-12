import java.util.*;

public class BoggleGame {

    static int[] directionX = { 0, 0, 1, 1, -1, 1, -1, -1 };
    static int[] directionY = { 1, -1, -1, 1, 1, 0, 0, -1 };
    static String word = "";
    static boolean[][] visitedChar = new boolean[4][4];
    static List<String> wordDetected;

    public static void main(String[] args) {

        char[][] boggleBoard;
        int[] boggleScores = {0, 0, 0, 1, 1, 2, 3, 5, 11};
        StringBuilder finalResult = new StringBuilder();
        String[] dicWords = new String[0];

        Scanner inputData = new Scanner(System.in);
        int numDicWords = inputData.nextInt();

        if(numDicWords > 1 && numDicWords < 300000) {
            dicWords = new String[numDicWords];
            for(int i = 0; i < numDicWords; i++) {
                dicWords[i] = inputData.next();
            }
        }
        else {
            System.out.println("Limit exceeded! Enter words in range 1 - 300000");
        }

        int numOfBoggleBoards = inputData.nextInt();
        if(numOfBoggleBoards > 1 && numOfBoggleBoards < 30) {

            for(int i=0; i < numOfBoggleBoards; i++) {
                boggleBoard = new char[4][4];
                for(int boardValues=0; boardValues < 4; boardValues++) {
                    boggleBoard[boardValues] = inputData.next().toCharArray();
                }

                List<String> dictionary = Arrays.asList(dicWords);
                wordDetected = new ArrayList<>();
                for(int row = 0; row < 4; row++) {
                    for(int col = 0; col < 4; col++) {
                        visitedChar[row][col] = true;
                        searchWord(boggleBoard, visitedChar, row, col, word + boggleBoard[row][col], dictionary);
                        visitedChar[row][col] = false;
                    }
                }

//                System.out.println(wordDetected);
                int totalWordFound = wordDetected.size();
                int longest_length = 0;
                ArrayList<String> listOfLongestWord = new ArrayList<>();
                //System.out.println("Total Words Found" + totalWordFound);

                for (String str : wordDetected) {
                    int length = str.length();
                    if (length > longest_length) {
                        longest_length = length;
                        listOfLongestWord.clear();
                    }
                    if (length == longest_length) {
                        listOfLongestWord.add(str);
                    }
                }
                //System.out.println("List" + listOfLongestWord);

                // Calculating longestWord
                String longestWord = null;
                for(String str: listOfLongestWord) {
                    longestWord = str;
                }

                // Calculating total scores
                int maximalScore = 0;
                for (String x : wordDetected)	{
                    maximalScore += boggleScores[x.length()];
                }

                finalResult.append(maximalScore).append(" ").append(longestWord).append(" ").append(totalWordFound).append("\n");
            }
            System.out.println(finalResult.toString());
        }
        else {
            System.out.println("Limit Exceeded! Enter number of boards in range 1 - 30");
        }

        inputData.close();
    }

    public static void searchWord(char[][] boggleBoard, boolean[][] visitedChar, int rowCurr, int colCurr, String word, List dictionary) {

        if(!wordDetected.contains(word)) {
            if(dictionary.contains(word)) {
                wordDetected.add(word);
//                System.out.println(word);
            }
        }
        if( word.length() == 16) {
            return;
        }
        for(int i=0; i < directionX.length; i++) {
            int rowNew = rowCurr + directionX[i];
            int colNew = colCurr + directionY[i];
            if(isValid(rowNew, colNew, visitedChar)) {
                visitedChar[rowNew][colNew] = true;
                searchWord(boggleBoard, visitedChar, rowNew, colNew, word + boggleBoard[rowNew][colNew], dictionary);
                visitedChar[rowNew][colNew] = false;
            }
        }
    }

    public static boolean isValid(int rowNew, int colNew, boolean[][] visitedChar) {
        return (rowNew >= 0) && (rowNew < 4) && (colNew >= 0) && (colNew < 4) && (!visitedChar[rowNew][colNew]);
    }
}
