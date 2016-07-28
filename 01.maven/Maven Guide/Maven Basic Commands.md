# Maven Basic Commands

**creating java project:**
```
mvn archetype:generate -DgroupId=org.yourcompany.project -DartifactId=application
```
**creating web project:**
```
mvn archetype:generate -DgroupId=org.yourcompany.project -DartifactId=application
-DarchetypeArtifactId=maven-archetype-webapp
```


**Other Basic Commands**


**clean project:** will delete target directory
```
mvn clean
```

**compile project:** compile source code
```
mvn compile
```

**test project:** tests by using a testing framework
```
mvn test
```

**package project:** take the compiled code and package it
```
mvn package
```

**verify project:** run any checks to verify the package is valid
```
mvn verify
```

**install project:** install the package into the local repository
```
mvn install
```

**deploy project:** copies the final package to the remote repository 
```
mvn deploy
```
