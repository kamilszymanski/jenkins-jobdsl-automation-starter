package com.twitter.kszdev.jenkins.jobdsl.configxml

trait WithExpectedConfigsSources {

    String getExpectedConfigsDirectory() {
        return 'expected-configs'
    }

    File getExpectedConfigsLocation() {
        return new File("src/test/resources/${expectedConfigsDirectory}/")
    }

    void persistJobConfig(String jobName, String config) {
        File configFile = new File(expectedConfigsLocation, "${jobName}.xml")
        configFile.newWriter().withWriter {
            it << config
        }
    }
}
