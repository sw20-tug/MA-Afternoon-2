package at.tugraz.ist.ma.games;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

class HangmanWord {

    private ArrayList<String> values = new ArrayList<>();

    ArrayList<String> getValues() {
        return values;
    }

    void loadWords(Context ctx) {
        String[] word_list;
        try {
            word_list = DataManager.loadWordList(ctx);
        } catch (Exception e) {
            System.out.println("No custom word list");
            word_list = new String[] {};
        }

        values = new ArrayList<>(Arrays.asList(word_list));
    }

    void saveWords(Context ctx) {
        String[] word_list = values.toArray(new String[0]);

        try {
            DataManager.storeWordList(word_list, ctx);
        } catch (IOException e) {
            System.out.println("Error can not write words file " + e.toString());
        }
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
