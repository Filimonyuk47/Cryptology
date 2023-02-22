import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Scrambler scrambler = new Scrambler();
        Decoder decoder = new Decoder();

        System.out.println("Здесь вы можете воспользоваться шифратором и дешифратором!\n\n" +
                "Если хотите воспользоваться шифратором введите: 1\n" +
                "Если хотите воспользоваться дешифратором введите: 2\n" +
                "Чтобы закончить введите: 0");
        while (true) {

            int scan = scanner.nextInt();

            if (scan == 1) {

                System.out.println("Каким из шифраторов вы хотите воспользоваться?\n" +
                        "1 - Шифр Цезаря");
                int option = scanner.nextInt();

                if (option == 1) {

                    System.out.println("Введите путь к текстовому файлу");
                    Path paths1 = Path.of(scanner.next());
                    char[] line = Files.readString(paths1,
                            StandardCharsets.UTF_8).toCharArray();
                    //NoSuchFileException

                    System.out.println("Введите путь к файлу для записи зашифрованного текста\n" +
                                       "Или его создания");
                    String paths = scanner.next();

                    //C:\\Users\\dizaf\\OneDrive\\test.txt
                    //C:\\Users\\dizaf\\OneDrive\\test1.txt

                    System.out.println("Укажите сдвиг");
                    int shift = scanner.nextInt();

                    System.out.println("Укажите позицию сдвига относительно символа\n" +
                            "1 - правее\n" +
                            "2 - левее");
                    int position = scanner.nextInt();

                    System.out.println("Текст файла зашифрован\n" +
                            "Результат:");
                    System.out.println(scrambler.caesar(line, shift, position) + "\n\n" +
                            "Результат также находиться в файле\n" +
                            paths);

                    Path path = Path.of(paths);
                    if (Files.exists(path)) {
                        Files.writeString(path,scrambler.caesar(line, shift, position), StandardOpenOption.WRITE);
                    }else {
                        Files.createFile(path);
                        Files.writeString(path, scrambler.caesar(line, shift, position), StandardOpenOption.WRITE);
                    }
                    scanner.close();
                    break;
                }

            } else if (scan == 2) {

                System.out.println("Каким из дешифраторов вы хотите воспользоваться?\n" +
                        "1 - Шифр Цезаря\n" +
                        "2 - brute forse");
                int option = scanner.nextInt();

                System.out.println("Введите путь к текстовому файлу");
                Path paths2 = Paths.get(scanner.next());
                char[] line = Files.readString(paths2,
                        StandardCharsets.UTF_8).toCharArray();

                System.out.println("Введите путь к файлу для записи расшифрованного текста\n" +
                        "Или его создания");
                String paths = scanner.next();
                //C:\\Users\\dizaf\\OneDrive\\test.txt
                //C:\\Users\\dizaf\\OneDrive\\test1.txt

                if (option == 1) {

                    System.out.println("Укажите сдвиг используемый при шифровании");
                    int shift = scanner.nextInt();


                    System.out.println("Укажите позицию сдвига относительно символа используемую при шифровании\n" +
                            "1 - правее\n" +
                            "2 - левее");
                    int position = scanner.nextInt();
                    if (position == 1) {
                        position = 2;
                    }else {
                        position = 1;
                    }

                    System.out.println("Текст файла расшифрован\n" +
                            "Результат:");
                    System.out.println(scrambler.caesar(line, shift, position) + "\n\n" +
                            "Результат также находиться в файле\n" +
                            paths);

                    Path path = Path.of(paths);
                    if (Files.exists(path)) {
                        Files.writeString(path,scrambler.caesar(line, shift, position), StandardOpenOption.WRITE);
                    }else {
                        Files.createFile(path);
                        Files.writeString(path, scrambler.caesar(line, shift, position), StandardOpenOption.WRITE);
                    }
                    scanner.close();
                    break;

                } else if (option == 2) {

                    System.out.println("Текст файла расшифрован\n" +
                            "Результат:");
                    System.out.println(decoder.bruteForse(line) + "\n\n" +
                            "Результат также находиться в файле\n" +
                            paths);

                    Path path = Path.of(paths);
                    if (Files.exists(path)) {
                        Files.writeString(path,decoder.bruteForse(line), StandardOpenOption.WRITE);
                    }else {
                        Files.createFile(path);
                        Files.writeString(path, decoder.bruteForse(line), StandardOpenOption.WRITE);
                    }
                    scanner.close();
                    break;
                }

            } else if (scan == 0) {
                scanner.close();
                break;

            } else {
                System.out.println("Вы ввели неверные символы. Повторите пожалуйста");
            }
        }
    }
}
//я ж это того самого как его в том что, ай ладно.