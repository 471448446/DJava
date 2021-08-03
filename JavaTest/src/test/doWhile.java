package test;

public class doWhile {
    public static void main(String[] args) {
        String[] strings = {
                "John", "Jack", "Abraham", "Jennifer", "Ann"};

        int wordsStartingWithJ = 0;
        int i = 0;
        do {
            if (!strings[i].toLowerCase().startsWith("j")) {
                i++;
                continue;
            }

            wordsStartingWithJ++;
            i++;
        } while (i < strings.length);
        System.out.println("wordsStartingWithJ" + wordsStartingWithJ);
    }
}
