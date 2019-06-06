package com.example.learnchinese.data;

import java.util.ArrayList;
import java.util.Arrays;

/* Class to help return the available categories and match them within the ClassTranslator.java
        Order matters - vocab review menu will show in order of index
 */

public class Categories {

    private Categories() {}

    public static ArrayList<String> GetCategories() {
        ArrayList<String> categories = new ArrayList<>(Arrays.asList(
                "Numbers",
                "Places",
                "People",
                "Food",
                "Animals"));
        return categories;
    }
}
