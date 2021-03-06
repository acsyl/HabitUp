package com.example.habitup;

import android.support.test.runner.AndroidJUnit4;

import com.example.habitup.Model.HabitEvent;
import com.example.habitup.Model.Map;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.GregorianCalendar;

import static junit.framework.Assert.assertTrue;

/**
 * @author acysl
 *
 * Modified by @gojeffcho 2017-10-22
 */
@RunWith(AndroidJUnit4.class)
public class HabitEventTest {

    @Test
    public void testHabitEventSetterGetter() {
        HabitEvent event1 = new HabitEvent();
        event1.setCompletedate(new GregorianCalendar(2017, 10, 2, 15, 16, 17));
        event1.setLocation(new Map());
        event1.setPathofimage("/Users/abcdefg");
        event1.setComment("abcdef");
        try {
            GregorianCalendar date1 = new GregorianCalendar(2017, 10, 2, 15, 16, 17);
            Map location1 = new Map();
            assertTrue(event1.getLocation().equals(location1));
            assertTrue((event1.getCompletedate()).compareTo(date1) == 0);
            assertTrue(event1.getImage() != null);
            assertTrue(event1.getComment().equals("abcdef"));
        } catch (Exception e) {
            assertTrue(Boolean.FALSE);
            return;
        }

        assertTrue(Boolean.TRUE);
    }

    @Test
    public void testCommentLimited(){
        String c1 = "saasdfaskfdasfasfsafsafasfavsadfsdfsa";
        HabitEvent event1 = new HabitEvent();
        try {
            event1.setComment(c1);

        } catch (IllegalArgumentException e){
            assertTrue(Boolean.TRUE);
            return;
        }

        assertTrue(Boolean.FALSE);
    }

    @Test
    public void testCompleteDateRestrict(){
        GregorianCalendar date1 = new GregorianCalendar(2016, 10, 2, 15, 16, 17);
        HabitEvent event2 = new HabitEvent();
        try {
            event2.setCompletedate(date1);
        } catch (IllegalArgumentException e){
            assertTrue(Boolean.TRUE);
            return;
        }

        assertTrue(Boolean.FALSE);
    }

}






