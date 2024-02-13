import java.util.*;
public class ProbD
{public static void main(String args[])
{Scanner sc=new Scanner (System.in);
int N=sc.nextInt();
System.out.print("Alice: ");
System.out.println(3*N*N+2*N-4);
System.out.print("Bob: ");
System.out.println(N*N*N+N*N+N);
System.out.print("Cindy: ");
System.out.println((3*N*N+2*N-4)*(N*N*N+N*N+N)%2);
System.out.print("Doug: ");
System.out.println("0");

}}
//a b c d e f g i think i know the pattern here...
//haha
//note to self: make sure to apply pmdas