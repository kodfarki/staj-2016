**Project Name: spring-project**

**Version: 1.0-SNAPSHOT**

A simple Spring & JDBC project that makes insertion, update, deletion, and selection queries on Oracle Databse Table.

#Instructions for the Project

**External JARS** 

 + Used **Oracle JDBC Driver 10.2.0.4** for Database Connection 
 + Used **Spring Core 4.3.2.RELEASE** for Spring Core utilities
 + Used **Spring Context 4.3.2.RELEASE** for reading spring-config.xml by ApplicationContext  
 + Used **Spring JDBC 4.3.2.RELEASE** for Spring's JDBC Support

We've configured the information about the database, such as _driver class_, _url_, _username_, and _password_, by defining a **bean**. In addition to this, we've defined another bean for using **DAO Implementations** and **JdbcTemplate** support. We've called this bean in our **Main.java** file in order to access the implementation, which is crucial for running the project.

You can change these configurations by **spring-config.xml** file under the resources directory.

<br>
**References**
<br>
https://www.packtpub.com/mapt/book/Application%20Development/9781783982349  <br>
https://www.mkyong.com/spring/spring-jdbctemplate-jdbcdaosupport-examples/ <br>
http://javahonk.com/spring-jdbcdaosupport-example/ <br>
http://www.java2novice.com/spring/jdbcdaosupport-query-example/ <br>


