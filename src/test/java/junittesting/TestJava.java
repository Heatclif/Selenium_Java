package junittesting;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestJava {

//    @Test
    public void replaceVowels() {
        String str = "VivekBiswas";
        String repChar = "v";

        System.out.println(str.replaceAll("[aeiou]", repChar));
    }

//    @Test
    public void countRepeatingChar() {
        String str = "VivekBiswas";
        Map<String, List<String>> stringMap = new HashMap<>();

        for(String s : List.of(str.toLowerCase().split(""))) {
            stringMap.computeIfAbsent(s, k -> new ArrayList<>()).add(s);
        }

        stringMap.keySet().forEach(k -> System.out.println(k + ": " + stringMap.get(k).size()));
    }
}