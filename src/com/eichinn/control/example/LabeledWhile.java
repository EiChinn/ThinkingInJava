package com.eichinn.control.example;

/**
 * Created by ei_chinn on 2016/11/12.
 */
public class LabeledWhile {
    public static void main(String[] args) {
        int i = 0;
        //标签起作用的唯一地方刚好是在循环语句之前，且在标签和迭代之间插入任何语句都是不推荐的
        //使用标签的唯一理由就是因为有循环嵌套存在，而且想从多层嵌套中break或continue
        outer:
        while (true) {
            System.out.println("Outer while loop");
            while (true) {
                i++;
                System.out.println("i = " + i);

                if (i == 1) {
                    System.out.println("continue");
                    continue;//一般的continue会退回最内层循环的开头，并继续执行
                }

                if (i == 3) {
                    System.out.println("continue outer");
                    continue outer;//带标签的continue会跳转到标签的位置，并重新进入紧接在那个标签后面的循环
                }

                if (i == 5) {
                    System.out.println("break");
                    break;//一般的break会中断并跳出当前循环
                }

                if (i == 7) {
                    System.out.println("break outer");
                    break outer;//带标签的break会中断并跳出标签所指（紧接在那个标签后面）的循环
                }
            }
        }
    }
}
