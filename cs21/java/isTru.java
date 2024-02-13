public class isTru
{
	public static void main(String[] args)
	{
		boolean a = false;
		boolean b = true; 
		boolean c = a && b; 
		System.out.println(c); //false
		boolean d = a || b;
		System.out.println(d); //true
		boolean e = !a;
		System.out.println(e); //true
		
		boolean fin = (d && e) || c; 
		System.out.println(fin); //true
		
		//logic circuits
	}
}