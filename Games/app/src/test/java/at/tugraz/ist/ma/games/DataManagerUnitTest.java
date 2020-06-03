package at.tugraz.ist.ma.games;

import org.json.JSONException;
import org.junit.Test;
import android.content.Context;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class DataManagerUnitTest
{


    private String filename = "words_en.json";

    @Test
    public void checkWrite() throws IOException, JSONException
    {

        String[] word_list = new String[]{ "test1", "test2", "test3"};

        System.out.println(System.getProperty("user.dir") + filename);
        File file = new File(Objects.requireNonNull(System.getProperty("user.dir"))  + "/" + filename);
        FileOutputStream outstream = new FileOutputStream(file);
        Context context = mock(Context.class);
        when(context.openFileOutput(filename, Context.MODE_PRIVATE)).thenReturn(outstream);
        when(context.getString(R.string.wordfile)).thenReturn(filename);
        DataManager.storeWordList(word_list,context);

        FileInputStream instream = new FileInputStream(file);
        when(context.openFileInput(filename)).thenReturn(instream);

        String[] words = DataManager.loadWordList(context);
        assertArrayEquals(word_list,words);


    }
}
