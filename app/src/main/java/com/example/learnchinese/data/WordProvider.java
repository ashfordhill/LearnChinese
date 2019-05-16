package com.example.learnchinese.data;

import android.content.ContentProvider;
import android.content.ContentValues;
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

        // The content URI of the form "content://com.example.learnchinese/words" will map to the
        // integer code {@link #WORDS}. This URI is used to provide access to MULTIPLE rows
        // of the words table.
        sUriMatcher.addURI(WordContract.CONTENT_AUTHORITY, WordContract.PATH_WORDS, WORDS);

        // The content URI of the form "content://com.example.learnchinese/words/#" will map to the
        // integer code {@link #WORD_ID}. This URI is used to provide access to ONE single row
        // of the words table.
        //
        // In this case, the "#" wildcard is used where "#" can be substituted for an integer.
        // For example, "content://com.example.android.pets/words/3" matches, but
        // "content://com.example.android.pets/words" (without a number at the end) doesn't match.
        sUriMatcher.addURI(WordContract.CONTENT_AUTHORITY, WordContract.PATH_WORDS + "/*", WORD_CATEGORY);
    }

    /** Database helper object */
    //private WordDbAccess mDbAccess;
    private WordDbHelper dbHelper;


    @Override
    public boolean onCreate() {
            //mDbAccess = WordDbAccess.getInstance(getContext());
        dbHelper = new WordDbHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,
                        String sortOrder) {


        try {
            dbHelper.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }

        SQLiteDatabase database = dbHelper.getWritableDatabase();

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