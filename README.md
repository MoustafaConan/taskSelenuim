# taskSelenuim

This is a repo of the three GUI tasks From Terkwaz 

using Maven, Data Driven Test, Page object model , TestNG  

**INTRO **
Testing
This project is implemented using Page Object Model,under this model, for each web page in the application, there should be a corresponding Page Class This Page class will identify the WebElements of that web page and also contains Page methods which perform operations on those WebElements.There is a clean separation between test code and page specific code. for each web page there is a corresponding test page that can perform assertions on the website page.

This is a maven project you must download maven from marketplace to use it 
Steps to use the project:
1. Download maven from marketplace
2. clone the project or download it 
3. make sure that you install all jar file using maven dependices 


This project is implemented using Data-Driven Testing
You can Edit test data of these test cases from testData.properites from src/main/Data/testData.properites

First Test   

            Navigate to "https://www.google.com/ncr" 
            
            Search for "selenium webdriver" 
            
            Check that the third result text contains "What is Selenium WebDriver?" 
               
                        Page Class: Src/main/java/Pages/Task1Page 
                        
                        Test Class: Src/test/java/Tests/Task1Test
Second Test

            Navigate to "https://the-internet.herokuapp.com/" 
            
            Click on "File Upload" 
            
            Upload any small image file 
            
            Check that the file has been uploaded successfully
                           
                        Page Class: Src/main/java/Pages/Task2Page 
                        
                        Test Class: Src/test/java/Tests/Task2Test
Third Test

            Navigate to "https://the-internet.herokuapp.com/" 
            
            Click on "Dynamic Loading" 
            
            Click on "Example 2" 
            
            Click "Start" 
            
            Wait for loading to finish 
            
            Check that the text displayed is "Hello World!" 
                         
                        Page Class: Src/main/java/Pages/Task3Page 
                        
                        Test Class: Src/test/java/Tests/Task3Test


