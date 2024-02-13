public class LogExer //Last class syndrome 
{
	public static void main (String[] args)
	{
		System.out.println("Prove that x in the formula logb(n) = logx(n) / logx(b) can be any possible base number.");
		System.out.println("Solution: ");
		System.out.println("let b be 2 and n be 8");
		double seminar = Math.log(8); 
		double in = Math.log(2);
		double college = Math.log10(8);
		double algebra = Math.log10(2);
		double B = seminar / in;
		double F = college / algebra;
		System.out.println("Let x be e");
		System.out.println("ln (8) = " + seminar); //*ln = log e and log = log 10 
		System.out.println("ln (2) = " + in);
		System.out.println("ln (8) / ln (2) = " + B);
		System.out.println("Let x be 10");
		System.out.println("log (8) = " + college);
		System.out.println("log (2) = " + algebra);	
		System.out.println("log (8) / log (2) = " + F);
		System.out.println("ln (8) / ln (2) = log (8) / log (2)");
		System.out.println("Therefore, x can be any possible base number.");
	}
}
//use clear to clear terminal screen