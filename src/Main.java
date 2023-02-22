import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Scrambler scrambler = new Scrambler();
        Decoder decoder = new Decoder();
        WriteAndReadFile writeAndReadFile = new WriteAndReadFile();

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

                    try {
                        System.out.println("Текст файла зашифрован\n" +
                                "Результат:\n" +
                                scrambler.caesar(writeAndReadFile.read(paths1), shift, position) +
                                "\n\nРезультат также находиться в файле\n" + paths);
                        Path path = Path.of(paths);
                        writeAndReadFile.write(path, scrambler.caesar(writeAndReadFile.read(paths1), shift, position));

                    } catch (Exception e) {
                        System.out.println("Вы ввели некоректный путь к текстовому файлу");
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
                Path paths2 = Path.of(scanner.next());

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

                    try {
                        System.out.println("Текст файла расшифрован\n" +
                                "Результат:\n" +
                                scrambler.caesar(writeAndReadFile.read(paths2), shift, position) +
                                "\n\nРезультат также находиться в файле\n" + paths);
                        Path path = Path.of(paths);
                        writeAndReadFile.write(path, scrambler.caesar(writeAndReadFile.read(paths2), shift, position));

                    } catch (Exception e) {
                        System.out.println("Вы ввели некоректный путь к текстовому файлу");
                    }
                    scanner.close();
                    break;

                } else if (option == 2) {
                    try {
                        System.out.println("Текст файла расшифрован\n" +
                                "Результат:\n" +
                                decoder.bruteForse(writeAndReadFile.read(paths2)) +
                                "\n\nРезультат также находиться в файле\n" +
                                paths);
                        Path path = Path.of(paths);
                        writeAndReadFile.write(path, decoder.bruteForse(writeAndReadFile.read(paths2)));
                    }catch (Exception e) {
                        System.out.println("Вы ввели некоректный путь к текстовому файлу");
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
        int p = 0;
    }
}
//я ж это того самого как его в том что, ай ладно.