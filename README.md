This is a test task for Zing project.
Made by Zhanat Bekmambetov

Contents:
1) Automated mobile application tests
2) Automated backend tests

Components:
 - Appium
 - BrowserStack
 - RestAssured
 - TestNG

Please note that a trial BrowserStack account is used that allows only 100 minutes of execution.
At the time of task submission it was a fresh trial.

If under some circumstances this time would run out new username and token should be set in browserstack.yaml file

Requirements to execute:
 Installed Maven
 JDK/JRE v20

Notes:
Annotation @AndroidBy and therefore PageFactory class were not used due to existing bug in Appium + PageFactory - https://github.com/appium/java-client/issues/1619 which affects newer Java versions

How to:
 - Local execution: download the project and run command mvn test. Test report would be put into folder /target/surefire-report
 - CI execution: Proceed to GitHub actions,
   select CI flow
   <kbd> ![image](https://github.com/elven1289/ZingTestTask/assets/8339456/43cbfc0b-975e-461b-885a-b865130abc26) </kbd>
   
   launch the run
   <kbd> ![image](https://github.com/elven1289/ZingTestTask/assets/8339456/3fa659a9-93a0-4a2f-8b00-ec8b943c9e2a) </kbd>
   <kbd> ![image](https://github.com/elven1289/ZingTestTask/assets/8339456/a5eb0950-7245-4339-9659-3b41cbeba507) </kbd>

   wait until build finishes and download attached test report
   <kbd> ![image](https://github.com/elven1289/ZingTestTask/assets/8339456/7383f3bf-2980-40e8-bad9-2eea17e11f57) </kbd>

   Example of a Test Report
   <kbd> ![image](https://github.com/elven1289/ZingTestTask/assets/8339456/503d3f2f-1a4a-495e-a552-2f8cdfc3da50) </kbd>






 
