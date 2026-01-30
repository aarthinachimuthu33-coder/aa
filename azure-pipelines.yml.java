trigger:
- main

pool:
  vmImage: 'ubuntu-latest'

variables:
  mavenOptions: '-Xmx1024m'
  javaVersion: '17'

steps:
- task: UseJavaVersion@1
  inputs:
    versionSpec: '$(javaVersion)'
    architecture: 'x64'

- task: Maven@4
  inputs:
    mavenPomFile: 'pom.xml'
    goals: 'clean package'
    options: '$(mavenOptions)'
    publishJUnitResults: true
    testResultsFiles: '**/surefire-reports/TEST-*.xml'
    javaHomeOption: 'JDKVersion'
    jdkVersionOption: '$(javaVersion)'
    mavenVersionOption: 'Default'
