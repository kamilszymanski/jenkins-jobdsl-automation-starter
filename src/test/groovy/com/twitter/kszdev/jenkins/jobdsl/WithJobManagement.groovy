package com.twitter.kszdev.jenkins.jobdsl

import javaposse.jobdsl.dsl.GeneratedItems
import javaposse.jobdsl.dsl.JobManagement

trait WithJobManagement {

    abstract JobManagement getJobManagement()

    String getGeneratedConfigFor(String jobName) {
        return jobManagement.getConfig(jobName)
    }

    Map<String, String> getGeneratedConfigs(GeneratedItems generatedItems) {
        return generatedItems.jobs*.jobName.collectEntries {
            [(it): jobManagement.getConfig(it)]
        }
    }
}
