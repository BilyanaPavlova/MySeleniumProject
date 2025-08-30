package org.automation.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;


public class SelectorsTests extends BaseTest {

    @Test
    public void testSeleniumSelectors() {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");

        //<input type="text" id="et_pb_contact_name_0" class="input" value="" name="et_pb_contact_name_0" data-required_mark="required" data-field_type="input" data-original_id="name" placeholder="Name">
        try {
            // ID Selector
            driver.findElement(By.id("et_pb_contact_name_0"));
            // Name Selector
            driver.findElement(By.name("et_pb_contact_name_0"));
            // Class Name Selector
            driver.findElement(By.className("et_pb_contact_field"));
            // Tag Name Selector
            driver.findElement(By.tagName("input"));
            // Link Text Selector
//            driver.findElement(By.linkText("Click Here to Download a Sample CSV File"));
            // Partial Link Text Selector
            driver.findElement(By.partialLinkText("Download a Sample"));
            // CSS Selector by ID
            driver.findElement(By.cssSelector("#et_pb_contact_name_0"));
            // CSS Selector by Class
            driver.findElement(By.cssSelector(".et_pb_contact_field"));
            // CSS Selector by Attribute
            driver.findElement(By.cssSelector("input[name='et_pb_contact_name_0']"));
            // CSS Selector by Attribute Starts With
            driver.findElement(By.cssSelector("input[name^='et_pb']"));
            // CSS Selector by Attribute Ends With
            driver.findElement(By.cssSelector("input[name$='name_0']"));
            // CSS Selector by Attribute Contains
            driver.findElement(By.cssSelector("input[name*='contact_name']"));
            // XPath by ID
            driver.findElement(By.xpath("//input[@id='et_pb_contact_name_0']"));
            // XPath by Name
            driver.findElement(By.xpath("//input[@name='et_pb_contact_name_0']"));
            // XPath by Class
            driver.findElement(By.xpath("//input[contains(@class, 'et_pb_contact_field')]"));
            // XPath by Attribute Starts With
            driver.findElement(By.xpath("//input[starts-with(@name, 'et_pb')]"));
            // XPath by Attribute Ends With
            driver.findElement(By.xpath("//input[substring(@name, string-length(@name) - string-length('name_0') +1) = 'name_0']"));
            // XPath by Attribute Contains
            driver.findElement(By.xpath("//input[contains(@name, 'contact_name')]"));
            // XPath by Position
            driver.findElement(By.xpath("(//input[@class='et_pb_contact_field'])[1]"));
        } catch (NoSuchElementException e) {
            System.out.println("An element was not found: " + e.getMessage());
        }

        //<a id="simpleElementsLink" href="/link-success" name="clickableLink">Click this link</a>
        try {
            driver.findElement(By.id("simpleElementsLink"));
            driver.findElement(By.name("clickableLink"));
            driver.findElements(By.tagName("a")); // many elements with this tag
            driver.findElement(By.linkText("Click this link"));
            driver.findElement(By.partialLinkText("this link"));
            driver.findElement(By.cssSelector("#simpleElementsLink"));
            driver.findElements(By.cssSelector("a[name='clickableLink']"));// many elements with this selector
            driver.findElement(By.cssSelector("a[id^='simple']"));
            driver.findElement(By.cssSelector("a[id$='Link']"));
            driver.findElement(By.cssSelector("a[id*='Elements']")); // contains
            driver.findElement(By.xpath("//a[@id='simpleElementsLink']"));
            driver.findElements(By.xpath("//a[@name='clickableLink']"));
            driver.findElement(By.xpath("//a[starts-with(@id, 'simple')]"));
            driver.findElement(By.xpath("//a[substring(@id, string-length(@id) - string-length('Link') +1) = 'Link']"));
            driver.findElement(By.xpath("//a[contains(@id, 'Elements')]"));
            driver.findElement(By.xpath("(//a)[1]"));
        } catch (NoSuchElementException e) {
            System.out.println("An element was not found: " + e.getMessage());
        }
    }
}
