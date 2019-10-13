package com.twitter.kszdev.jenkins.jobdsl

import javaposse.jobdsl.dsl.DslScriptLoader
import javaposse.jobdsl.plugin.JenkinsJobManagement
import org.junit.ClassRule
import org.junit.rules.TemporaryFolder
import org.jvnet.hudson.test.JenkinsRule
import spock.lang.Shared
import spock.lang.Specification

class JenkinsDslSpecBase extends Specification implements WithDslScriptsSources, WithJobManagement {

    @Shared
    @ClassRule
    JenkinsRule jenkinsRule = new JenkinsRule()

    @Shared
    @ClassRule
    TemporaryFolder temporaryFolder = new TemporaryFolder()

    JenkinsJobManagement jobManagement = new JenkinsJobManagement(System.out, [:], temporaryFolder.newFolder())
    DslScriptLoader scriptLoader = new DslScriptLoader(jobManagement)
}
