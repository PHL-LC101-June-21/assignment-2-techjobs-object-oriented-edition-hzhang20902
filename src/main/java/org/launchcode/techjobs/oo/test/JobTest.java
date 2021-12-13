package org.launchcode.techjobs.oo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    Job test_job;

    @Before
    public void createJobObject(){
        test_job = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId(){
        Job job_Empty_Constructor = new Job();
        Job job_Empty_Cons_2 = new Job();
        assertNotEquals(job_Empty_Constructor.getId(), job_Empty_Cons_2.getId());

    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job newTestJob = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        assertTrue(newTestJob.getName() instanceof String);
        assertTrue(newTestJob.getEmployer() instanceof Employer);
        assertTrue(newTestJob.getLocation() instanceof Location);
        assertTrue(newTestJob.getPositionType() instanceof PositionType);
        assertTrue(newTestJob.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Product tester" , newTestJob.getName());
        assertEquals("ACME" , newTestJob.getEmployer().toString());
        assertEquals("Desert" , newTestJob.getLocation().toString());
        assertEquals("Quality control" , newTestJob.getPositionType().toString());
        assertEquals("Persistence" , newTestJob.getCoreCompetency().toString());

    }

    @Test
    public void testJobsForEquality(){
        Job test1 =  new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        Job test2 =  new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        assertFalse(test1.equals(test2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job testLineSpace = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        char spaceN = '\n';
        String testString = testLineSpace.toString();
        int endLineSpace = testString.length();
        int endSpaceIndex = (endLineSpace-1);
        assertEquals(spaceN, testString.charAt(0));
        assertEquals(spaceN, testString.charAt(endSpaceIndex));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job testLabels = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        String testString = testLabels.toString();
        String[] arrOfStr = testString.split("\n");
        ArrayList<String> arrListOfStr = new ArrayList<String>(Arrays.asList(arrOfStr));
        for (int i = 0; i < arrListOfStr.size(); i++) {
            if (!arrListOfStr.get(i).isEmpty()) {
                arrListOfStr.set(i, arrListOfStr.get(i).substring(0, (arrListOfStr.get(i).length())));
            }
        }
        assertEquals("ID: " + testLabels.getId(), arrListOfStr.get(1));
        assertEquals("Name: " + testLabels.getName(), arrListOfStr.get(2));
        assertEquals("Employer: " + testLabels.getEmployer(), arrListOfStr.get(3));
        assertEquals("Location: " + testLabels.getLocation(), arrListOfStr.get(4));
        assertEquals("Position Type: " + testLabels.getPositionType(), arrListOfStr.get(5));
        assertEquals("Core Competency: " + testLabels.getCoreCompetency(), arrListOfStr.get(6));
   //     System.out.println(testString);

        }

    @Test
    public void testToStringHandlesEmptyField(){
        Job testDataNot = new Job( "Yea",new Employer(""),
                new Location("Desert"), new PositionType(""),
                new CoreCompetency("Persistence"));

        String strWithMissing = testDataNot.toString();
        assertEquals(
                "\n" + "ID: " + testDataNot.getId() + "\nName: Yea" +
                        "\nEmployer: Data not available" +
                "\nLocation: Desert" + "\nPosition Type: Data not available" +
                        "\nCore Competency: Persistence" + "\n"
                , strWithMissing);

        System.out.println(strWithMissing);
    }

    @Test
    public void testBonus(){
        Job testEmpty = new Job( "",new Employer(""),
                new Location(""), new PositionType(""),
                new CoreCompetency(""));

        String testString = testEmpty.toString();

        assertEquals( "OOPS! This job does not seem to exist.", testString);

        System.out.println(testString);
    }


}

