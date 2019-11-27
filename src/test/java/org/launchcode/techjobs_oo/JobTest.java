package org.launchcode.techjobs_oo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {

    @Test
    public void testSettingJobId() {
        Job id1 = new Job();
        Job id2 = new Job();
        int job_id1 = id1.hashCode();
        int job_id2 = id2.hashCode();

        assertEquals(job_id1, job_id2, 1.0);
    }

}