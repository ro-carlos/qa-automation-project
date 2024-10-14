# qa-automation-project

mvn clean install
mvn clean test
mvn allure:report
mvn allure:serve

mvn clean test -Dheadless=true // headless mode
mvn clean test -Dbrowser=firefox // firefox
mvn clean test -Dbrowser=chrome -Dheadless=true // chrome in headless mode
