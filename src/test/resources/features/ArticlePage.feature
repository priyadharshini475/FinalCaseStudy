Feature: Article Page Function

Scenario: Invalid Login into app
Given User is on login Page
When User enters inValid Credentials
      |email|password|
      |priyadharshini475507@gmail.com|abcd123|
Then  Should display the invalid login message
      |Wrong email/password combination|

   
   
Scenario: Valid Login into app
Given User is on login Page
When  User enters  valid Credentials
      |email|password|
      |priyadharshini475507@gmail.com|abcd1234|
Then  Should display the success login message
      |Priyadharshini|

Scenario: User Create the Article with duplicate Title
Given  User is on newArticleCreationPage
When   User Create the duplicate article
       |articleTitle|description|body|tags|
       |Smoke Test|About Smoke Test|Smoketest|test|
Then   Should display the duplicate article message
       |Title already exists..|

Scenario: User Create the new Article
Given User is on newArticleCreationPage
When  User create the new Article
       |articleTitle | description | body | tags |
       |Unit Test | About Unit Test | Unittest | test |
Then  Should display the new Article Title
       |Unit Test|

Scenario: User update the Article
Given User is on updateArticlePage
When  User Update the Article
      |articleTitle|updatedArticleTitle|description | body | tags |
      |Unit Test|Unit Test1...|About Unit test1|Unittest1|test|
Then  Should display the updated Article Title
      |Unit Test1...|

Scenario: User delete the Article
Given User is on deleteArticlePage
When  User delete the Article
      |articleName|
      |Unit Test1...|
Then  should the article to be deleted
      |Articles not available.|

