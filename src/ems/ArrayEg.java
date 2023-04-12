 import static java.lang.Math.*;

class Employee{

	private int eid;
	private String ename;

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + "]";
	}
	

}

class ArrayEg
{
	public static void main(String[] args)
  	{
		int[] arr = new int[3];
		arr[0]=1;
		arr[1]=2;	
		arr[2]=3;

		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}

		for(int i : arr)
		{
			System.out.println(i);
		}

		Employee e1 = new Employee();
		e1.setEname("Malar");
		Employee e2 = new Employee();
		e2.setEname("Bala");

		Employee[] empArr = new Employee[2];
		
		empArr[0]=e1;
		empArr[1]=e2;

		for(Employee i : empArr)
		{
			System.out.println(i);
		}


		System.out.println(PI);

	}

}

















