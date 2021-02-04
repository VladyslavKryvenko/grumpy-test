#Grumpy Test
[Grumpy](https://github.com/tonsky/grumpy) is simple blog engine with minimal functionality.

Tests is written on Java using TestNg and [Selenide](https://github.com/codeborne/selenide) as the wrapper on Selenium WebDriver.
They run in parallel in different browsers using [Selenoid](https://github.com/aerokube/selenoid) as implementation of Selenium hub.
As status page is used [Selenoid UI](https://github.com/aerokube/selenoid-ui) as user interface for Selenoid.
For reports is used the [Allure](https://github.com/allure-framework/allure2).

## Getting Started
### Build the application
```
docker-compose -f .stack/docker/docker-compose.yml up --build --force-recreate
```
You need to wait for the application to start. This may take a while. When the application starts you will see this

![idea-file-new-project.png](https://i.imgur.com/dEcSq0X.png)

After building you have:
* `http://localhost:8080` - The app
* `http://localhost:8181` - Selenoid UI

### Running the tests
To run the tests you need to open a new tab on the command line

![idea-file-new-project.png](https://i.imgur.com/ravbozt.png)

Enter command to run all tests:
```
mvn clean test
```

### The Allure test report
Serve the report:
```
allure serve
```
Or generate and open it:
```
allure generate
allure open
```