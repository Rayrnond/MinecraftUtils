# MinecraftUtils

This library is a useful tool for Spigot Minecraft Plugin Developers. Included are many utility tools to decrease the time spent developing/copy pasting. Made for Spigot development, not Bungeecord.

## Table of Contents
* [Features](https://github.com/Rayrnond/MinecraftUtils/tree/master#features)
  * [Current Features](https://github.com/Rayrnond/MinecraftUtils/tree/master#current-features)
  * [Planned Features](https://github.com/Rayrnond/MinecraftUtils/tree/master#planned-features)
* [Download](https://github.com/Rayrnond/MinecraftUtils/tree/master#download)
  * [Maven](https://github.com/Rayrnond/MinecraftUtils/tree/master#maven)
  * [Gradle](https://github.com/Rayrnond/MinecraftUtils/tree/master#gradle)
* [Examples](https://github.com/Rayrnond/MinecraftUtils/tree/master#examples)


## Features

### Current Features

* Math Utilities
* Chat Utility
* Title Utility (for <1.9)
* ActionBar Utility (for <1.9)
* Scoreboard Utility (BoardUtil)
* UUID Fetcher
* CountDown Utility
* **More Soon!**

### Planned Features
 * Dependency Downloader
 * Dependency Loader
 * Spigot update checker
 * StringUtils
 
 
## Download

Replace ``VERSION`` with the version below
[![](https://jitpack.io/v/Rayrnond/MinecraftUtils.svg)](https://jitpack.io/#Rayrnond/MinecraftUtils)

### Maven
 
 ```xml

    <repositories>
	  <repository>
	    <id>jitpack.io</id>
	    <url>https://jitpack.io</url>
	  </repository>
    </repositories>

    <dependencies>  
	  <dependency>
	    <groupId>com.github.Rayrnond</groupId>
	    <artifactId>MinecraftUtils</artifactId>
	    <version>VERSION</version>
	  </dependency>
    </dependencies>  
```
 
 ### Gradle
 
 Add this in your root build.gradle at the end of repositories.
 
 ```xml

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  ```
  
  Add the dependency.
  
  ```xml
  
  	dependencies {
	        implementation 'com.github.Rayrnond:MinecraftUtils:VERSION'
	}
  ```
  
  ## Examples
  
  Get roman numeral from ``long``.
  ```java
protected void action() {
        System.out.println(MathUtil.toRoman(10));
        // Returns "X"
        System.out.println(MathUtil.toRoman(50));
        // Returns "L"
    }

  ```
  
  Countdown from 30 where ``this`` is an instance of your main class that extends ``JavaPlugin``.
  ```java
  
     protected void action() {
        new CountDown(30,this) {
            @Override
            public void count(int current) {
                System.out.println("The number is " + current + ". Time left: " + (30-current) +"!");
            }

            @Override
            public void finished() {
                System.out.println("Countdown has finished!");
            }
        };
    }
