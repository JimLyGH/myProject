java反射机制: JAVA反射机制是在运行状态中，
			对于任意一个类，都能够知道这个类的所有属性和方法；
			对于任意一个对象，都能够调用它的任意一个方法和属性；
			这种动态获取的信息以及动态调用对象的方法的功能称为java语言的反射机制。

简而言之: 就是根据一个已经实例化了的对象来还原类的完整信息


getFields()与getDeclaredFields()区别:
	getFields()只能访问类中声明为公有的字段,私有的字段它无法访问，能访问从其它类继承来的公有字段.
	getDeclaredFields()能访问类中所有的字段,与public,private,protect无关，不能访问从其它类继承来的字段 

getMethods()与getDeclaredMethods()区别:
	getMethods()只能访问类中声明为公有的方法,私有的方法它无法访问,能访问从其它类继承来的公有方法.
	getDeclaredFields()能访问类中所有的字段,与public,private,protect无关,不能访问从其它类继承来的方法  

getConstructors()与getDeclaredConstructors()区别:
	getConstructors()只能访问类中声明为public的构造函数.
	getDeclaredConstructors()能访问类中所有的构造函数,与public,private,protect无关