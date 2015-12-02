package duotai;

interface Car{
	abstract public void cautionSound();
}

class PoliceCar implements Car{

	@Override
	public void cautionSound() {
		System.out.println("fuck....fuck....");
		
	}
	
}

class AmbulanceCar implements Car{

	@Override
	public void cautionSound() {
		System.out.println("cao....cao....");
		
	}
	
}

public class TestDuoTai {
	public static void main(String[] args) {
		Car car;
		car = new PoliceCar();
		car.cautionSound();
		car = new AmbulanceCar();
		car.cautionSound();
	}
}
