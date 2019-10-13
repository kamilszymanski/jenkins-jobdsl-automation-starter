package com.twitter.kszdev.jenkins.jobdsl.job

import com.twitter.kszdev.jenkins.jobdsl.JenkinsDslSpecBase
import com.twitter.kszdev.jenkins.jobdsl.WithGeneratedItems

class SampleJobsSpec extends JenkinsDslSpecBase implements WithGeneratedItems {

    private static final String DSL_SCRIPT_FILE = 'samples.groovy'
    private static final String JOB_NAME = 'sample-job'

    def 'should clean workspace on failed build'() {
        when:
            scriptLoader.runScript(getDslScript(DSL_SCRIPT_FILE))
        then:
            getWorkspaceCleanupConfigForJob(JOB_NAME).cleanWhenFailure.text() == 'true'
    }

    def 'should not clean workspace on successful build'() {
        when:
            scriptLoader.runScript(getDslScript(DSL_SCRIPT_FILE))
        then:
            getWorkspaceCleanupConfigForJob(JOB_NAME).cleanWhenSuccess.text() == 'false'
    }

    private def getWorkspaceCleanupConfigForJob(String jobName) {
        def xmlConfig = new XmlSlurper().parseText(getGeneratedConfigFor(jobName))
        return xmlConfig.publishers
                .'hudson.plugins.ws__cleanup.WsCleanup'
    }
}
