# PairSchedule
Program for automatic connecting to set of google meets=. Powered by Spring Framework & Selenium WebDriver

This program allows you to save your time by connecting to daily meetings. For its operation, it is necessary to configure the corresponding XML files 
in the same directory with the program (configuration of meetings and links + configuration of days (which meetings at what time)). 
During startup, the Spring IoC container will read these settings and perform dependency injection. Also, to work, you need a chromedriver
in the same directory as the program, with its help a browser will be opened in which the connection will be made.
