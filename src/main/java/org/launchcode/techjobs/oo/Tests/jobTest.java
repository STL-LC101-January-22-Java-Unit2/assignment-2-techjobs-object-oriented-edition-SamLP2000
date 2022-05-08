package org.launchcode.techjobs.oo.Tests;

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

    @Before
    public void settingJobObjects(){
        jobOne = new Job();
        jobTwo = new Job();
        jobFull = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        jobCOne = new Job("Manager", new Employer("Sears"),new Location("O'Fallon"), new PositionType("Management"), new CoreCompetency("Reliability"));
        jobCTwo = new Job("Manager", new Employer("Sears"),new Location("O'Fallon"), new PositionType("Management"), new CoreCompetency("Reliability"));
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

}
