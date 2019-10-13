package com.twitter.kszdev.jenkins.jobdsl.configxml

import com.twitter.kszdev.jenkins.jobdsl.JenkinsDslSpecBase
import com.twitter.kszdev.jenkins.jobdsl.WithConfigXmlDiff
import javaposse.jobdsl.dsl.GeneratedItems
import spock.lang.Unroll

class ConfigXmlEqualitySpec extends JenkinsDslSpecBase implements WithConfigXmlDiff, WithExpectedConfigsSources {

    @Unroll
    def 'configurations generated from #dslScriptFile DSL script should match expected ones'() {
        when:
            GeneratedItems generatedItems = scriptLoader.runScript(getDslScript(dslScriptFile))
        then:
            assertGeneratedConfigsMatch(getGeneratedConfigs(generatedItems), expectedConfigsDirectory)
        where:
            dslScriptFile << ['samples.groovy']
    }
}
