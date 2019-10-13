package com.twitter.kszdev.jenkins.jobdsl.job

import com.twitter.kszdev.jenkins.jobdsl.JenkinsDslSpecBase
import com.twitter.kszdev.jenkins.jobdsl.WithGeneratedItems
import javaposse.jobdsl.dsl.GeneratedItems

class SamplesSpec extends JenkinsDslSpecBase implements WithGeneratedItems {

    private static final String DSL_SCRIPT_FILE = 'samples.groovy'

    def 'should generate all defined jobs'() {
        given:
            Set expectedJobs = ['sample-job']
        when:
            GeneratedItems generatedItems = scriptLoader.runScript(getDslScript(DSL_SCRIPT_FILE))
        then:
            getGeneratedJobsFrom(generatedItems) == expectedJobs
    }

    def 'should generate all defined views'() {
        given:
            Set expectedViews = ['sample-view']
        when:
            GeneratedItems generatedItems = scriptLoader.runScript(getDslScript(DSL_SCRIPT_FILE))
        then:
            getGeneratedViewsFrom(generatedItems) == expectedViews
    }
}
