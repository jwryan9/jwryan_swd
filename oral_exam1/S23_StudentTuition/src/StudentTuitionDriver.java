/**
 * Created by jasonryan on 10/3/16.
 */
public class StudentTuitionDriver {
    public static void main(String[] args) {
        EngIowaUndergrad student1 = new EngIowaUndergrad("Student", "One", 1, 15);
        EngIowaGraduate student2 = new EngIowaGraduate("Student", "Two", 2, 10);
        EngIowaOpen student3 = new EngIowaOpen("Student", "Three", 3, 4);

        EngOutOfStateUndergrad student4 = new EngOutOfStateUndergrad("Student", "Four", 4, 14);
        EngOutOfStateGraduate student5 = new EngOutOfStateGraduate("Student", "Five", 5, 8);
        EngOutOfStateOpen student6 = new EngOutOfStateOpen("Student", "Six", 6, 3);

        EngForeignUndergrad student7 = new EngForeignUndergrad("Student", "Seven", 7, 17);
        EngForeignGraduate student8 = new EngForeignGraduate("Student", "Eight", 8, 9);
        EngForeignOpen student9 = new EngForeignOpen("Student", "Nine", 9, 4);

        LiberalIowaUndergrad student10 = new LiberalIowaUndergrad("Student", "Ten", 10, 14);
        LiberalIowaGraduate student11 = new LiberalIowaGraduate("Student", "Eleven", 11, 6);
        LiberalIowaOpen student12 = new LiberalIowaOpen("Student", "Twelve", 12, 2);

        LiberalOutOfStateUndergrad student13 = new LiberalOutOfStateUndergrad("Student", "Thirteen", 13, 16);
        LiberalOutOfStateGraduate student14 = new LiberalOutOfStateGraduate("Student", "Fourteen", 14, 11);
        LiberalOutOfStateOpen student15 = new LiberalOutOfStateOpen("Student", "Fifteen", 15, 2);

        LiberalForeignUndergrad student16 = new LiberalForeignUndergrad("Student", "Sixteen", 16, 14);
        LiberalForeignGraduate student17 = new LiberalForeignGraduate("Student", "Seventeen", 17, 9);
        LiberalForeignOpen student18 = new LiberalForeignOpen("Student", "Eighteen", 18, 5);

        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
        System.out.println(student4);
        System.out.println(student5);
        System.out.println(student6);
        System.out.println(student7);
        System.out.println(student8);
        System.out.println(student9);
        System.out.println(student10);
        System.out.println(student11);
        System.out.println(student12);
        System.out.println(student13);
        System.out.println(student14);
        System.out.println(student15);
        System.out.println(student16);
        System.out.println(student17);
        System.out.println(student18);

        // Update tuition rate and tuition owed by students
        Tuition.setBaseClassHourTuitionRate(200);
        System.out.println("Tuition rate changed to $200\n");

        student1.updateTuition();
        student2.updateTuition();
        student3.updateTuition();
        student4.updateTuition();
        student5.updateTuition();
        student6.updateTuition();
        student7.updateTuition();
        student8.updateTuition();
        student9.updateTuition();
        student10.updateTuition();
        student11.updateTuition();
        student12.updateTuition();
        student13.updateTuition();
        student14.updateTuition();
        student15.updateTuition();
        student16.updateTuition();
        student17.updateTuition();
        student18.updateTuition();

        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
        System.out.println(student4);
        System.out.println(student5);
        System.out.println(student6);
        System.out.println(student7);
        System.out.println(student8);
        System.out.println(student9);
        System.out.println(student10);
        System.out.println(student11);
        System.out.println(student12);
        System.out.println(student13);
        System.out.println(student14);
        System.out.println(student15);
        System.out.println(student16);
        System.out.println(student17);
        System.out.println(student18);

    }
}
