package com.mz.project02;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

// this code show how the spring manages the object and creates for me 
// 47:47 end of the lecture
public class App 
{
    public static void main( String[] args )
    {
    	// XmlBeanFactory this is the first class that used to implement the BeanFactory he is outdated so that is why he is crossed out
    	//BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
    	
    	// this class is newer and gives more tools 
    	// ApplicationContext this creates a container inside the JVM which will have spring beans waht is bean is any class that has certain variables 
    	// and every variable will have getter and setter that is classes Bean 
    	ApplicationContext factory = new ClassPathXmlApplicationContext("spring.xml"); 
    	// When i mention in the spring.xml with tag bean it will create me a object even if i will not use but if i will then i must manage it by myself
       
//       Alien obj1 = (Alien)factory.getBean("alien");
//       obj1.code();
//       obj1.age = 123;
//       System.out.println(obj1.age);
//       
//       
//       Alien obj2 = (Alien)factory.getBean("alien");
//       obj2.code();
//       System.out.println(obj2.age);
//       
       // here the output: Alien Object Created
//       im coding...
//       123
//       im coding...
//       123
       // this means that the both both reference are pointing to the one object 
       // like first i ask the Container for the first object i gives me then i ask the again and it see that it has already object so it will not create new object it will give the previous one
       
       // by default the spring container has a Singleton Design Pattern and will give me one object 
       
       
       // |Sections with the private and setters and getters|
       
       Alien obj1 = (Alien)factory.getBean("alien");
       obj1.code();
       
       System.out.println(obj1.getAge());
       
       
    }
}