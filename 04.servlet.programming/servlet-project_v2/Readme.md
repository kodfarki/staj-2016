**Project Name: servlet-project**

**Version: 1.0-SNAPSHOT**

#Instructions for Using This Project

Firstly, open the **config.properties** file which is in the project directory and fill in the _username_ and _password_ with your own username and password of Oracle Database.

Then, right click the **config.properties** and click **Copy Path**.

and then, open **JDBCUtil.java** file and Paste this path to the parameter of **FileInputStream()** which is at line 30.


After this point you need to create a sequence for the value of **CAMPAIGN_ID** column of Database table:

Execute these SQL Commands on your database console file:
```
Create sequence SEQ_SLCM_DEFAULT start with 1000
increment by 1
minvalue 1
```

That's all you need to do for running this project.
