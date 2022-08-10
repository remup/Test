import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.IntStream;

class TestSleepMethod1 extends Thread{    
 public void run(){    
  for(int i=1;i<5;i++){   
  // the thread will sleep for the 500 milli seconds   
    try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}    
    System.out.println(i);    
  }    
 }    
 public static void main(String args[]) throws InterruptedException, MalformedURLException{    
  TestSleepMethod1 t1=new TestSleepMethod1();    
  TestSleepMethod1 t2=new TestSleepMethod1();    
     
  //t1.start();    
  //t2.start();    
  
  Collection<Integer> syncCollection = new ArrayList<>();
  Runnable listOperations = () -> {
      syncCollection.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));
  };
  
  Thread thread1 = new Thread(listOperations);
  Thread thread2 = new Thread(listOperations);
  thread1.start();
  //thread2.start();
  //thread1.join();
  //thread2.join();
  System.out.println(syncCollection.size());
  
  int arr[] = new int  [] {2, 1, 2, 0, 1, 2, 2, 1, 0};
  
 
  System.out.println("array "+arr);
  //Arrays.sort(arr);
  TreeSet<Integer> treeset = new TreeSet<Integer>(new StringComparator());
  for(int s:arr) {
 
  System.out.println(s+"sorted");
  treeset.add(s);
  }
  
  treeset.forEach((q)->System.out.println("testOne"+q));
  
  ArrayList<Integer> arrlist = new ArrayList<>();
  for(int s1:arr)
  {
	  arrlist.add(s1);
  }
  System.out.println("arrayList "+arrlist);
  arrlist.forEach((d)->System.out.println("arrayList"+d));
  TreeSet<Integer> t = new TreeSet<Integer>(arrlist);
//  TreeSet<Integer> t = new TreeSet<Integer>();
//  t.add(1);
//  t.add(1);
//  t.add(0);
  for(Integer t21:t) {
	  System.out.println("treeset"+t21);
  }
  
  t.forEach((d)->System.out.println(d));
  
  String stringArr[]= {"r","a"};
  //List l = new ArrayList<String>(Arrays.asList(stringArr));
  List l = Arrays.asList(stringArr);
  Collections.sort(l);
  System.out.println(l);
 
  HashMap<String, Integer> domainNames = new HashMap<>();
  domainNames.put("google.com", 10);
  domainNames.put("chat.google.com", 20);
  domainNames.put("xyz.com", 30);
  domainNames.put("ht.in", 40);
  
  System.out.println("");
  int arr3[] = {2, 1, 2, 0, 1, 2, 2, 1, 0};
  Integer[] boxedArray = Arrays.stream(arr3).boxed().toArray(Integer[]::new);
  List<Integer> arrayIntegers = Arrays.asList(boxedArray);
 Collections.sort(arrayIntegers);
  System.out.println(arrayIntegers);
  
 }    
 
 
}   

class StringComparator implements Comparator<Integer>
{
    @Override
    public int compare(Integer s1, Integer s2)
    {
    	int f = 0;
        if(s1==s2){
            f= -1;
        }
        if(s1<s2){
            f =-1;
        }
        if(s1>s2){
            f= 1;
        }
		return f;
    }
}



