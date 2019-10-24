package com.twitter.kszdev.jenkins.jobdsl.configxml

import com.twitter.kszdev.jenkins.jobdsl.JenkinsDslSpecBase
import javaposse.jobdsl.dsl.GeneratedItems
import spock.lang.Requires
import spock.lang.Unroll

class ExpectedXmlConfigGenerator extends JenkinsDslSpecBase implements WithExpectedConfigsSources {

    @Unroll
    @Requires({ Boolean.valueOf(env['persistUpdatedXmlConfigs']) })
    def 'should generate updated XML configs for #dslScriptFile DSL script'() {
        when:
            GeneratedItems generatedItems = scriptLoader.runScript(getDslScript(dslScriptFile))
        then:
            def generatedConfigs = getGeneratedConfigs(generatedItems)
            generatedConfigs.size() > 0
        and:
            generatedConfigs.each { jobName, jobConfig ->
                persistJobConfig(jobName, jobConfig)
            }
        where:
            dslScriptFile << ['samples.groovy']
    }
}
