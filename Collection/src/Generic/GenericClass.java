package Generic;

public class GenericClass<T> /* the generic type T declared here will be the same type for all generic fields in this class */{
	
	//the T below is the same type as the T in class name
	private T field;
	
	//cannot use generic types on static fields, you know why.
	//private static T field2;
	

	public T getField() {
		return field;
	}

	public void setField(T field) {
		this.field = field;
	}
	
	public GenericClass(){
		
	}
	
	public GenericClass(T field) {
		this.field = field;
	}

	public static void main(String[] args) {
		
	}

}
