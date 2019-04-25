

package com.example.learnchinese;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;

import com.example.learnchinese.data.WordContract.WordEntry;
import com.example.learnchinese.data.WordCursorAdapter;

/**
 * Displays list of words
 */
public class MainActivity extends AppCompatActivity implements
        MainActivityView, LoaderManager.LoaderCallbacks<Cursor>{

    /** Identifier for the word data loader */
    private static final int WORD_LOADER = 0;
    private static final String CATEGORY = "PEOPLE";

    private MainActivityPresenter presenter;
    private WordCursorAdapter mCursorAdapter;
    private ListView wordListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the ListView which will be populated with the pet data
        wordListView = (ListView) findViewById(R.id.list);

        MainActivityPresenter presenter =
                new MainActivityPresenter(this, mCursorAdapter, new WordRepository(this));
        presenter.displayWords();

        // Kick off the loader
    }

    @Override
    public void initView() {
        mCursorAdapter = new WordCursorAdapter(this, null);
        wordListView.setAdapter(mCursorAdapter);
        getLoaderManager().initLoader(WORD_LOADER, null, this);
    }

    @Override
    public void queryCategory() {

    }

    @Override
    public void displayWords() {

    }


    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        // Define a projection that specifies the columns from the table we care about.
        String[] projection = {
                WordEntry._ID,
                WordEntry.COLUMN_ENG_NAME,
                WordEntry.COLUMN_PINYIN,
                WordEntry.COLUMN_CHN_CHAR,
                WordEntry.COLUMN_IMAGE_ID,
                WordEntry.COLUMN_SOUND_ID,
                WordEntry.COLUMN_CATEGORY};

        Uri newUri = Uri.withAppendedPath(WordEntry.CONTENT_URI, WordEntry.COLUMN_CATEGORY);

        /* the WordEntry.CONTENT_URI basically will give me back all words
        according to the WordProvider. Change this for different activities
         */
        // This loader will execute the ContentProvider's query method on a background thread
        return new CursorLoader(this,   // Parent activity context
                newUri,   // Provider content URI to query
                projection,             // Columns to include in the resulting Cursor
                null,                   // No selection clause
                new String[]{CATEGORY},                   // No selection arguments
                null);                  // Default sort order
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        // Update with this new cursor containing updated word data
        mCursorAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        // Callback called when the data needs to be deleted
        mCursorAdapter.swapCursor(null);
    }


}

