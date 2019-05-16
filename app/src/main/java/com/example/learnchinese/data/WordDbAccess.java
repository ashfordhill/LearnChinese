package com.example.learnchinese.data;

import android.content.Context;


/* Helper Singleton class to make sure there is only one instance of WordDbHelper */
public class WordDbAccess {

    private WordDbHelper openHelper;
    private static WordDbAccess instance;

    private WordDbAccess(Context context) {
        this.openHelper = new WordDbHelper(context);
    }

    public static WordDbAccess getInstance(Context context) {
        if(instance == null) {
            instance = new WordDbAccess(context);
        }
        return instance;
    }

    public WordDbHelper getDbHelper() {
        return this.openHelper;
    }

}
