public class CaesarCypher {

    public static String caesarCypherEncryptor(String str, int key) {
        char[] newLetters = new char[str.length()];
        int newKey=key % 26;
        for(int i=0;i<str.length();i++){
            newLetters[i]=getNewLetters(str.charAt(i),newKey);
        }
        return new String(newLetters);
    }

    private static char getNewLetters(char letter, int key) {
        int newLetterCode=letter+key;
        return newLetterCode <=122 ? (char) newLetterCode: (char) (96+newLetterCode%122);
    }

    public static void main(String[] args) {
        System.out.println(caesarCypherEncryptor("xyz", 2));
    }

}
