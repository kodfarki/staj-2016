**Project Name: servlet-project**

**Version: 1.0-SNAPSHOT**

A simple JSP & JDBC project that makes insertion, update, deletion, and selection queries on Oracle Databse Table.

#Instructions for the Project

**External JARS:**

+ Used Oracle JDBC Driver 10.2.0.4
+ Servlet API 3.1.0 
<br>

In order to run the project:

Firstly, open the **config.properties** file which is in the project directory and fill in the _username_ and _password_ with your own username and password of Oracle Database.

Then, right click the **config.properties** and click **Copy Path**.

and then, open **JDBCUtil.java** file and Paste this path to the parameter of **FileInputStream()** which is at line 28.

After this point, if it is not defined in your Database, you need to create a sequence for the value of **CAMPAIGN_ID** column of Database table:

Execute these SQL Commands on your database console file:
```
Create sequence SEQ_SLCM_DEFAULT start with 1000
increment by 1
minvalue 1
```

That's all you need to do for running this project.


<br>
**Reference:**
<br>
http://www.thejavageek.com/2013/08/11/mvc-architecture-with-servlets-and-jsp/ <br>
http://www.javawebtutor.com/articles/hibernate/mvc-appliction-using-servlet-jsp-and-hibernate.php <br>
http://www.programming-free.com/2013/07/crud-operations-using-servlet-and.html <br>
https://danielniko.wordpress.com/2012/04/17/simple-crud-using-jsp-servlet-and-mysql/ <br>
https://www.ntu.edu.sg/home/ehchua/programming/java/JSPByExample.html <br>
http://met.guc.edu.eg/OnlineTutorials/JSP%20-%20Servlets/A%20servlet%20example.aspx <br>
http://www.javatpoint.com/MVC-in-jsp <br>
http://www.javaknowledge.info/jsp-servlet-jstl-and-mysql-simple-crud-application/ <br>

