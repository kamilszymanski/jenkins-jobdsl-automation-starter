package com.twitter.kszdev.jenkins.jobdsl

import javaposse.jobdsl.dsl.GeneratedItems

trait WithGeneratedItems {

    Set getGeneratedJobsFrom(GeneratedItems generatedItems) {
        return generatedItems.jobs*.jobName
    }

    Set getGeneratedViewsFrom(GeneratedItems generatedItems) {
        return generatedItems.views*.name
    }
}
