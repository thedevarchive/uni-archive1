#include <iostream> 
using namespace std; 


int main(void) 
{
	int i; 
	int *p; 
	p = &i; 
	i = 5; 
	
	cout << *p << endl; 
	
	*p = 10; 
	
	cout << *p << endl; 
	cout << p << endl; 
	
	int a = *p; 
	
	cout << a << endl; 
	
	return 0; 
}