<br/>
<p align="center">
  <a href="https://github.com/ro-carlos/qa-automation-project">
    <img src="https://upload.wikimedia.org/wikipedia/commons/d/d5/Selenium_Logo.png" alt="Logo" width="80" height="80">
  </a>

  <h3 align="center">QA Automation Project</h3>

  <p align="center">
    Custom Automation Framework
    <br/>
    <br/>
    <a href="https://github.com/ro-carlos/qa-automation-project"><strong>Explore the docs »</strong></a>
    <br/>
    <br/>
  </p>
</p>

![Downloads](https://img.shields.io/github/downloads/ro-carlos/qa-automation-project/total) ![Contributors](https://img.shields.io/github/contributors/ro-carlos/qa-automation-project?color=dark-green) ![Issues](https://img.shields.io/github/issues/ro-carlos/qa-automation-project) ![License](https://img.shields.io/github/license/ro-carlos/qa-automation-project) 

## Table Of Contents

* [About the Project](#about-the-project)
* [Built With](#built-with)
* [Getting Started](#getting-started)
  * [Prerequisites](#prerequisites)
  * [Installation](#installation)
* [Usage](#usage)
* [Authors](#authors)

## About The Project

![Screen Shot](https://drive.google.com/uc?export=view&id=1HeFu3yU3GbK7M1LqU9tWkSKoF54lXQkX)

This is an automation framework to run test cases using selenium and java.

## Built With

Java 11, Selenium 4.14.0, Junit 4

## Getting Started

You just need the Java 11 version on your local machine.

### Prerequisites

Install Java 11 and maven.

* Java
* Maven

_Check Oracle guide: [Java Versions](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html),  Maven guide: [Maven Versions](https://maven.apache.org/install.html)

### Installation

1. Clone the repo

```sh
git clone https://github.com/ro-carlos/qa-automation-project.git
```

2. Install Maven Packages

```sh
mvn clean install
```

## Usage

1. Run all the unit test classes.
```sh
mvn clean test
```

2. Run tests in headless mode.
```sh
mvn clean test -Dheadless=true
```

 3. Run tests on firefex.
```sh
mvn clean test -Dbrowser=firefox
```

 4. Run tests on 5 threads in parallel (will open up to 5 browsers, if there are 2, then it will open 2 browser instances)
```sh
mvn clean verify -DthreadCount=5
```

 5. Generate Allure Report
```sh
mvn allure:report
```

 6. View Allure Report
```sh
mvn allure:serve
```


## Authors

* **Carlos Rodríguez** - *Software Engineer* - [Carlos Rodríguez](https://github.com/ro-carlos/) - *QA Automatíon Project*


