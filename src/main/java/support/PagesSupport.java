package support;

import org.openqa.selenium.WebDriver;
import pages.CommonPage;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

public class PagesSupport {

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
