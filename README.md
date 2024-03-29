Cucumber TestNG POC

This repository contains a Proof of Concept (POC) for running Cucumber tests in parallel using TestNG with Cucumber
The project demonstrates how to set up and configure your test framework to execute Cucumber scenarios in parallel with
TestNG.

Main Technologies
* Cucumber
* Maven
* Java
* Lombok
* Selenide
* Selenium WD
* Slf4j
* TestNG

Prerequisites
* Java 8 or Higher (I used Amazon Cornetto Version 11)
* Maven 3.x - make sure you download maven on your machine (brew install maven via terminal)
* IDE (preferably IntelliJ)

1. Step 1. clone Git Repo onto machine: https://github.com/Doabdul12/Hudl-Tech-Test
2. Step 2. run mvn clean install via terminal
3. Step 3. to run entire project we can use mvn test in terminal  
4. Step 4. we can also use TestNG config to run all tests !
   -ea
   -Dtestng.dtd.http=true
   -Dselenide.headless=false
   -Ddataproviderthreadcount=1
   -Dcucumber.filter.tags="@RunaRegression"

To adjust the level of parallelism, edit the testng.xml file and update the thread-count attribute to the desired number of threads:
<suite name="DICE Parallel Suite" verbose="1" parallel="tests" thread-count="5"> You can also add or remove elements in the testng.xml file to control the number of parallel test executions.