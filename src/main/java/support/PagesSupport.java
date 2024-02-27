package support;

import org.openqa.selenium.WebDriver;
import pages.CommonPage;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

/**
 * Class that contains functions that help with PageObject classes
 */
public class PagesSupport {

    /**
     * Function that is used to reinitialize every descendant of a CommonPage inside a class
     * Used to refresh page objects after driver session recreation through reflective invocation of PageObject constructors
     *
     * @param testClass - Class that contains PageObjects e.g. MobileAppTest
     * @param driver    - driver instance that would be used to recreate PageObjects
     */
    public static void reinitializePages(Object testClass, Object driver) {
        List<Field> fields = Arrays.asList(testClass.getClass().getDeclaredFields());
        for (Field field : fields) {
            if (isChildClassOf(field.getType(), CommonPage.class)) {
                try {
                    Constructor cons = field.getType().getConstructor(WebDriver.class);
                    Object page = cons.newInstance(driver);
                    field.setAccessible(true);
                    field.set(testClass, page);
                } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
                         InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /**
     * Internal method that is used to define if a class is a child class of another class
     * @param toCheck Class that would be checked
     * @param parent Possible parent class
     * @return boolean result of a check
     */
    private static boolean isChildClassOf(Class toCheck, Class parent) {
        if (toCheck.equals(Object.class) || toCheck.getSuperclass() == null) {
            return false;
        } else {
            if (toCheck.equals(parent)) {
                return true;
            } else {
                return isChildClassOf(toCheck.getSuperclass(), parent);
            }
        }
    }
}
