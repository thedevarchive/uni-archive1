import java.util.*;
public class HotOrCold
{public static void main(String args[])
{Scanner celsius=new Scanner(System.in);
double t=celsius.nextDouble();
if (t<=0)
{System.out.println("Freezing!");}
else if (0<t && t<=10)
{System.out.println("Really cold!");}
else if (10<t && t<=20)
{System.out.println("Cold.");}
else if (20<t && t<=40)
{System.out.println("Warm.");}
else
{System.out.println("Hot!");}
double c=celsius.nextDouble();
if (c<=0)
{System.out.println("Freezing!");}
else if (0<c && c<=10)
{System.out.println("Really cold!");}
else if (10<c && c<=20)
{System.out.println("Cold.");}
else if (20<c && c<=40)
{System.out.println("Warm.");}
else 
{System.out.println("Hot!");}
double f=celsius.nextDouble();
if (f<=0)
{System.out.println("Freezing!");}
else if (0<f && f<=10)
{System.out.println("Really cold!");}
else if (10<f && f<=20)
{System.out.println("Cold.");}
else if (20<f && f<=40)
{System.out.println("Warm.");}
else
{System.out.println("Hot!");}
double k=celsius.nextDouble();
if (k<=0)
{System.out.println("Freezing!");}
else if (0<k && k<=10)
{System.out.println("Really cold!");}
else if (10<k && k<=20)
{System.out.println("Cold.");}
else if (20<k && k<=40)
{System.out.println("Warm.");}
else 
{System.out.println("Hot!");}
}}