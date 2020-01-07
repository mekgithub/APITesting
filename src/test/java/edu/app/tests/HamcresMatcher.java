package edu.app.tests;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class HamcresMatcher {
    @Test
    public void test(){
        assertThat(5, equalTo(5));
        String str1 = "sdet";
        String str2 = "sdet";
        assertThat(str1, is("sdet"));
        assertThat(str1, is(str2));
        //verify if it is not equal
        assertThat(str1, is(not("qa")));
        //verifying ignoring case
        assertThat(str1, equalToIgnoringCase("SdeT"));
        //verifying ignoring space before and after
        assertThat(str1, equalToIgnoringWhiteSpace("sdet"));

        //compare number
        assertThat(5, greaterThan(3));
        assertThat(8, lessThan(10));
        assertThat(7, lessThanOrEqualTo(8));
        //checking if the value is null or not
        assertThat(str1, notNullValue());
        List<String> list= Arrays.asList("key","store","order");
        assertThat(list, Matchers.<String>hasSize(3));
        //compare if the list contains in any order
        assertThat(list, containsInAnyOrder("store","order","key"));
        //verify if the list contains single item
        assertThat(list, hasItem("key"));
        //compares if multiple items exists in the list
        assertThat(list, hasItems("key", "store"));
        List<Integer> nums=Arrays.asList(5,8,10);
        assertThat(nums, everyItem(greaterThan(4)));
        assertThat(nums, everyItem(lessThan(16)));
        assertThat(nums, everyItem(lessThan(15)));

    }
}
