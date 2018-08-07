package javaExercise;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 List<MyObject> list = new ArrayList<>();
         for (int i = 0; i < 10; i++) {
             list.add(new MyObject(i));
         }

         System.out.println(list.toString());

         Iterator<MyObject> iterator = list.iterator();//集合元素的值传给了迭代变量，仅仅传递了对象引用。保存的仅仅是指向对象内存空间的地址
         while (iterator.hasNext()) {
             MyObject next = iterator.next();
             next.num = 99;
         }

         System.out.println(list.toString());
	}
  static class MyObject {
        int num;

        MyObject(int num) {
            this.num = num;
        }

        @Override
        public String toString() {
            return String.valueOf(num);
        }
    }

}
