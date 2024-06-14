*** Settings ***
Library              SeleniumLibrary
Resource          ../../resources/CommonFunctionality.robot
Resource         ../../resources/WebsiteKeyword.robot
Variables        ../../variables/Locators/Website_locators.py


*** Test Cases ***
Verify books list
  [Documentation]  This case login a user and verifies the list of books
  [Tags]  Functional

   Start testcase for chrome
   Scroll To Percentage    90
   Click on book store application
   Wait Until Element Is Visible   ${login_button}
   Click on login
   Scroll To Percentage    70
   Enter Username of customer
   Enter Password of customer
   Click on login
   Wait Until Element Is Visible   ${list_of_books}
   Scroll To Percentage    70
   ${books_list}    Get WebElement    ${list_of_books}
   @{element_texts}=    Create List
   FOR    ${books_list}     IN    ${books_list}
   ${text}=    Get Text    ${books_list}
    ${element_texts}=    Evaluate    ${element_texts} + [$text]
    Log to console    ${books_list.text}
    END
    Finish testcase
