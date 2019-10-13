# Job DSL Jenkins automation starter 

Skeleton for [Job DSL](https://github.com/jenkinsci/job-dsl-plugin) based [Jenkins](https://jenkins.io/) CI/CD automation project.

Allows to quickly bootstrap Gradle project ready to create and test Job DSL scripts.

## Samples

Starter contains code samples that showcase how to test DSL scripts as well as allow to test updates (e.g. Jenkins, Job DSL plugin).

## Bootstrap steps

* remove sample job
* remove code from main sources
* remove tests from com.twitter.kszdev.jenkins.jobdsl.custom package
* remove tests from com.twitter.kszdev.jenkins.jobdsl.job package
* remove test resources
* rename packages in test sources
* update list of plugins available in tests
* update DSL scripts' references in tests

## Repository structure

```
|-- build.gradle            - project build script
|-- jenkins_plugins.gradle  - defines Jenkins plugins available in tests
|-- gdsl                    - contains GroovyDSL scripts that enable DSLs support in IntelliJ IDEA 
|-- jobs                    - contains Job DSL scripts
|-- src
|   |-- main                - contains custom code used in Job DSL scripts
|   |-- test                - contains Job DSL scripts' tests
```

## References

[API Viewer](https://jenkinsci.github.io/job-dsl-plugin/) - yet prefer Job DSL API Reference available on Jenkins due to dynamic DSL support

[DSL Playground application](https://job-dsl.herokuapp.com/)

[Job-DSL wiki](https://github.com/jenkinsci/job-dsl-plugin/wiki)

[Discussion group](https://groups.google.com/forum/#!forum/job-dsl-plugin)
