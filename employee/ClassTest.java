package employee;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassTest {
 private Object employee2;

public void main(String[] args) {

Class c = new Class();

System.out.println(c.getName());

 Method[] m= c.getDeclaredMethods();

 for (int i = 0; i< m.length;i++) {
 System.out.println(m[i]);

 }

Field[] f = c.getDeclaredFields();

 for (int i =0;i<f.length;i++) {

System.out.println(f[i]);
 }
 employee emp2 = new employee();

 Class c2 = employee2.getClass();


System.out.println(c.hashCode());

 System.out.println(c2.hashCode());

    }

}
