package oop;

/*
We have declared the obj volatile which ensures that multiple threads offer the obj
variable correctly when it is being initialized to Singleton instance.
This method drastically reduces the overhead of calling the synchronized method every time.
 */
class SingleTon{
	
	private SingleTon() {               // constructor
		System.out.println("Hello");
	}
	private static volatile SingleTon st = null;

	public static SingleTon getInstance() {	
		if (st == null) 
		{
			synchronized(SingleTon.class) 
			{
				if(st == null)
					st = new SingleTon();
		    }
		}
		return st;
	}
}

public class TestSingleTon {
	public static void main(String[] args) {
		SingleTon s = SingleTon.getInstance();
		SingleTon s1 = SingleTon.getInstance();
		System.out.println(s.hashCode());
		System.out.println(s1.hashCode());
	}
}
