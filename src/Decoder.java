import java.util.*;

public class Decoder {
    private final String[] prepositions = new String[]{"в", "к", "до", "по", "через", "после",
            "из-за", "за", "над", "под", "перед", "у",
            "возле", "мимо", "около", "от", "ради",
            "благодаря", "ввиду", "вследствие",
            "для", "на", "ради"};
    private final char[] ALPHABET = new char[]{
            'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О',
            'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я',
            'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о',
            'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я',
            ' ', ',', '"', ':', '-', '!', '?', '.'
    };

    public String bruteForse(char[] line) {
        HashMap<Integer, Character> cipher = new HashMap<>();
        ArrayList<Integer> coincidence = new ArrayList<>();
        int k = 0;
        while (k < ALPHABET.length) {
            for (int i = 0; i < line.length; i++) {
                    for (int j = 0; j < ALPHABET.length; j++) {
                        if (line[i] == ALPHABET[j]) {
                            if (j + (1 + k) >= ALPHABET.length) {
                                cipher.put(i, ALPHABET[j + (1 + k) - ALPHABET.length]);
                                break;
                            }
                            cipher.put(i, ALPHABET[j + (1 + k)]);
                            break;
                        }
                    }
                }
            char[] values = new char[cipher.size()];
            int l = 0;
            for (Map.Entry<Integer, Character> val : cipher.entrySet()) {
                values[l++] = val.getValue();
            }
            String str = new String(values);
            String[] space = str.split(" ");
            int a = 0;
            for (String s : space) {
                for (String preposition : prepositions) {
                    if (s.equals(preposition)) {
                        a++;
                        break;
                    }
                }
            }
                coincidence.add(k++, a);
        }
        int max = Collections.max(coincidence);
        for (int i = 0; i < line.length; i++) {
            for (int j = 0; j < ALPHABET.length; j++) {
                if (line[i] == ALPHABET[j]) {
                    if (j + 1 + coincidence.indexOf(max) >= ALPHABET.length) {
                        cipher.put(i, ALPHABET[j + (1 + coincidence.indexOf(max)) - ALPHABET.length]);
                        break;
                    }
                    cipher.put(i, ALPHABET[j + (1 + coincidence.indexOf(max))]);
                    break;
                }
            }
        }
        char[] value = new char[cipher.size()];
        int f = 0;
        for(Map.Entry<Integer, Character> values : cipher.entrySet()) {
            value[f] = values.getValue();
            f++;
        }
        int p = 0;
        return new String(value);
    }
}
