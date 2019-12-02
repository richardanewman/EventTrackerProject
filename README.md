## Event Tracker Project

### Week 12 Homework Project for Skill Distillery

### Overview

This application is built using an API first design. There is no frontend at this point in time. Only routes were used to test this application. For the Event
Tracker Project, I chose to build a cryptocurrency portfolio tracking application. This application allows a user to perform full CRUD on five tables: user_account, user_profile, portfolio, coin, and coin_watch. (see ER diagram below). Bitfolio allows user to persist data relating to their crytpocurrency portfolio and monitor possible trading opportunities. Future iterations of this project will implement a frontend, bring in real-time data from external API, perform calculations to display portfolio value, and deliver alerts based on persisted data in their coin_watch table.

![EER Diagram](https://github.com/richardanewman/richardanewman.github.io/blob/master/images/postman.png)

### Technologies

Java Version 1.8, SQL, MySQL Workbench, Spring Boot, JPA, Hibernate, Gradle, JSP, AWS EC2, Git, Github, Postman, Spring Tool Suite, and Atom

### Topics Applied

The primary topics applied from Week 12 at Skill Distillery were on RESTful APIs, JPA Relational Mapping, String Boot Repository & Service integration, and CRUD.

![EER Diagram](https://github.com/richardanewman/richardanewman.github.io/blob/master/images/bitfolio.png)

### Expected Routes

| Return Type | Route                 | Functionality                  |
|-------------|-----------------------|--------------------------------|
| `List<UserAccount>`  |`GET api/admin/users`        | ADMIN Role** Gets all user accounts in Database    |
| `UserAccount`        |`GET api/user/{id}`   | Gets one user account by id            |
| `UserAccount`        |`POST api/user`       | Creates a new user account and user profile             |
| `UserAccount`        |`PUT api/user/{id}`   | Updates an existing user account by id|
| `Boolean`            |`PUT api/user/deactivate/{id}`   | Deactivates an existing user account by id|
| `Boolean`            |`PUT api/user/reactivate/{id}`   | Reactivates an existing user account by id|
| `Boolean`            |`DELETE api/admin/delete/{id}`| Deletes an existing user account by id |
| `List<UserProfile>`  |`GET api/admin/user/profiles`        | ADMIN Role** Gets all user profiles in Database    |
| `UserProfile`        |`GET api/user/profile/{id}`   | Gets one user profile by id            |
| `UserProfile`        |`PUT api/user/profile/{id}`       | Updates an existing user profile by id             |
| `List<Portfolio>`    |`GET api/admin/portfolios`        | ADMIN Role** Gets all portfolios in Database    |
| `Portfolio`        |`GET api/admin/portfolio/{id}`   | ADMIN Role** Gets one user portfolio by id            |
| `List<Portfolio>`        |`GET api/user/{id}/portfolios`       | Gets all portfolios by user_profile id             |
| `Portfolio`        |`POST api/user/{id}/portfolio`       | Creates a new portfolio             |
| `Portfolio`        |`PUT api/user/{id}/portfolio`   | Updates an existing portfolio by id|
| `Boolean`            |`DELETE api/user/{uid}/portfolio/{pid}`| Deletes an existing portfolio by user id and portfolio id |
| `List<Coin>`    |`GET api/admin/coins`        | ADMIN Role** Gets all coins in Database    |
| `List<Coin>`        |`GET api/portfolio/{id}/coins`   | Gets all coins by portfolio id            |
| `Coin`        |`GET api/portfolio/{pid}/coin/{cid}`       | Gets coin by portfolio id and by coin id             |
| `Coin`        |`POST api/portfolio/{id}/coin`       | Creates a new coin adds to associated portfolio id           |
| `Coin`        |`PUT api/portfolio/{pid}/coin/{cid}`   | Updates an existing coin by portfolio id and coin id|
| `Boolean`            |`DELETE api/portfolio/{pid}/coin/{cid}`| Deletes an existing coin by portfolio id and coin id |
| `List<CoinWatch>`    |`GET api/admin/watches`        | ADMIN Role** Gets all coin watches in Database    |
| `CoinWatch`        |`GET api/admin/watch/{id}`   | ADMIN Role** Gets coin watch by id            |
| `List<CoinWatch>`        |`GET api/user/{id}/watches`       | Gets all coin watches by user_profile id             |
| `CoinWatch`        |`POST api/user/{id}/watch`       | Creates a new coin watch           |
| `CoinWatch`        |`PUT api/user/{uid}/watch/{wid}`   | Updates an existing coin watch by user_profile id and watch id|
| `Boolean`            |`DELETE api/user/{uid}/watch/{wid}`| Deletes an existing coin watch by user_profile id and coin watch id |



** Enhanced feature. Admin role will be implemented with Spring Security at later date.

### Lessons Learned

I really enjoy working with API first design. It's similar to TDD in that many conflicts/design-errors are eliminated before they become a much larger problem down the line. It definitely took some time to adjust to thinking from this new perspective, but once I adjusted to it, I quickly started to prefer this method over our previous workflow. Postman also makes testing much easier and saving the routes into a collections helps to avoid any missed steps in the build process.

Overall, this project went smoothly with was worrisome. I did, however, have some trouble getting my delete methods to work when the method used .contains() to check if a list of objects contained the object I wanted to delete. Instead of deleting it set the appropriate fields to null and persisted in the database until the route ran once more. Then and only then did it delete. I removed the .contains() check and simply routed the check to the mapping to ensure that the appropriate list was being used. I will definitely check into this issue more, but I am confident in the solution that I came up with to solve the issue.

Looking forward to continuing this project on the frontend and integrating an external API to enhance the applications Functionality.



### How to Run

You must compile this program to run it on a localhost or an EC2 instance. Download or clone this repository to a local directory. Open Spring Tool Suite (or your favorite IDE) and import the project under the File menu. Alternatively, you can clone the repository directly into your IDE via terminal. Once you have compiled it, click run and follow the prompts.

Clone with SSH:

git@github.com:richardanewman/EventTrackerProject.git

Clone with HTTPS:

https://github.com/richardanewman/EventTrackerProject.git


## Context

Below you will find a copy of the assignment's tasks. I am providing this context for anyone evaluating my code. The project work was performed independently. For better or worse, the code is my own. The only resources referenced were from the prior week's course material and my class notes. I am not a fan of copy and paste code because it does not aid in the learning process. I am attending this bootcamp so that I can thoroughly understand how to properly develop software.

### The Following Task Overview and User Stories Were Provided by Skill Distillery

###Learning Objectives

'Event Tracker' is a broad term for anything that keeps track of information over time. Examples of these applications are 'Mint' (financial tracking) and 'MyFitnessPal' (diet and exercise tracker). These are very involved applications with a huge feature set.

You are embarking on a weekend project that you may or may not come back to afterwards, thus we would caution you to limit your scope significantly. Examples of limited scope would be 'Gas Tracker' (keep track of your fill ups and total mileage to determine dollar/gallon in your car) or 'Timesheet' (track time in and time out to calculate total hours at some rate of pay).

* Create a JPA Project
    * Create a Java entity class POJO that models your database table.
    * Map your POJO using JPA.

* Configure a Spring Boot app to publish a REST API.
    * Use Spring REST annotations.
    * Use Spring Data JPA to perform all CRUD operations.
    * Send and receive JSON.

### Where to start?

1. Create a new STS workspace for your project.
  * Initialize your workspace with git.
  * Associate your workspace with a Github repo named EventTrackerProject.
2. Use MySQL Workbench to create a database schema with a single table.
  * Be sure to create a appusername@localhost account with a password for your database.
  * Include some initial sample data.
3. Create a Gradle Project for your JPA entity and tests.
4. Create a Spring Boot project for your REST API controller(s), service, and Spring Data JPA repository.
5. Create controller logic to perform the basic CRUD operations of a REST API.
  * Test these routes using Postman
6. Deploy your project to your EC2 instance, and link to it from your portfolio web site.

### Goal

Your objective for this project should be to do as much as you can. That is not to say as many features, but as much as you actually understand.

Do not move onto the next step until you actually know what you just did and feel comfortable with what is happening. If you reach a point and are confused about what you are doing, or what you have done, ask questions, look for resources, or start over on that piece to ensure that you are comfortable with it.

Make sure to commit and push once you have an MVP with full CRUD operations working.

### Stretch Goals

JUnit tests for your repository, service, and controller layers.
Supplemental tables, mappings, and controller routes for nested CRUD.

### Grading

This is a graded project. You are expected to have your project completed by noon on Monday.

Your project must be pushed to a Github repo named EventTrackerProject.

You must include a README.md that describes your program and how to access it on AWS. This must document your REST route URIs and HTTP methods, and what they do.

You must also deploy your app to your AWS server.

You will be given either a pass or fail based on whether your code works given all of the following test conditions:

A new event object implements full CRUD.
All interactions with the database are done so RESTfully.
If the project does work with all of the above test conditions, you will be given a 1 for this week's project.

If the project does not work with the above test conditions, you will be given a 0 for this week's project.

If you get a zero on the project, you can upgrade to a score of .5 if you turn in a working project by the start of class the following Monday morning AND notify an instructor that you wish to get partial credit.
