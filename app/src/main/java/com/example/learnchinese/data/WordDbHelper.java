package com.example.learnchinese.data;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import android.util.Log;


/**
 * Database helper for LearnChinese app. Manages database creation and version management.
 */
public class WordDbHelper extends SQLiteOpenHelper
{
    private static String TAG = "DataBaseHelper"; // Tag for logging
    private static String DB_PATH = ""; // Path to internal database on mobile device, differs by OS version
    private static String DB_NAME ="words.db"; // Database name
    private static int VERSION = 1; // Do not downgrade. Increasing database version will update database on mobile device
    private final Context mContext;


    // Fetches the input database location according to android OS version
    public WordDbHelper(Context context)
    {
        super(context, DB_NAME, null, VERSION); //
        if(android.os.Build.VERSION.SDK_INT >= 17){
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        }
        else
        {
            DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        }
        this.mContext = context;

        createDataBase();
    }


    // Use when database is first created
    public void createDataBase()
    {
        // If the database does not exist, copy it from the assets folder
        boolean mDataBaseExist = checkDataBase();
        if(!mDataBaseExist)
        {
            this.getReadableDatabase();
            this.close();
            try
            {
                // Copy the database from assets
                copyDataBase();
                Log.e(TAG, "createDatabase database created");
            }
            catch (IOException mIOException)
            {
                throw new Error("ErrorCopyingDataBase");
            }
        }

    }


    // Check for database existence
    private boolean checkDataBase()
    {
        File dbFile = new File(DB_PATH + DB_NAME);
        return dbFile.exists();
    }

    // Copy the database from the assets folder (should only do this first time app was opened)
    // This is also called when the version updates to copy the updated database to the mobile device
    private void copyDataBase() throws IOException
    {
        InputStream mInput = mContext.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream mOutput = new FileOutputStream(outFileName);
        byte[] mBuffer = new byte[1024];
        int mLength;
        while ((mLength = mInput.read(mBuffer))>0)
        {
            mOutput.write(mBuffer, 0, mLength);
        }
        mOutput.flush();
        mOutput.close();
        mInput.close();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    // Called when this version > version on mobile device
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            copyDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}