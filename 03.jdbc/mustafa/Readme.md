**Project Name: JDBC-PROJECT**

**Version: 1.0-SNAPSHOT**

#Instructions for the Project

In this project, we've used **Oracle JDBC Service** for Database Connection. We've hard-coded the connection details, such as _driver class_, _url_, _username_, and _password_, in **DatabaseConnection** class which is in **util** package.

You can change these configurations by this class.

In addition to this,

If it is not defined in your Database, you need to create a sequence for the value of **CAMPAIGN_ID** and **EXTERNAL_CAMPAIGN_ID** columns of Database table:

Execute these SQL Commands on your database console file:
```
Create sequence SEQ_SLCM_DEFAULT start with 1000
increment by 1
minvalue 1
```

That's all you need to do.

<br>
**Reference:** <br>
https://www.packtpub.com/mapt/book/Application%20Development/9781847194305 <br>
https://www.udemy.com/how-to-connect-java-jdbc-to-mysql/learn/v4/content <br>
