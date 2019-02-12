import Bean.Box;
import Bean.Box3;
import Bean.Box5;

import java.util.*;

/**
 * Created by AlexHe on 2019-02-12.
 * Describe 作業 3 郵局便利箱
 * 假設郵局有兩種便利箱:
 * Box3: 長23，寬14，高13 (cm)
 * Box5: 長39.5，寬27.5，高23 (cm)
 * 1. 請利用物件導向的類別設計這兩個類別，並在這兩個類別(Box3與Box5)中設計方法:
 * 	 public boolean validate(float length, float width, int height) {
 *
 *           }
 *     並在這方法中設計會回傳(boolean)該箱子是否能容納傳入的長、寬、高的物體。
 *
 * 2. 建立BoxTester類別，程式的main方法中設計讓使用者輸入他想寄送物件的長寬高，並利用Box5與Box3兩個類別完成以下的設計:
 * 	   Please enter object's length: 15
 * 	   Please enter object's width: 18
 * 	   Please enter object's height: 10
 * 	   Box5
 * 	      或
 * 	   Please enter object's length: 20
 * 	   Please enter object's width: 11
 * 	   Please enter object's height: 9
 * 	   Box3
 */

public class BoxTester {
    private static String selectedBox = "";

    public static void main(String[] args) {
        System.out.println("\n===============Java===============");

        Box box3 = new Box3();
        Box box5 = new Box5();
        Map<String, Box> boxList = new HashMap<>();
        boxList.put("Box3", box3);
        boxList.put("Box5", box5);
        boolean work = false;

        System.out.println("Please select box : \n" +
                " * Box3: 長23，寬14，高13 (cm)\n" +
                " * Box5: 長39.5，寬27.5，高23 (cm)");
        Scanner scanner = new Scanner(System.in);
        //selectBox
        selectBox(boxList, work, scanner);
        //inputBoxInfo
        inputBoxInfo(boxList, work, scanner);
        System.out.println("成功寄出！");
    }

    private static void inputBoxInfo(Map<String, Box> boxList, boolean work, Scanner scanner) {
        System.out.print("Please enter object's length: ");
        float length = scanner.nextFloat();
        System.out.print("Please enter object's width: ");
        float width = scanner.nextFloat();
        System.out.print("Please enter object's height: ");
        float height = scanner.nextFloat();
        if (boxList.get(selectedBox).validate(length, width, height) == false){
            selectBox(boxList, work, scanner);
            inputBoxInfo(boxList, work, scanner);
        }
    }

    private static void selectBox(Map<String, Box> boxList, boolean work, Scanner scanner) {
        while (work == false) {
            selectedBox = scanner.next();
            for (Box box : boxList.values()) {
                if (selectedBox.equals(box.getName())) {
                    System.out.println("You selected: " + box.getName());
                    work = true;
                }
            }
            if (work == false) {
                System.out.println("Error, Please enter again.");
            }
        }
    }
}
