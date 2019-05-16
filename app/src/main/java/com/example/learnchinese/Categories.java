package com.example.learnchinese;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Categories {

    private Categories() {}

    public static ArrayList<String> GetCategories() {
        ArrayList<String> categories = new ArrayList<>(Arrays.asList(
                "People",
                "Animals"));
        return categories;
    }
}
