# webSpa_deception
Add deception mechanism (HoneyChecker) for OWASP WebSpa project.
# How to run the WebSpa server project
java-jar webspa.jar -server

# command to start the webspa server
service start

# command to add user into webspa system
user add

# command to show list of user into webspa system
user show

# command to activate user into webspa system
user activate

# command to view user pass-phrase into webspa system
pass-phrase show

# command to add decoy pass-phrases for user into webspa system
add dup pass-phrase (custom command)

# command to add action to user into webspa system
action add  (sudo service ssh start)/(windows -TASKKILL/F/IMhttpd.exe/T)

# command to show user action into webspa system
action show


# How to run the WebSpa Client project
java-jar webspa.jar -client

http://localhost:80
Enter pass-phrase: 
Re-emter pass-phrase:

Feature Added

1. Introduced a virtual server (HoneyChecker) in Spring boot which will act Middle Man to Client and Server to detect the decoy User into System
2. Web service call in REST api to verify the identify of original user into system
