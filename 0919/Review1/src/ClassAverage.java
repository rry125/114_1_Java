import java.util.Scanner;

public class ClassAverage {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // 建立 Scanner 物件以讀取使用者輸入

        int total = 0; // 用來累加所有分數
        int gradeCounter = 0; // 計算輸入的分數數量

        System.out.print("輸入完成請按ctrl-z離開[Windows]或ctrl-d離開[Mac]: "); // 提示使用者如何結束輸入

        // 當有輸入時持續執行迴圈
        while (input.hasNext()) {
            if (input.hasNextInt()) { // 檢查是否為整數
                int grade = input.nextInt(); // 讀取一個分數
                total += grade; // 累加分數
                gradeCounter++; // 分數計數器加一
            } else {
                System.out.println("輸入錯誤，請輸入整數分數，請繼續下一筆輸入。"); // 通知使用者並提示繼續
                input.next(); // 跳過錯誤輸入
            }
        }
                System.out.println("輸入錯誤，請輸入整數分數。");
        if (gradeCounter != 0) { // 確保有輸入分數
            double average = (double) total / gradeCounter; // 計算平均分數
            System.out.printf("總分: %d%n", total); // 輸出總分
            System.out.printf("分數數量: %d%n", gradeCounter); // 輸出分數數量
            System.out.printf("平均分數: %.2f%n", average); // 輸出平均分數，保留兩位小數
        } else {
            System.out.println("沒有輸入任何分數。"); // 如果沒有輸入分數，提示使用者
        }
    }
}
