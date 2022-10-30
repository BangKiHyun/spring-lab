package com.lab.springlab.quartz.job.trigger;

import org.quartz.Trigger;

public interface JobTrigger {
    Trigger buildTrigger();
}
