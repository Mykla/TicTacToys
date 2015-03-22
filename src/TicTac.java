    /**
     * Created by user on 21.03.2015.
     */
    import java.io.IOException;
    import java.util.Random;
    import java.util.Scanner;

    public class TicTac {

        // Игровое поле
        public static char[][] field =
                {       {'_', '_', '_'},
                        {'_', '_', '_'},
                        {'_', '_', '_'}};

        // Ход компьютера
        public static void CompMove() {
            Random rn = new Random();
            int x = 0, y = 0;
            while (field[x][y] == '0' || field[x][y] == 'X') {
                x = rn.nextInt(3);
                y = rn.nextInt(3);
            }
            field[x][y] = '0';
        }

        // Ход человека
        public static void HumanMove() throws IOException {
            int x, y;

            Scanner reader = new Scanner(System.in);
            System.out.println("Введите y (1..3): ");
            x = reader.nextInt() - 1;
            System.out.println("Ввведите x (1..3):");
            y = reader.nextInt() - 1;


            while (field[x][y] == '0' || field[x][y] == 'X' || x < 0 || x > 2 || y < 0 || y > 2) {
                System.out.println("Введите y (1..3): ");
                x = reader.nextInt() - 1;
                System.out.println("Ввведите x (1..3):");
                y = reader.nextInt() - 1;

            }
            field[x][y] = 'X';
        }

        // Вывод игрового поля на экран
        public static void PrintField() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(" " + field[i][j] + " ");
                }
                System.out.println();
            }
        }

        // Проерка состояния игры и есть ли победители
        // возвращает символ победителя или символ пробела если пока никто не
        // выиграл
        public static char CheckGame() {
            char winner = ' ';
            // Проверка по горизонтали
            for (int i = 0; i < 3; i++) {
                if (field[i][0] == field[i][1] && field[i][1] == field[i][2] && field[i][0] != '_') {
                    winner = field[i][0];
                    break;
                }
            }

            // Проверка по вертикали если победитель пока не найден
            if (winner == ' ') {
                for (int i = 0; i < 3; i++) {
                    if (field[0][i] == field[1][i] && field[1][i] == field[2][i] && field[0][i] != '_') {
                        winner = field[0][i];
                        break;
                    }
                }
            }

            // Проверка главной диагонали если победитель пока не найден
            if (winner == ' ') {
                if (field[0][0] == field[1][1] && field[1][1] == field[2][2] && field[0][0] != '_') {
                    winner = field[0][0];
                }
            }

            // Проверка побочной диагонали если победитель пока не найден
            if (winner == ' ') {
                if (field[0][2] == field[1][1] && field[1][1] == field[2][0] && field[0][2] != '_') {
                    winner = field[0][0];
                }
            }
            // Возвращаем победителя или пробел, если такового пока нет
            return winner;
        }

        // Метод определяет остались ли еще на игровом поле свободные клетки
        public static boolean CanMove() {
            boolean p = false;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (field[i][j] == '_') {
                        p = true;
                        break;
                    }
                }
                if (p = true) {
                    break;
                }
            }
            return p;
        }

        public static void main(String[] args) throws IOException {
            System.out.println("Игра началась!!! Вы играете крестиками!");
            PrintField();
            while (CheckGame() == ' ' && CanMove()) {
                HumanMove();
                CompMove();
                PrintField();
            }
            if (CheckGame() == 'X') {
                System.out.println("Вы выиграли!");
            }
            if (CheckGame() == '0') {
                System.out.println("Вы проиграли!");
            }
            if (CheckGame() == ' ' && !CanMove()) {
                System.out.println("STANDOFF!");
            }
        }

    }
