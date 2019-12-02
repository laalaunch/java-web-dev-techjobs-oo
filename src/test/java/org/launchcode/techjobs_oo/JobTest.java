package org.launchcode.techjobs_oo;

import org.junit.Before;
import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.*;

public class JobTest {

    private int test_id1;
    private int test_id2;

    @Before
    public void setUp() throws Exception {
        test_id1 = new Job().hashCode();
        test_id2 = new Job().hashCode();
    }

    @Test
    public void testSettingJobId() {
        int result = test_id2 - test_id1;
        assertEquals("Unique Job Ids should differ by 1", 1, result);
    }
    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("Product tester", job.getName());
        assertEquals("ACME", job.getEmployer().getValue());
        assertEquals("Desert", job.getLocation().getValue());
        assertEquals("Quality control", job.getPositionType().getValue());
        assertEquals("Persistence", job.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job job_1 = new Job ("Coder", new Employer("Lazer"), new Location("Boston"), new PositionType("Tester"), new CoreCompetency("Angular"));
        Job job_2 = new Job ("Coder", new Employer("Lazer"), new Location("Boston"), new PositionType("Tester"), new CoreCompetency("Angular"));
        assertFalse(job_1.equals(job_2));
    }

    @Test
    public void testJobsEmptyOutput() {
        Job job = new Job ("Coder", new Employer(""), new Location(""), new PositionType("Tester"), new CoreCompetency("Agile"));

        if (job.getName().isEmpty()) {
            job.setName("Data not available");
        }
        if (job.getEmployer().getValue().isEmpty()) {
            job.setEmployer(new Employer("Data not available"));
        }
        if (job.getLocation().getValue().isEmpty()) {
            job.setLocation(new Location("Data not available"));
        }
        if (job.getPositionType() == null) {
            job.setPositionType(new PositionType("Data not available"));
        }
        if (job.getCoreCompetency() == null) {
            job.setCoreCompetency(new CoreCompetency("Data not available"));
        }

            String expected = "\n" +
                    "ID: " + job.hashCode() + '\n' +
                    "Name: " + job.getName() + '\n' +
                    "Employer: " + job.getEmployer().getValue() + '\n' +
                    "Location: " + job.getLocation().getValue() + '\n' +
                    "Position Type: " + job.getPositionType() + '\n' +
                    "Core Competency: " + job.getCoreCompetency() + '\n' +
                    "";

            assertEquals(expected, job.toString());
    }
}