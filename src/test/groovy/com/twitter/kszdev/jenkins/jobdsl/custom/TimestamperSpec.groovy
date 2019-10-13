package com.twitter.kszdev.jenkins.jobdsl.custom

import javaposse.jobdsl.dsl.JobManagement
import javaposse.jobdsl.dsl.Item
import javaposse.jobdsl.dsl.helpers.wrapper.WrapperContext
import spock.lang.Specification

class TimestamperSpec extends Specification {

    WrapperContext wrapperContext = new WrapperContext(Mock(JobManagement), Mock(Item))

    def 'should add timestamps to job wrappers'() {
        when:
            Timestamper.addTimestamps(wrapperContext)
        then:
            wrapperContext.wrapperNodes*.name().contains 'hudson.plugins.timestamper.TimestamperBuildWrapper'
    }
}
