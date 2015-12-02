package testthread;

class Elephant extends Thread{

	@Override
	public void run() {
		for(int i=1;i<=20;i++){
			System.out.println("����"+i+" ");
		}
	}
	
}

class House extends Thread{

	@Override
	public void run() {
		for(int i=1;i<=20;i++){
			System.out.println("����"+i+" ");
		}
	}
	
}

class MainThread implements Runnable{

	@Override
	public void run() {
		for(int i=1;i<=20;i++){
			System.out.println("����"+i+" ");
		}
	}
	
}

public class TestThread {

	public static void main(String[] args) {
		Elephant elephant = new Elephant();
		House house = new House();
		elephant.start();
		house.start();
		MainThread mainThread = new MainThread();
		Thread main = new Thread(mainThread);
		main.start();
	
	}

}
