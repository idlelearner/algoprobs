package code.designpatterns;

public class EnumSingleton {
	public enum SingletonEnum {
		INSTANCE;
		public void doStuff() {
			System.out.println("Singleton using Enum");
		}
	}

	// And this can be called from clients :
	public static void main(String[] args) {
		SingletonEnum.INSTANCE.doStuff();

	}
}