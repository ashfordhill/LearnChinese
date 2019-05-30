package com.example.learnchinese.VocabReviewMenu;

import android.app.Activity;

import com.example.learnchinese.VocabReviewActivities.AnimalsActivity;
import com.example.learnchinese.VocabReviewActivities.FoodActivity;
import com.example.learnchinese.VocabReviewActivities.NumbersActivity;
import com.example.learnchinese.VocabReviewActivities.PeopleActivity;
import com.example.learnchinese.VocabReviewActivities.PlacesActivity;

/* Returns the categories option as a class with the help of Categories.java */
public class ClassTranslater {

    private ClassTranslater() {}

    public static Class<?> GetClass(String className) {
        Class<?> c = null;

        switch(className.toUpperCase()) {
            case("PEOPLE"):
                c = PeopleActivity.class;
                break;
            case("ANIMALS"):
                c = AnimalsActivity.class;
                break;
            case("PLACES"):
                c = PlacesActivity.class;
                break;
            case("NUMBERS"):
                c = NumbersActivity.class;
                break;
            case("FOOD"):
                c = FoodActivity.class;
                break;
            default:
                c = PeopleActivity.class;
                break;
        }

        return c;
    }
}
