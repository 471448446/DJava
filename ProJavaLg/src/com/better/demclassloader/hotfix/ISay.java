package com.better.demclassloader.hotfix;

/**
 * javac -d ./build *.java
 * cd build
 * jar cvf something.jar *
 * ---
 * dx --dex --output=say_something_hotfix.jar say_something.jar
 *
 * https://stackoverflow.com/questions/9941296/how-do-i-make-a-jar-from-a-java
 * Created by better on 2020/6/12 8:10 AM.
 */
public interface ISay {
    String saySomething();
}
