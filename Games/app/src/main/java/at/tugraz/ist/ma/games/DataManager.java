package at.tugraz.ist.ma.games;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class DataManager {

    static void storeWordList(String[] word_list, Context context) throws IOException {
        JSONArray jsonArray = new JSONArray(Arrays.asList(word_list));

        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput(context.getString(R.string.wordfile), Context.MODE_PRIVATE));
        outputStreamWriter.write(jsonArray.toString());
        outputStreamWriter.close();
    }

    static String[] loadWordList(Context context) throws IOException, JSONException {
        InputStreamReader inputStreamReader = new InputStreamReader(context.openFileInput(context.getString(R.string.wordfile)));
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line).append("\n");
        }

        JSONArray jsonArray = new JSONArray(sb.toString());

        String[] ret = new String[jsonArray.length()];

        for(int i = 0; i < jsonArray.length(); i++){
            ret[i] = jsonArray.optString(i);
        }

        return ret;
    }
}
