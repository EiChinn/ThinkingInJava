package com.eichinn.control.example;

/**
 * Created by ei_chinn on 2016/11/12.
 */
public class LabeledFor {
    public static void main(String[] args) {
        int i = 0;
        //标签起作用的唯一地方刚好是在迭代语句之前，且在标签和迭代之间插入任何语句都是不推荐的
        //使用标签的唯一理由就是因为有循环嵌套存在，而且想从多层嵌套中break或continue
        outer://Can't have statements here
        for(; ;) {
            //标签起作用的唯一地方刚好是在迭代语句之前，且在标签和迭代之间插入任何语句都是不推荐的
            inner://Can't have statements her
            for (; i < 10; i++) {
                System.out.println("i = " + i);
                if (i == 2) {
                    System.out.println("continue");
                    continue;//一般的continue会退回最内层循环的开头，并继续执行
                }

                if (i == 3) {
                    System.out.println("break");
                    i++;//Otherwise i never gets incremented
                    break;//一般的break会中断并跳出当前循环
                }

                if (i == 7) {
                    System.out.println("continue outer");
                    i++;//Otherwise i never gets incremented
                    //跳过后面的语句转到标签outer处继续迭代过程
                    continue outer;//带标签的continue会跳转到标签的位置，并重新进入紧接在那个标签后面的循环
                }

                if (i == 8) {
                    System.out.println("break outer");
                    //中断所有迭代并回到outer处，但并不重新进入迭代，而是继续迭代代码块后面的语句
                    break outer;//带标签的break会中断并跳出标签所指（紧接在标签后面）的循环
                }

                for (int j = 0; j < 5; j++) {
                    if (j == 3) {
                        System.out.println("continue inner");
                        //跳过后面的语句转到标签inner处继续迭代过程
                        continue inner;//带标签的continue会跳转到标签的位置，并重新进入紧接在那个标签后面的循环
                    }
                }

            }
        }
    }
}
