package Generic;

public interface GenericInterface<T> {
	//can't use generic type on the fields in an interface, because all fields are static
	//T field;
	
	void method(T t);
	
	T method2(T t);
	
}
