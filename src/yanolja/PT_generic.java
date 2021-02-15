package yanolja;

class TestH<T>{
	
	private T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	
	public <U> void print(U u) {
		System.out.println(u);
		System.out.println("t¿« class"+t.getClass().getName());
		System.out.println("u¿« class"+u.getClass().getName());
	}
}

public class PT_generic {

	public static void main(String[] args) {

		TestH<String> th=new TestH<String>();
		th.setT("SIBAL");
		System.out.println(th.getT());
		
		th.print("nana");
		System.out.println();
		th.print(234);
	}

}
