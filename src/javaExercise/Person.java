package javaExercise;

import java.util.Arrays;
import java.util.Comparator;

/**
 * comparable是排序接口，如果一个类实现了Comparable接口，就意味着它支持排序 实现compareTo()方法
 * 实现了comparable接口的类或者对象可以通过Collections.sort或者Arrays.sort进行自动排序，无需指定比较器
 * 
 * comparator是比较接口，通过comparator来实现一个比较器，通过这个比较器对类进行排序。实现compare(T o1,T o2)函数。
 * 返回负数意味着o1比o2小
 * 返回整数意味着o1比o2大
 * 返回0意味两数相等
 * 
 * @author mqh 2018年9月10日
 *
 */
public class Person implements Comparable<Person> {
	/**
	 * 
	 */
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	private int age;
	
	public Person(String name,int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return this.age - o.age;
	}
    
	public static void main(String[] args) {
		Person[] persons = new Person[] {new Person("zhangsan", 20),new Person("lisi", 19)};
		System.out.println("排序前：");
		for(Person person:persons) {
			System.out.print(person.getName()+" 年龄："+person.getAge()+",");
		}
		Arrays.sort(persons);
		Arrays.sort(persons, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				// TODO Auto-generated method stub
				return o1.age-o2.age;
			}
		});
		System.out.println();
		System.out.println("排序后：");
		for(Person person:persons) {
			System.out.print(person.getName()+" 年龄："+person.getAge()+",");
		}
	}
}
