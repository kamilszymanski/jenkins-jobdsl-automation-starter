package com.twitter.kszdev.jenkins.jobdsl

trait WithDslScriptsSources {

    File getDslScriptsLocation() {
        return new File('jobs')
    }

    String getDslScript(String scriptName) {
        return new File(dslScriptsLocation, scriptName).text
    }
}
