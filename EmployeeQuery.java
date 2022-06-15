// Tu Pham & Matt Le
import java.util.*;
import java.lang.reflect.*;

/** A class that lets a user query data from an employee */
public class EmployeeQuery {
  
  /**
   * The program has a loop that lets a user enter queries about an employee and stops when
   * the user enters "quit".
   * @param args  the command line arguments are ignored
   */
  @SuppressWarnings("Warning")
  public static void main(String[] args) {
    Employee e = Employee.testEmployee();                // a sample employee
    Class c = e.getClass();
    Scanner scanner = new Scanner (System.in);           // to parse data the user types in
    String nextCommand;
    Method method = null;
    // until the user enters "quit", get the next input from the user, and if it matches
    // a given command, get the desired information from the employee object
    do {
      System.out.print("Enter command >> ");
      nextCommand = scanner.next();
      try{
        if (nextCommand.equals("getName")) {
          method = c.getMethod("getName", new Class[0]);
          System.out.println(method.invoke(e, new Object[0]));
        } else if (nextCommand.equals("getAddress")) {
          method = c.getMethod("getAddress", new Class[0]);
          System.out.println(method.invoke(e, new Object[0]));
        } else if (nextCommand.equals("getCity")) {
          method = c.getMethod("getCity", new Class[0]);
          System.out.println(method.invoke(e, new Object[0]));
        }
        else if(nextCommand.equals("setName")){
          System.out.println("First name: ");
          String param1 = scanner.next();
           System.out.println("Middle name: ");
          String param2 = scanner.next();
           System.out.println("Last name: ");
          String param3 = scanner.next();
          method = c.getMethod("setName", "".getClass(), "".getClass(), "".getClass());
          method.invoke(e, param1, param2, param3);
        }
      }
      catch(NoSuchMethodException exception){
        System.out.println("No methods match");
      }
      catch(IllegalAccessException exception){
        System.out.println("Illegal access");
      }
      catch(InvocationTargetException exception){
      }
    } while (! nextCommand.equals("quit"));
  }
}
