#include <iostream> 

using namespace std; 

void myFunction() 
{
	cout << "inside myFunction()" << endl; 
} 

int addTwoV1(int x) 
{
	x += 2; 
	return x; 
}

int addTwoV2(int* x) 
{
	*x += 2; 
	return *x; 
}

int main(void) 
{
	myFunction(); 
	int a = 5; 
	int *p = &a; 
	cout << addTwoV1(a) << endl; 
	cout << addTwoV2(p) << endl; 
	return 0; 
}