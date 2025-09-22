//Project 3
//By Tyler Hoffman
//CSCI 1913

import java.util.Random;

public class CharBag{
    private static final int alphabetSize = 27;
    private final int[] counts;
    private int size;
    private final Random rng;

    /**
     * Constructs an empty CharBag with no characters and a new Random generator.
     */
    public CharBag(){
        counts = new int[alphabetSize];
        size = 0;
        rng = new Random();
    }

    /**
     * Maps a given character to its index in the counts array. Converts uppercase letters to lowercase letters and maps non-letters to the STOP index.
     * @param c
     * @return
     */
    private int indexOf(char c){
        if(c >= 'A' && c <= 'Z'){
            c = Character.toLowerCase(c);
        }

        if(c >= 'a' && c <= 'z'){
            return c - 'a';
        }

        return alphabetSize - 1;
    }

    /**
     * Adds one occurence of the specified character to this CharBag. Converts uppercase letters to lowercase letters and maps non-letters to the STOP index.
     * @param c
     */
    public void add(char c){
            int index = indexOf(c);
            counts[index]++;
            size++;
        }

        /**
         * Removes one occurence of the specified character to this CharBag. Converts uppercase letters to lowercase letters and maps non-letters to the STOP index. If the character is not present, CharBag does't change.
         * @param c
         */
    public void remove(char c){
        int index = indexOf(c);
        if(counts[index] > 0){
            counts[index]--;
            size--;
        }
    }

    /**
     * Returns the count of how many times the specified character appears in this CharBag. Converts uppercase letters to lowercase letters and maps non-letters to the STOP index.
     * @param c
     * @return
     */
    public int getCount(char c){
        int index = indexOf(c);
        return counts[index];
    }

    /**
     * Returns the size of characters stored in this CharBag.
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * Returns a string representation of this CharBag in the format provided by the tester.
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("CharBag{");
        for (char c = 'a'; c <= 'z'; c++) {
            int index = indexOf(c);
            sb.append(c).append(":").append(counts[index]).append(", ");
        }
        sb.append(LetterSample.STOP).append(":").append(counts[alphabetSize - 1]).append("}");
        return sb.toString();
    }

    /**
     * Randomly selects and returns a character from this CharBag. If the bag is empty, returns STOP character.
     * @return
     */
    public char getRandomChar(){
        if(size == 0){
            return LetterSample.STOP;
        }

        int random = rng.nextInt(size);
        for(int i = 0; i  < alphabetSize; i++){
            if(random < counts[i]){
                if(i < 26){
                    return (char) ('a' + i);
                } else{
                    return LetterSample.STOP;
                }
            }

            random -= counts[i];
        }

        return LetterSample.STOP;
    }
}