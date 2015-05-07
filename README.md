# OmniStore
Page created for the EEL 418 chair on Computer and Information Engineering.

This project uses mySQL, and the database can be found at "./omniBase.sql".
To make it work, you must have Apache Tomcat 8 configured with mySQL;
And
YOU MUST EDIT THE FILE "Web pages/META-INF/context.xml" and edit the declaration:

<Resource name="omniBase" auth="Container" type="javax.sql.DataSource"
            maxActive="100" maxIdle="30" maxWait="10000"
            username="root" password="omn1stor3" driverClassName="com.mysql.jdbc.Driver"
            url="jdbc:mysql://localhost:3306/omniBase"/>

With your username and your password.

