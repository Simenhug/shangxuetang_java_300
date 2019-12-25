package com.simen.composite;

public interface Component {
	void operation();
}

interface Leaf extends Component{
	
}

interface Composite extends Component{
	public void add(Component c);
	public void remove(Component c);
	public Component getChild(int index);
}