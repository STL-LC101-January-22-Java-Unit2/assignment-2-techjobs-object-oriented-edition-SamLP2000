package org.launchcode.techjobs.oo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
        Job jobFull = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job jobFullCopy = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job jobCOne = new Job("Manager", new Employer("Sears"),new Location("O'Fallon"), new PositionType("Management"), new CoreCompetency("Reliability"));
        Job jobCTwo = new Job("Manager", new Employer("Sears"),new Location("O'Fallon"), new PositionType("Management"), new CoreCompetency("Reliability"));
        Job jobStringTestR1 = new Job("",new Employer(""),new Location(""),new PositionType(""),new CoreCompetency(""));
        Job jobStringTestR2 = new Job("Person",new Employer(""),new Location(""),new PositionType(""),new CoreCompetency(""));
        @Test
        public void testSettingJobId(){
            Job jobOne = new Job();
            Job jobTwo = new Job();
        }

        @Test
        public void testJobConstructorSetsAllFields(){
            Job jobEx = new Job();
            Job jobExTwo = new Job();

            assertEquals(jobFull.getName(), "Product tester");
            assertEquals(jobFull.getEmployer().getValue(), new Employer("ACME").getValue());
            assertEquals(jobFull.getLocation().getValue(), new Location("Desert").getValue());
            assertEquals(jobFull.getPositionType().getValue(), new PositionType("Quality control").getValue());
            assertEquals(jobFull.getCoreCompetency().getValue(), new CoreCompetency("Persistence").getValue());

            assertTrue((jobFull.getId() != jobExTwo.getId()));
            assertTrue(jobFull.getId() != jobEx.getId());
            assertTrue(jobFull.getId() >= 1);
            assertTrue(jobFull.getClass().toString().equals("class org.launchcode.techjobs.oo.Job"));
            assertTrue(jobFull.getId() < jobEx.getId());
            assertTrue(!new Job().equals(new Job()));
        }

        @Test
        public void testToStringContainsCorrectLabelsAndData(){
            assertNotEquals(jobFull.toString(),jobFullCopy.toString());
            assertEquals(jobFull.getEmployer().getValue().toString(),jobFullCopy.getEmployer().getValue().toString());
        }

        @Test
        public void testToStringHandlesEmptyField(){
            assertEquals("OOPS! This job does not seem to exist.", jobStringTestR1.toString());
            assertNotEquals(jobStringTestR1.toString(), "EEPS! This job does not seme to exist.");
            assertNotEquals(jobStringTestR2.toString(),"OOPS! This job does not seem to exist.");
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

        }

        @Test
        public void testToStringStartsAndEndsWithNewLine() {
            // https://stackoverflow.com/questions/5518451/check-if-string-contains-n-java/

            Job job = new Job("Job",new Employer("Store"),new Location("Town"),new PositionType("Manager"),new CoreCompetency("Reliability"));
            char jobFirst  = job.toString().charAt(0);
            char jobLast = job.toString().charAt(job.toString().length()-1);
            assertEquals(jobFirst, '\n');
            assertEquals(jobLast, '\n');
        }
}


