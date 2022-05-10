package org.launchcode.techjobs.oo.Tests;

import com.sun.source.tree.AssertTree;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.launchcode.techjobs.oo.*;

public class jobTest {
    Job jobOne;
    Job jobTwo;
    Job jobFull;
    Job jobCOne;
    Job jobCTwo;
    Job jobStringTestR1;
    Job jobStringTestR2;

    @Before
    public void settingJobObjects(){
        jobOne = new Job();
        jobTwo = new Job();
        jobFull = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        jobCOne = new Job("Manager", new Employer("Sears"),new Location("O'Fallon"), new PositionType("Management"), new CoreCompetency("Reliability"));
        jobCTwo = new Job("Manager", new Employer("Sears"),new Location("O'Fallon"), new PositionType("Management"), new CoreCompetency("Reliability"));
        jobStringTestR1 = new Job("",new Employer(""),new Location(""),new PositionType(""),new CoreCompetency(""));
        jobStringTestR2 = new Job("Person",new Employer(""),new Location(""),new PositionType(""),new CoreCompetency(""));
    }
    @Test
    public void testSettingJobId(){
        assertTrue(jobOne instanceof  Job);
        assertFalse(jobOne.equals(jobTwo));
        assertEquals(jobOne.getId(), jobTwo.getId() - 1);
    }

    @Test
    public void testJobConstructorSetsALlFields(){
        assertEquals(jobFull.getName(), "Product tester");
        assertEquals(jobFull.getEmployer().getValue(), new Employer("ACME").getValue());
        assertEquals(jobFull.getLocation().getValue(), new Location("Desert").getValue());
        assertEquals(jobFull.getPositionType().getValue(), new PositionType("Quality control").getValue());
        assertEquals(jobFull.getCoreCompetency().getValue(), new CoreCompetency("Persistence").getValue());
        assertFalse(jobFull.equals(jobTwo));
        assertFalse(jobFull.equals(jobOne));
    }
    @Test
    public void testJobsForEquality(){
        assertFalse(jobCOne.equals(jobCTwo));
    }

    @Test
    public void toStringToFail(){
        assertEquals(jobFull.toString(),
                        "\n" +
                        "ID: " + jobFull.getId() + "\n" +
                        "Name: " + jobFull.getName() + "\n" +
                        "Employer: " + jobFull.getEmployer().getValue() + "\n" +
                        "Location: " + jobFull.getLocation().getValue() + "\n" +
                        "Position Type: " + jobFull.getPositionType().getValue() + "\n" +
                        "Core Competency: " + jobFull.getCoreCompetency().getValue() + "\n");

        assertEquals(jobStringTestR1.toString(), "OOPS! This job does not seem to exist.");
        assertNotEquals(jobStringTestR1.toString(), "EEPS! This job does not seme to exist.");
        assertNotEquals(jobStringTestR2.toString(),"OOPS! This job does not seem to exist.");
    }
}
