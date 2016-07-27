# Maven Guide

**Maven Environment Setup For MacOS**

Maven requires JDK installed on your machine.

1- In order to set the JAVA_HOME environment variable:
```
export JAVA_HOME=/Libray/Java/Home
```

2- After downloaded Maven from its website, used following code to add them to the environment variables:
```
export M2_HOME=/usr/local/apache-maven
export M2=$M2_HOME/bin
export MAVEN_OPTS=‘-Xms256m -Xmx512m’
```
3- Finally, to append M2 variable to System Path:
```
export PATH=$M2:$PATH
```

4- Now to verify that Maven is ready to use, type the following command line:
```
mvn —version
```

Maven project structure and contents are declared in an xml file, **pom.xml**.

Some of the configurations in the POM are following:
+ project dependencies
+ plugins
+ goals
+ project version
+ build profiles

A typical Maven **Build Lifecycle** consists of the following phases:
+ prepare-resources
+ compile
+ test
+ package
+ verify
+ install

When a phase will be executed, all phases up to this specific phase will be executed during this process.


**Creating a Project by Maven on Command Console**

By the following command line:
```
mvn archetype:generate
```

Maven will start to create the Java project structure.

It will ask you which plugin do you want to add to the project structure and then it will ask you to give the information about *groupId, artifactId, version number*. After this point, it builds the project. This project contains the source and test code, resources and pom.xml.

Additionally, in order to **install jar** into local Maven repository: 
```
$ mvn install:install-file -Dfile=<path-to-file> \
    -DgroupId=<group-id> -DartifactId=<artifact-id> \
    -Dversion=<version> -Dpackaging=<packaging>
```

Adding the dependency to POM file like any other dependency:
```
<dependencies>
  <dependency>
    <groupId>com.example</groupId>
    <artifactId>evalpostfix</artifactId>
    <version>1.0</version>
  </dependency>
</dependencies>
```
