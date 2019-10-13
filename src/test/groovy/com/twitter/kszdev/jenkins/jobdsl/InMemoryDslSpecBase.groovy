package com.twitter.kszdev.jenkins.jobdsl

import javaposse.jobdsl.dsl.DslScriptLoader
import javaposse.jobdsl.dsl.MemoryJobManagement
import spock.lang.Specification

class InMemoryDslSpecBase extends Specification implements WithDslScriptsSources, WithJobManagement {

    MemoryJobManagement jobManagement = new MemoryJobManagement()
    DslScriptLoader scriptLoader = new DslScriptLoader(jobManagement)
}
