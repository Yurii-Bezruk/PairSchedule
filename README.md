# PairSchedule
Program for automatic connecting to set of daily meetings in google meet. Powered by Spring Framework & Selenium WebDriver

This program allows you to save your time by connecting to daily meetings. For its operation, it is necessary to configure the corresponding XML files 
in the same directory with the program (configuration of meetings and links + configuration of com.striker.meetings.days (which meetings at what time)). 
During the startup, the Spring IoC container will read these settings and perform dependency injection. Also, to work, you need a chromedriver
in the same directory as the program, with its help a browser will be opened in which the connection will be made.

You should complete the MeetingsContext.xml like this:

`<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">` 
    
    <bean id="scheduler" class="com.striker.meetings.bean.Scheduler">
        <constructor-arg>
            <list>
                <ref bean="meeting1"/>
                <ref bean="meeting2"/>
            </list>
        </constructor-arg>
    </bean>
    
    <bean id="meeting1" class="com.striker.meetings.bean.MeetTime">
        <property name="start" value="8:30"/>
        <property name="end" value="9:50"/>
    </bean>
    <bean id="meeting2" class="com.striker.meetings.bean.MeetTime">
        <property name="start" value="10:10"/>
        <property name="end" value="11:30"/>
    </bean>
    
     ...
     
    <bean id="mathematicMethodsOfOperationsResearchLecture" class="com.striker.meetings.bean.Meeting">
        <property name="link" value="https://meet.google.com/hej-rdrx-xwe"/>
    </bean>
    <bean id="expertSystemsTheoryAndIntellijDataAnalysis" class="com.striker.meetings.bean.Meeting">
        <property name="link" value="https://meet.google.com/zct-oyvx-kwj"/>
    </bean>
    ...
`</beans>`

In this file, beans of three types are declared: scheduler, meeting time and meeting.
Meetings must have unique id, by which they will be added to the schedule of days. 
They must have "com.striker.meetings.bean.Meeting" as their class attribute.
They have a link property, which must be set - this is the link on which the connection will be made.
Meeting beans is a schedule of meetings every day. Each such bean must have start and end properties,
where the meeting start and end times are transmitted in the 'HH: MM' format. 
A unique bean id can be set whatever, the recommended format is meetingX, where X is the ordinal number of the meeting per day.
The 'class' attribute must be "com.striker.meetings.bean.MeetTime".
The last bean type in this document is the scheduler. It must be in the singular, and it is in it that the order of meetings is set.
Its id must be "scheduler", the class must be "com.striker.meetings.bean.Scheduler"
Inside there should be a `<constructor-arg>` tag, inside it - a `<list>` tag, and inside it -
links to the schedule beans in the format `<ref bean = "meetingХ"/>`

The DaysContent file describes whether meetings belong to specific days.
It declares bean days, which must contain the id name of the day, for example "monday", "friday", etc. 
The class attribute must be "com.striker.meetings.bean.Day". Inside the bean there must be a `<constructor-arg>`
tag, inside it the associative array must be set with the 
`<map key-type = "java.lang.Integer" value-type = "com.striker.meetings.bean.Meeting">` tag.
Inside this tag, the meeting beans created in the previous file are listed in the format 
`<entry key = "X" value-ref = "Y" />`, where X is the interview number and Y is the id of the corresponding interview bean from the previous file.

Example of DaysContent.xml:



`<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">` 
    
        <bean id="monday" class="com.striker.meetings.bean.Day">
            <constructor-arg>
                <map key-type="java.lang.Integer" value-type="com.striker.meetings.bean.Meeting">
                    <entry key="1" value-ref="mathematicMethodsOfOperationsResearchLecture"/>
                    <entry key="2" value-ref="expertSystemsTheoryAndIntellijDataAnalysis"/>
                </map>
            </constructor-arg>
        </bean>
        
        ...
        
`</beans>`