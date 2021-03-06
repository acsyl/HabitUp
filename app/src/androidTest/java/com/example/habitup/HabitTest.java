package com.example.habitup;

import android.support.test.espresso.core.deps.guava.primitives.Booleans;
import android.support.test.runner.AndroidJUnit4;

import com.example.habitup.Model.Habit;
import com.example.habitup.Model.Attributes;
import com.example.habitup.Model.HabitEvent;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.assertFalse;

public class HabitTest {

    //Test Habit construction error long name
    public void testHabitConstLongNameErr() {
        String name = "123456789abcdefjhijklmnop";
        String reason = "I wanna be the very best";
        String attribute = "Mental";
        Boolean t = Boolean.TRUE;

        try{
            Habit testHabit = new Habit(name,t,t,t,t,t,t,t,reason,attribute);
        }
        catch (IllegalArgumentException err) {
            assertTrue(Boolean.TRUE);
            return;
        }
        assertTrue(Boolean.FALSE); //failed to reproduce the error
    }

    //Test Habit construction error long reason
    public void testHabitConstLongReasonErr(){
        String name = "name";
        String reason = "123456789123456789123456789101010";
        String attribute = "Mental";
        Boolean t = Boolean.TRUE;

        try{
            Habit testHabit = new Habit(name,t,t,t,t,t,t,t,reason,attribute);
        }
        catch (IllegalArgumentException err) {
            assertTrue(Boolean.TRUE);
            return;
        }
        assertTrue(Boolean.FALSE); //failed to reproduce the error
    }

    //Test Habit construction error no schedule
    public void testHabitConstSchedErr(){
        String name = "name";
        String reason = "I wanna be the very best";
        String attribute = "Mental";
        Boolean t = Boolean.TRUE;
        Boolean f = Boolean.FALSE;

        try{
            Habit testHabit = new Habit(name,f,f,f,f,f,f,f,reason,attribute);
        }
        catch (IllegalStateException err) {
            assertTrue(Boolean.TRUE);
            return;
        }
        assertTrue(Boolean.FALSE); //failed to reproduce the error
    }

    //Test setHabitName actually sets/replaces the name
    public void testSetHabitNameSuccess() {
        String name = "name";
        String habitName = "sampleHabit";
        String reason = "I wanna be the very best";
        String attribute = "Mental";
        Boolean t = Boolean.TRUE;
        Habit testHabit = new Habit(name,t,t,t,t,t,t,t,reason,attribute);

        testHabit.setHabitName(habitName);

        assertTrue(testHabit.getHabitName() == habitName); //check for match
    }

    //Tests that setHabitName does not accept the same name of an existing habit
    public void testSetHabitNameErr(){
        String name = "name";
        String habitName = "sampleHabit";
        String reason = "I wanna be the very best";
        String attribute = "Mental";
        Boolean t = Boolean.TRUE;
        Habit testHabit = new Habit(name,t,t,t,t,t,t,t,reason,attribute);
        Habit testHabit2 = new Habit(habitName,t,t,t,t,t,t,t,reason,attribute);

        try{
            testHabit2.setHabitName(name);
        }
        catch (IllegalStateException err) {
            assertTrue(Boolean.TRUE);
            return;
        }
        assertTrue(Boolean.FALSE); //failed to reproduce error (same as testHabit)
    }

    //Tests setHabitName to not exceed 20 characters, expects an error
    public void testHabitNameLength() {
        String name = "name";
        String habitName = "123456789abcdefghijklmnop";
        String reason = "I wanna be the very best";
        String attribute = "Mental";
        Boolean t = Boolean.TRUE;
        Habit testHabit = new Habit(name,t,t,t,t,t,t,t,reason,attribute);

        try{
            testHabit.setHabitName(habitName);
        }
        catch (IllegalArgumentException err) {
            assertTrue(Boolean.TRUE);
            return;
        }

        assertTrue(Boolean.FALSE); //failed to replicate the error
    }

    //Tests that setReason sets
    public void testSetReason() {
        String name = "name";
        String reason = "reason";
        String reason2 = "I wanna be the very best";
        String attribute = "Mental";
        Boolean t = Boolean.TRUE;
        Habit testHabit = new Habit(name,t,t,t,t,t,t,t,reason,attribute);

        testHabit.setReason(reason2);

        assertTrue(testHabit.getHabitReason() == reason2); //check if habit reason matches
    }

    //Tests setReason to not exceed 30 characters, expecting an error
    public void testSetReasonLength() {
        String name = "name";
        String habitName = "sampleHabit";
        String reason = "I wanna be the very best";
        String reason2 = "123456789123456789123456789101010";
        String attribute = "Mental";
        Boolean t = Boolean.TRUE;
        Habit testHabit = new Habit(name,t,t,t,t,t,t,t,reason,attribute);

        try{
            testHabit.setReason(reason2);
        }
        catch (IllegalArgumentException err) {
            assertTrue(Boolean.TRUE);
            return;
        }
        assertTrue(Boolean.FALSE); //failed to replicate error
    }

    //Tests setSchedule sets
    public void testSetSchedule(){
        String name = "name";
        String reason = "I wanna be the very best";
        String attribute = "Mental";
        Boolean t = Boolean.TRUE;
        Boolean f = Boolean.FALSE;
        Habit testHabit = new Habit(name,t,t,t,t,t,t,t,reason,attribute);

        testHabit.setSchedule(f,f,f,f,f,f,t);

        assertTrue(testHabit.getHabitSchedule()== "Saturday "); //check if schedule was set to Saturday
    }

    //Test setAttribute actually sets an attribute
    public void testSetAttribute(){
        String name = "name";
        String reason = "I wanna be the very best";
        String attribute = "Mental";
        String attribute2 = "Physical";
        Boolean t = Boolean.TRUE;
        Habit testHabit = new Habit(name,t,t,t,t,t,t,t,reason,attribute);

        testHabit.setAttribute(attribute2);
        assertTrue(testHabit.getHabitAttribute()== attribute2); //check attribute match
    }

    //Tests addHabitEvent adds a HabitEvent to the Habit
    public void testAddHabitEvent(){
        HabitEvent habitEvent = new HabitEvent();
        String name = "name";
        String reason = "I wanna be the very best";
        String attribute = "Mental";
        Boolean t = Boolean.TRUE;
        Habit testHabit = new Habit(name,t,t,t,t,t,t,t,reason,attribute);

        testHabit.addHabitEvent(habitEvent);
        assertTrue(testHabit.getHabitEvents().contains(habitEvent));
        //checks if habitEvent was added onto the initially empty ArrayList
    }

    //Tests removeHabitEvent if it successfully removes a habitEvent
    public void testRemoveHabitEvent(){
        HabitEvent habitEvent = new HabitEvent();
        String name = "name";
        String reason = "I wanna be the very best";
        String attribute = "Mental";
        Boolean t = Boolean.TRUE;
        Habit testHabit = new Habit(name,t,t,t,t,t,t,t,reason,attribute);

        testHabit.addHabitEvent(habitEvent); //assuming addHabitEvent works
        testHabit.removeHabitEvent(habitEvent);

        assertFalse(testHabit.getHabitEvents().contains(habitEvent));
        //checks that habitEvent is missing
    }

}
