package fr.aelion.helpers.dto;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class DtoMapper {
    /**
     * Transform m to o
     *
     * @param m Media to transform
     * @param o Media to obtain
     */
    public Object map(Object m, Object o) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Field[] oFields = o.getClass().getDeclaredFields();
        String[] fields = new String[oFields.length];

        int i = 0;
        for (Field oField : oFields
        ) {
            fields[i] = oField.getName();
            i++;
        }
        i = 0;
        for (String property : fields) {
            String getter = "get" + property.substring(0, 1).toUpperCase() + property.substring(1);
            Method method = m.getClass().getSuperclass().getDeclaredMethod(getter, null);
            oFields[i].set(o, method.invoke(m, null));
            i++;
        }


        return o;
    }
}
