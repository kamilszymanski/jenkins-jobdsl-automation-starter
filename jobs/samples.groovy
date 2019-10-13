import com.twitter.kszdev.jenkins.jobdsl.custom.Timestamper
import javaposse.jobdsl.dsl.views.jobfilter.Status

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
        Timestamper.addTimestamps(delegate)             // custom code on the classpath
    }
    configure {
        (it / quietPeriod).value = 0                    // directly modify underlying config.xml
    }
}

listView('sample-view') {
    jobFilters {
        status {                                        // plugin supported via JobDSL API
            status(Status.FAILED)
        }
    }
    columns {
        status()
        name()
    }
}
