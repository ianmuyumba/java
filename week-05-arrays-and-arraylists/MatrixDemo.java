// Task 3: 2D arrays: an array of rows, accessed as matrix[row][col].
public class MatrixDemo {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},   // row 0
            {4, 5, 6},   // row 1
            {7, 8, 9}    // row 2
        };

        System.out.println("=== ACCESSING ELEMENTS ===");
        System.out.println("matrix[0][0] = " + matrix[0][0]);
        System.out.println("matrix[1][2] = " + matrix[1][2]);
        System.out.println("matrix[2][1] = " + matrix[2][1]);
        System.out.println("Number of rows: " + matrix.length);
        System.out.println("Number of columns in row 0: " + matrix[0].length);

        System.out.println("\n=== PRINTING THE MATRIX ===");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\n=== ENHANCED FOR LOOP ===");
        for (int[] row : matrix) {          // each row is itself an int[]
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }

        int totalSum = 0;
        for (int[] row : matrix) {
            for (int value : row) {
                totalSum += value;
            }
        }
        System.out.println("\n=== SUM OF ALL ELEMENTS ===");
        System.out.println("Sum of all elements: " + totalSum);

        System.out.println("\n=== ROW SUMS ===");
        for (int i = 0; i < matrix.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                rowSum += matrix[i][j];
            }
            System.out.println("Sum of row " + i + ": " + rowSum);
        }

        System.out.println("\n=== COLUMN SUMS ===");    // swap the loops: column outside
        for (int j = 0; j < matrix[0].length; j++) {
            int colSum = 0;
            for (int i = 0; i < matrix.length; i++) {
                colSum += matrix[i][j];
            }
            System.out.println("Sum of column " + j + ": " + colSum);
        }

        System.out.println("\n=== STUDENT MARKS TABLE ===");
        int[][] studentMarks = {
            {85, 90, 78},   // Alice:   Math, English, Science
            {72, 88, 91},   // Bob
            {65, 75, 80}    // Charlie
        };
        String[] studentNames = {"Alice", "Bob", "Charlie"};
        String[] subjects = {"Math", "English", "Science"};

        System.out.printf("%-10s", "Student");
        for (String subject : subjects) {
            System.out.printf("%-9s", subject);
        }
        System.out.println("Average");
        System.out.println("-------------------------------------------");
        for (int i = 0; i < studentMarks.length; i++) {
            System.out.printf("%-10s", studentNames[i]);
            int total = 0;
            for (int mark : studentMarks[i]) {
                System.out.printf("%-9d", mark);
                total += mark;
            }
            System.out.printf("%.2f%n", (double) total / studentMarks[i].length);
        }
    }
}
