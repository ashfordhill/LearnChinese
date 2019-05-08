package com.example.learnchinese.data;


import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.learnchinese.R;

import java.lang.reflect.Field;


/**
 * {@link WordCursorAdapter} is an adapter for a list or grid view
 * that uses a {@link Cursor} of word data as its data source. This adapter knows
 * how to create list items for each row of word data in the {@link Cursor}.
 */
public class WordCursorAdapter extends CursorAdapter {

    /**
     * Constructs a new {@link WordCursorAdapter}.
     *
     * @param context The context
     * @param c       The cursor from which to get the data.
     */
    public WordCursorAdapter(Context context, Cursor c) {
        super(context, c, 0 /* flags */);
    }

    /**
     * Makes a new blank list item view. No data is set (or bound) to the views yet.
     *
     * @param context app context
     * @param cursor  The cursor from which to get the data. The cursor is already
     *                moved to the correct position.
     * @param parent  The parent to which the new view is attached to
     * @return the newly created list item view.
     */
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        // Inflate a list item view using the layout specified in list_item_view.xml
        return LayoutInflater.from(context).inflate(R.layout.list_item_view, parent, false);
    }

    /**
     * This method binds the word data (in the current row pointed to by cursor) to the given
     * list item layout.
     *
     * @param view    Existing view, returned earlier by newView() method
     * @param context app context
     * @param cursor  The cursor from which to get the data. The cursor is already moved to the
     *                correct row.
     */
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Find individual views that we want to modify in the list item layout
        TextView engNameTextView = (TextView) view.findViewById(R.id.english_name);
        TextView pinyinTextView = (TextView) view.findViewById(R.id.pinyin);
        ImageView icon = (ImageView) view.findViewById(R.id.word_icon_image);
        Button soundButton = (Button) view.findViewById(R.id.word_sound_button);

        // Find the columns of attributes that we're interested in
        int engNameColumnIndex = cursor.getColumnIndex(WordContract.WordEntry.COLUMN_ENG_NAME);
        int pinyinColumnIndex = cursor.getColumnIndex(WordContract.WordEntry.COLUMN_PINYIN);
        int chnCharColumnIndex = cursor.getColumnIndex(WordContract.WordEntry.COLUMN_CHN_CHAR);
        int imageIDColumnIndex = cursor.getColumnIndex(WordContract.WordEntry.COLUMN_IMAGE_ID);
        int soundIDColumnIndex = cursor.getColumnIndex(WordContract.WordEntry.COLUMN_SOUND_ID);


        // Read the attributes from the Cursor for the current word
        String english = cursor.getString(engNameColumnIndex);
        String pinyin = cursor.getString(pinyinColumnIndex);
        String chnChar = cursor.getString(chnCharColumnIndex);
        String imageID = cursor.getString(imageIDColumnIndex);
        String soundID = cursor.getString(soundIDColumnIndex);


        // Update the TextViews with the attributes for the current word
        engNameTextView.setText(english);
        pinyinTextView.setText(pinyin);
        int res = context.getResources().getIdentifier("test_icon", "Drawable", context.getPackageName());

        // Update image view
        icon.setImageResource(getId("test_icon", R.drawable.class));

        // Update button view w/ sound player
        soundButton.setText(chnChar);

        final MediaPlayer mp = MediaPlayer.create(context, R.raw.soundbit);
        soundButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mp.start();

            }
        });

    }

    public static int getId(String resourceName, Class<?> c) {
        try {
            Field idField = c.getDeclaredField(resourceName);
            return idField.getInt(idField);
        } catch (Exception e) {
            throw new RuntimeException("No resource ID found for: "
                    + resourceName + " / " + c, e);
        }
    }
}