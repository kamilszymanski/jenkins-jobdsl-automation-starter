package com.twitter.kszdev.jenkins.jobdsl

import org.custommonkey.xmlunit.Diff
import org.custommonkey.xmlunit.XMLUnit
import org.junit.ComparisonFailure

trait WithConfigXmlDiff {

    void assertGeneratedConfigMatches(String jobName, String actualConfig, String expectedConfig) {
        Diff diff = compareXml(actualConfig, expectedConfig)
        if (!diff.similar()) {
            throw new ComparisonFailure(
                    "Generated config XML for ${jobName} job does not match expected one", expectedConfig, actualConfig)
        }
    }

    void assertGeneratedConfigsMatch(Map<String, String> generatedJobs, String expectedConfigsResourcesPath) {
        generatedJobs.each { jobName, jobConfig ->
            URL expectedConfigUrl = this.class.getResource("/${expectedConfigsResourcesPath}/${jobName}.xml")
            if (expectedConfigUrl == null) {
                throw new RuntimeException(
                        "Expected config XML for ${jobName} job not found in /${expectedConfigsResourcesPath} resource path")
            }
            assertGeneratedConfigMatches(jobName, jobConfig, expectedConfigUrl.text)
        }
    }

    private Diff compareXml(String actual, String expected) {
        XMLUnit xmlUnit = new XMLUnit()
        xmlUnit.ignoreWhitespace = true
        xmlUnit.normalizeWhitespace = true
        return xmlUnit.compareXML(expected, actual)
    }
}
