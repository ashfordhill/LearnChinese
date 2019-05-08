

package com.example.learnchinese.VocabReviewActivities;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.learnchinese.R;
import com.example.learnchinese.data.WordContract.WordEntry;
import com.example.learnchinese.data.WordCursorAdapter;

/**
 * Parent class for word list displaying activities
 */


public class VocabActivity extends AppCompatActivity implements
        VocabActivityView, LoaderManager.LoaderCallbacks<Cursor>{

    /** Identifier for the word data loader */
    private static final int WORD_LOADER = 0;
    private String CATEGORY = "";

    private VocabActivityPresenter presenter;
    private WordCursorAdapter mCursorAdapter;
    private ListView wordListView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocab);

        // Find the ListView which will be populated with the word data
        wordListView = (ListView) findViewById(R.id.list);

        VocabActivityPresenter presenter =
                new VocabActivityPresenter(this, mCursorAdapter);
        presenter.displayWords();

    }

    @Override
    public void initView() {
        mCursorAdapter = new WordCursorAdapter(this, null);
        wordListView.setAdapter(mCursorAdapter);
        getLoaderManager().initLoader(WORD_LOADER, null, this);
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

    public String getCategory() {
        return CATEGORY;
    }

    public void setCategory(String cat) {
        CATEGORY = cat;
    }

    @Override
    public void queryCategory() {

    }

    @Override
    public void displayWords() {

    }




}

