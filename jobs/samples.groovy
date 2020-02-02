import static com.twitter.kszdev.jenkins.jobdsl.custom.Timestamper.addTimestamps
import static javaposse.jobdsl.dsl.views.jobfilter.Status.FAILED

job('sample-job') {
    steps {
        shell "echo -e '\\e[32mGenerating data\\e[0m'"
        shell 'echo `date` > data'
    }
    publishers {
        cleanWs {                                       // plugin supported via dynamic DSL
            cleanWhenSuccess(false)
        }
    }
    wrappers {
        colorizeOutput()                                // plugin supported via JobDSL API
        addTimestamps(delegate)                         // custom code on the classpath
    }
    configure {
        (it / quietPeriod).value = 0                    // directly modify underlying config.xml
    }
}

listView('sample-view') {
    jobFilters {
        status {                                        // plugin supported via JobDSL API
            status(FAILED)
        }
    }
    columns {
        status()
        name()
    }
}
