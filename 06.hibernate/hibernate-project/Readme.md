**Project Name: hibernate-project**

**Version: 1.0-SNAPSHOT**

A simple JPA & JDBC project that makes insertion, update, deletion, and selection queries on Oracle Databse Table.

#Instructions for the Project

In **persistence.xml** under the resources directory,

**External JARS** 

 + Used **Oracle JDBC Driver 10.2.0.4** for Database Connection 
 + Used **Hibernate Core 5.2.1.Final** for making the software development independent of the database.

We've configured the information about the database, such as _driver class_, _url_, _username_, and _password_. You can change these configurations by **persistence.xml** file under the resources directory. 
##Hibernate Properties 
In addition to these, in **persistence.xml** we've defined **hbm2ddl.auto** configuration property as the following:
```
<property name="hbm2ddl.auto" value="update"/>
```
which updates the schema to reflect the entities being persisted.

As a reminder, for hbm2ddl.auto property the list of possible options is:
 + **validate:** validate that the schema matches, make no changes to the schema of the database.
 + **update:** update the schema to reflect the entities being persisted
 + **create:** creates the schema necessary for your entities, destroying any previous data.
 + **create-drop:** create the schema as in create above, but also drop the schema at the end of the session. Great for testing.

<br>
**References** <br>
http://www.objectdb.com/java/jpa/persistence/crud <br>
http://www.coderpanda.com/jpa-update-query-example/ <br>
http://www.thejavageek.com/2014/01/12/jpa-crud-example/ <br>
http://howtodoinjava.com/jpa/jpa-native-update-sql-query-example/ <br>
