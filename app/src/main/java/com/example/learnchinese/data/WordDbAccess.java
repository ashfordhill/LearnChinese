package com.example.learnchinese.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


/* Helper Singleton class to make sure there is only one instance of WordDbHelper */
public class WordDbAccess {

    private WordDbHelper dbHelper;
    private SQLiteDatabase database;
    private static WordDbAccess instance;
    private Context context;

    private WordDbAccess() {}


    public void init(Context context){
        if(context == null){
            this.context = context;
            this.dbHelper = new WordDbHelper(context);
        }
    }

    private Context getContext(){
        return context;
    }

    public static WordDbAccess getInstance() {
        if(instance == null) {
            instance = new WordDbAccess();
        }
        return instance;
    }

    public WordDbHelper getDbHelper() {

        return getInstance().getHelper();
    }

    private WordDbHelper getHelper() {
        return dbHelper;
    }


    public static Context get(){
        return getInstance().getContext();
    }

}
