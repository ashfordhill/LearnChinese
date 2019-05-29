package com.example.learnchinese.data;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import com.example.learnchinese.data.WordContract.WordEntry;

import java.io.IOException;

/**
 * {@link ContentProvider}
 */
public class WordProvider extends ContentProvider {

    /** URI matcher code for the content URI for the words table */
    private static final int WORDS = 100;

    /** URI matcher code for the content URI for a single word in the words table */
    private static final int WORD_CATEGORY = 101;

    /**
     * UriMatcher object to match a content URI to a corresponding code.
     * The input passed into the constructor represents the code to return for the root URI.
     * It's common to use NO_MATCH as the input for this case.
     */
    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    // Static initializer. This is run the first time anything is called from this class.
    static {
        // The calls to addURI() go here, for all of the content URI patterns that the provider
        // should recognize. All paths added to the UriMatcher have a corresponding code to return
        // when a match is found.

        sUriMatcher.addURI(WordContract.CONTENT_AUTHORITY, WordContract.PATH_WORDS, WORDS);

        // The content URI of the form "content://com.example.learnchinese/words/#/WORD_CATEGORY" will map to the
        // integer code {@link #WORD_ID}.
        sUriMatcher.addURI(WordContract.CONTENT_AUTHORITY, WordContract.PATH_WORDS + "/*", WORD_CATEGORY);
    }

    /** Database helper object */
    //private WordDbAccess mDbAccess;
    private SQLiteDatabase database;


    @Override
    public boolean onCreate() {
        WordDbHelper wordDbHelper = new WordDbHelper(getContext());
        database = wordDbHelper.getReadableDatabase();
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,
                        String sortOrder) {


        // This cursor will hold the result of the query
        Cursor cursor;

        // Figure out if the URI matcher can match the URI to a specific code
        int match = sUriMatcher.match(uri);
        switch (match) {
            case WORDS:
                cursor = database.query(WordEntry.TABLE_NAME, projection, selection, selectionArgs,
                        null, null, sortOrder);
                break;
            case WORD_CATEGORY:
                selection = WordEntry.COLUMN_CATEGORY + "=?";
                cursor = database.query(WordEntry.TABLE_NAME, projection, selection, selectionArgs,
                        null, null, sortOrder);
                break;

            default:
                throw new IllegalArgumentException("Cannot query unknown URI " + uri);
        }

        return cursor;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }

}