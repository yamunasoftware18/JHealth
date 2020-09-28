# JHealth

JHealth API Uses Our UILA_API Machine Learning Library to Classify Important Health Information, Written in Java

## Installation:

To install this API, we strongly recommend using Maven or Gradle, since it cuts down the amount of source code in your application. Both Maven and Gradle are incredibly easy to use and install with Java projects, and you can add this API as a dependency to your project. Additionally, both Maven and Gradle allow for the full functionality of the API to shine through, making your life as a developer much easier. We have built and are building these tools for you, and the installation code is below.

Maven:

```XML
<repositories>
  <repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
  </repository>
</repositories>

<dependencies>
  <dependency>
    <groupId>com.github.yamunasoftware18</groupId>
    <artifactId>JHealth</artifactId>
    <version>Tag</version>
  </dependency>
</dependencies>
```

Gradle:

```Java
allprojects {
  repositories {
    maven { url 'https://jitpack.io' }
  }
}

dependencies {
  implementation 'com.github.yamunasoftware18:JHealth:Tag'
}
```

## About the API:

JHealth is an API that uses the power of machine learning and classification to classify important health information, based on data. We believe that current health information is sparse and useless for the common person to interact with and make sense of. Therefore, we have decided to make this API interface user inputs and data that our algorithm can parse through an API. Since we use and MIT License, anyone can use and distribute this API in any manner that they feel is helpful. To make this API branch out in multiple fields, we will be adding new data features in this API, and maintaining it regularly. Our goal is to give health professionals, non-profits, consumers, and businesses the free tools to get started with any project in the health field. Our main goal is to help those in need of medical guidance through technology. We do not recommend replacing a doctor or health professional with our API, and the API is simply meant to be a guide and an addition to a professional doctor. To see what you can do, see our updated list of API features below.

API Features:

1. BMI and Height to Weight API

## API Documentation:

The JHealth API is an API is an API written in Java; therefore, some use cases could be Android and iOS applications, PC and Mac applications, Java projects, and Java-ported projects. Furthermore, Java is the most installed, run, and used language in the world, so it makes sense to use Java for a very versatile and useful application like this API. For more details see the usage instructions below.

### BMI API:

Once you have installed and built your project with the API, you are ready to go! This section of the API has two models to train: the male and female models. These models correspond to the male and female BMI datasets because we wanted to keep the models separate and easy to use. The BMI API takes an input of height and weight (given the respective gender) and outputs a class to which the data belongs to. The BMI classes are displayed below. 

BMI Classes

1. Extremely Weak
2. Weak
3. Normal
4. Overweight
5. Obese
6. Extremely Obese

There are many useful uses of this API such as being a guide for getting people medical help and attention. Since, obesity is a leading cause of death in the United States, we strongly believe that this tool can make a difference in the medical space. So, to use the BMI and Weight Analysis Model, see the code below.

```Java
import com.yss.java.Main.API;
import java.lang.System;
import java.io.PrintStream;
import java.io.File;

public class API_Example {
  //API Example Main Method:
  public static void main(String args[]) throws Exception {
    //API Setup (Object, Specify Model Output Directories):
    API health = new API();
    String maleOutputDirectory = "yourPath", femaleOutputDirectory = "yourPath";
    API.setBMIDirectories(maleOutputDirectory, femaleOutputDirectory);

    //If You Do Not Want The API to Print to the Terminal, Set Another Print Output: 
    System.setOut(new PrintStream(new File("yourFile.txt")));
    System.setErr(new PrintStream(new File("yourFile.txt")));

    //Train the Both BMI Models (PARAMS => Padding Percentage = double -> Recommended 0, Remove Outliers in Data = boolean -> Recommended true):
    API.trainMaleBMI(0, true);
    API.trainFemaleBMI(0, true);

    //Get BMI API Models Outputs (PARAMS => Height = double -> cm, Weight = double -> kgs):
    double testMaleHeight = 190, testMaleWeight = 100; 
    double testFemaleHeight = 170, testFemaleWeight = 90;
    String maleClass = API.getMaleBMI(testMaleHeight, testMaleWeight);
    String femaleClass = API.getFemaleBMI(testFemaleHeight, testFemaleWeight);
  }
}
```