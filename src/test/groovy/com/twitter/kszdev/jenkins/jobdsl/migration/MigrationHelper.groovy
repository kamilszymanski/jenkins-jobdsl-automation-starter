package com.twitter.kszdev.jenkins.jobdsl.migration

import com.twitter.kszdev.jenkins.jobdsl.JenkinsDslSpecBase
import com.twitter.kszdev.jenkins.jobdsl.WithConfigXmlDiff
import spock.lang.Requires

class MigrationHelper extends JenkinsDslSpecBase implements WithConfigXmlDiff {

    private static final String MIGRATION_TARGET_RESOURCES_PATH = 'migration-targets'

    @Requires({ Boolean.valueOf(env['runDslMigrationTests']) })
    def 'generated configuration should match expected one'() {
        given:
            String dslScriptFile = 'samples.groovy'
            String jobName = 'sample-job'
        when:
            scriptLoader.runScript(getDslScript(dslScriptFile))
        then:
            assertGeneratedConfigMatches(jobName, getGeneratedConfigFor(jobName), getExpectedConfigFor(jobName))
    }

    private static String getExpectedConfigFor(String job) {
        return this.class.getResource("/${MIGRATION_TARGET_RESOURCES_PATH}/${job}.xml").text
    }
}
