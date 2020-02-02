package com.twitter.kszdev.jenkins.jobdsl.syntax

import com.twitter.kszdev.jenkins.jobdsl.JenkinsDslSpecBase
import spock.lang.Unroll

import static groovy.io.FileType.FILES

class DslScriptsSyntaxSpec extends JenkinsDslSpecBase {

    @Unroll
    def 'should find no syntactic errors in #dslScript DSL script'() {
        when:
            scriptLoader.runScript(dslScript.text)
        then:
            noExceptionThrown()
        where:
            dslScript << dslScripts
    }

    private List<File> getDslScripts() {
        List<File> dslScripts = []
        dslScriptsLocation.eachFileRecurse(FILES) {
            if (it.name.endsWith('.groovy')) {
                dslScripts << it
            }
        }
        return dslScripts
    }
}
