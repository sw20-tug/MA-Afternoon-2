package at.tugraz.ist.ma.games;

import java.util.ArrayList;
import java.util.Arrays;

class HangmanWord {

    private ArrayList<String> values = new ArrayList<>();

    ArrayList<String> getValues() {
        return values;
    }

    void loadWords() {
        String[] list = new String[] { // TODO: load words
                "Word 1",
                "Word 2",
                "Word 3",
                "Word 4",
                "Word 5",
                "Word 6",
                "Word 7",
                "Word 8",
                "Word 9",
                "Word 10",
                "Word 11",
                "Word 12",
                "Word 13",
                "Word 14",
                "Word 15",
                "Word 16",
                "Word 17"
        };

        values = new ArrayList<>(Arrays.asList(list));
    }

    void saveWords() {
        String[] word_list = values.toArray(new String[0]);

        // TODO: save
    }

    boolean doesWordExist(String word) {
        return values.contains(word);
    }

    void addWord(String word) {
        values.add(word);
    }

    void removeWord(int idx) {
        values.remove(idx);
    }

}
