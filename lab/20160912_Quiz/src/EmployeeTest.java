// Fig. 8.9: EmployeeTest.java
// Composition demonstration.

public class EmployeeTest {
    public static void main(String[] args) {
        Date birth = new Date(7, 24, 1949);
        Date hire = new Date(3, 12, 1988);
        Employee employee1 = new Employee("Bob", "Blue", birth, hire);
        System.out.println(employee1);

        birth = new Date(8,8,1988);
        hire = new Date(9,9,2001);
        Employee employee2 = new Employee("Sally", "Red", birth, hire);
        System.out.println(employee2);

        employee2.setBirthDate(new Date(1,2,1983));
        employee2.setHireDate(new Date(4,2,1999));
        System.out.println(employee2);

        System.out.println(employee1);
    }
} // end class EmployeeTest


/**************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
