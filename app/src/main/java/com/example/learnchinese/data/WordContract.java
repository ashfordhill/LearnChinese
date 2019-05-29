package com.example.learnchinese.data;

import android.net.Uri;
import android.provider.BaseColumns;

/* WordContract is to help provide the column names with ease, as well as defining
    the content uri used by the Cursor Loader.
    This content URI tells us what provider to use (WordProvider, in this case)
    and the path to the table we'll be querying
 */
public final class WordContract {

    public static final String CONTENT_AUTHORITY = "com.example.learnchinese.data"; // authority defines the provider

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_WORDS = "words";


    // We don't want an instance of this class, it's just a helper class for db queries
    private WordContract() {}

    public static final class WordEntry implements BaseColumns {

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_WORDS); // used by cursor loader

        // Name of database table for words
        public final static String TABLE_NAME = "words";

        // Row identifier
        public final static String _ID = BaseColumns._ID;

        // English name
        public final static String COLUMN_ENG_NAME = "engName";

        // Pinyin
        public final static String COLUMN_PINYIN = "pinyin";

        // Chinese character
        public final static String COLUMN_CHN_CHAR = "chnChar";

        // Identifier for image resource for the vocab ListView
        public final static String COLUMN_IMAGE_ID = "imageID";

        // Identifier for the sound resource for button "play" for the vocab ListView
        public final static String COLUMN_SOUND_ID = "soundID";

        // Category of the word (people, animals, etc.)
        public final static String COLUMN_CATEGORY = "category";


    }

}
