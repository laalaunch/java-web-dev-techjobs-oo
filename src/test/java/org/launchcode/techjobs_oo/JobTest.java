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
}