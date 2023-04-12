class MyOuter
{
	int x =7;
	class MyInner
	{
		public void InnerMethod()
		{
			System.out.println("x == " + x);
		}
	}
	public void OuterMethod()
	{
		System.out.println("From outer method = " + x);
		MyInner inn = new MyInner();
		inn.InnerMethod();
	}
	public static void main(String[] a)
	{
	MyOuter mo = new MyOuter();
	//MyInner inn = new MyInner(); //invalid
	//inn.InnerMethod();
	//<outerclassname>.<innerclassname> objname = <outerclass instancename>.new <innerclassname>();
	MyOuter.MyInner mi = mo.new MyInner(); //instantiate inner class
	mi.InnerMethod();
	mo.OuterMethod();
	//mi.OuterMethod();  illegal
	//mo.InnerMethod();   illegal 
		
	}

}

// Check whether the inner class can be abstract
// can it be inherited?
// scope of instance variable within the inner class 
// scope of local variable within the inner class







