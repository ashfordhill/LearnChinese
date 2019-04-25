package com.example.learnchinese;

import android.content.Context;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.app.LoaderManager;


import com.example.learnchinese.data.WordContract.WordEntry;


public class WordRepository implements LoaderManager.LoaderCallbacks<Cursor>{

    private static final int WORD_LOADER = 0;


    private Uri queryUri;
    private Context mContext;
    public WordRepository(Context context) {
        this.mContext = context;

    }

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

        /* the WordEntry.CONTENT_URI basically will give me back all words
        according to the WordProvider. Change this for different activities
         */
        // This loader will execute the ContentProvider's query method on a background thread
        return new CursorLoader(mContext,   // Parent activity context
                WordEntry.CONTENT_URI,   // Provider content URI to query
                projection,             // Columns to include in the resulting Cursor
                null,                    // No selection clause
                null,                   // No selection arguments
                null);                  // Default sort order
    }

    @Override
    public void onLoadFinished(android.content.Loader<Cursor> loader, Cursor data) {
        // Update with this new cursor containing updated word data
        //mCursorAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        // Callback called when the data needs to be deleted
        //mCursorAdapter.swapCursor(null);
    }
}
