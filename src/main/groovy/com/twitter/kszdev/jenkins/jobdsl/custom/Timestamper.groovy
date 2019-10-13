package com.twitter.kszdev.jenkins.jobdsl.custom

import javaposse.jobdsl.dsl.DslContext
import javaposse.jobdsl.dsl.helpers.wrapper.WrapperContext

class Timestamper {

    static void addTimestamps(@DslContext(WrapperContext) WrapperContext wrapperContext) {
        wrapperContext.with {
            timestamps()
        }
    }

}
