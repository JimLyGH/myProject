package com.jimly.kayak.cases.demo8;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class ExternalizableTest implements Externalizable{
	
	private transient String content = "我被transient修饰了,我也会被序列化";

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(content);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		content = (String) in.readObject();
	}
	
	@Override
	public String toString() {
		return content;
	}

}
