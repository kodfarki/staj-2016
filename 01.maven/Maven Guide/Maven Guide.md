# Maven Guide

<h3>Maven Environment Setup For MacOS</h3>

Maven requires JDK installed on your machine.

First of all, on your terminal console go to your home directory by the following command line:
```
 cd
```
and you can see where you are at this moment by:
```
 pwd
```
which is like /Users/mustafa for me.

Then in order to see the list of the files in this directory:
```
 ls -al
```
You will see that there is a file called as **.bash_profile**, to open that file:
```
 open .bash_profile
```
After this point, add the following command lines to this file.

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

Then just save the file and go back to your terminal console.

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

<h3>Creating a Project by Maven on Command Console</h3>

By the following command line:
```
mvn archetype:generate
```

Maven will start to create the Java project structure.

It will ask you which plugin do you want to add to the project structure and then it will ask you to give the information about *groupId, artifactId, version number*. After this point, it builds the project. This project contains the source and test code, resources and pom.xml.

<h3>Installing JAR File Into Local Maven Repository </h3>

In order to **install jar** into local Maven repository: 
```
$ mvn install:install-file -Dfile=<path-to-file> \
    -DgroupId=<group-id> -DartifactId=<artifact-id> \
    -Dversion=<version> -Dpackaging=<packaging>
```

and then, in order to get this JAR file from Local Repository and to import into the project:

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

After that, you can set **'Toggle Offline Mode'** by _Maven Projects Bar_ in Intellij in order to direct Maven to search this JAR file inside the Local Repository, but not on the Internet.


<h3>Scope Tag under Dependency in pom.xml </h3> 
Scope is used to limit the transitivity of a dependency and to affect the classpath.
<br> <br>
The <scope> element can take 6 value: **compile**, **provided**, **runtime**, **test**, **system** and **import**.

For instance:
```
<scope>test</scope>
```

**compile** <br>
This is the default scope, used if none of them is specified. Compile dependencies are available in all classpaths of a project. 

**provided** <br>
This is much like compile, but indicates you expect the JDK or a container to provide the dependency at runtime. For example, when building a web application for the Java Enterprise Edition, you would set the dependency on the Servlet API and related Java EE APIs to scope provided because the web container provides those classes. This scope is only available on the compilation and test classpath, and is not transitive.

**runtime** <br>
This scope indicates that the dependency is not required for compilation, but is for execution. It is in the runtime and test classpaths, but not the compile classpath.

**test** <br>
This scope indicates that the dependency is not required for normal use of the application, and is only available for the test compilation and execution phases.

**system** <br>
This scope is similar to provided except that you have to provide the JAR which contains it explicitly. The artifact is always available and is not looked up in a repository.

**import** <br>
This scope is only used on a dependency of type pom in the section. It indicates that the specified POM should be replaced with the dependencies in that POM's section. Since they are replaced, dependencies with a scope of import do not actually participate in limiting the transitivity of a dependency.

**Reference for Scope Part:** <br>
http://stackoverflow.com/questions/26975818/what-is-scope-under-dependency-in-pom-xml-for
