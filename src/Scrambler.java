import java.util.*;

public class Scrambler {
    private  final char[] ALPHABET = new char[]{
            'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О',
            'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я',
            'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о',
            'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я',
            ' ', ',', '"', ':', '-', '!', '?', '.'
    };
    public String caesar(char[] line, int shift, int position) {
        HashMap<Integer,Character> cipher = new HashMap<>(); //Мапа для шифрованного текста
        //ArrayList<Integer> index = new ArrayList<>(); //Лист для индекса заглавных букв

        for (int i = 0; i < line.length; i++) {
//            if (line[i] >= 'А' && line[i] <= 'Я') { //Проверяем есть ли заглавные буквы, если есть, то сохраняем индекс
//                index.add(i);                       //и приводим к строчным
//                line[i] =  Character.toLowerCase(line[i]);
//            }
            if (position == 2) { //Если сдвиг влево то
                for (int j = ALPHABET.length - 1; j >= 0; j--) {
                    if (line[i] == ALPHABET[j]) {                //Находим символ в массиве ALPHABET
                        if (j - shift >= 0) {  //Если индекс символа в массиве - отступ >= 0
                            cipher.put(i, ALPHABET[j - shift]);  //то шифруем символ в мапу
                            break;

                        } else if (j - shift < 0) { //Если < 0 то
                            int f = (j - shift) + ALPHABET.length; //(индекс символа в массиве - отступ) + длина массива
                            while (f < 0) { //Повторяем пока не станет > 0
                                f = f + ALPHABET.length;
                            }
                            cipher.put(i, ALPHABET[f]); //шифруем символ в мапу
                            break;
                        }
                    }
                }
            }else{
                for (int j = 0; j < ALPHABET.length; j++) {
                    if (line[i] == ALPHABET[j]) {                //Находим символ в массиве ALPHABET
                        if (j + shift <= ALPHABET.length - 1) {  //Если индекс символа в массиве + отступ <= длина массива
                            cipher.put(i, ALPHABET[j + shift]);  //то шифруем символ в мапу
                            break;

                        } else if (j + shift > ALPHABET.length - 1) { //Если > длины массива то от
                            int f = (j + shift) - ALPHABET.length; //(индекс символа в массиве + отступ) отнимаем(-) длина массива
                            while (f > ALPHABET.length - 1) { //Повторяем пока не станет <= длина массива
                                f = f - ALPHABET.length;
                            }
                            cipher.put(i, ALPHABET[f]); //шифруем символ в мапу
                            break;
                        }
                    }
                }
            }
            while (cipher.values().remove(null)); //Ищем пустые(null) места и удаляем их
        }
//        for (Integer ind : index) {  //По индексу из массива index находим символы в мапе которые были заглавными
//            cipher.replace(ind, Character.toUpperCase(cipher.get(ind))); //и приводим их к toUpperCase
//        }
        char[] value = new char[cipher.size()];
        int f = 0;
        for(Map.Entry<Integer, Character> values : cipher.entrySet()) { //Из мапы достаём значения и приводим к строке
            value[f] = values.getValue();
            f++;
        }
        return new String(value);
    }
}