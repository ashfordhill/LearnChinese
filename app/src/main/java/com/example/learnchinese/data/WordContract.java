package com.example.learnchinese.data;

import android.net.Uri;
import android.provider.BaseColumns;

public final class WordContract {

    public static final String CONTENT_AUTHORITY = "com.example.learnchinese";

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_WORDS = "words";


    // We don't want an instance of this class, it's just a helper class for db queries
    private WordContract() {}

    public static final class WordEntry implements BaseColumns {

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_WORDS);

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

        public final static String COLUMN_CATEGORY = "category";


    }

}
