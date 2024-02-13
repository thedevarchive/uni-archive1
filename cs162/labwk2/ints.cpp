#include <iostream> 
#include <cstdio> 
using namespace std; 

int main(void)
{
	int i, j; 
	cout << "Enter 2 ints separated by a space: "; 
	int ret = scanf("%d %d", &i, &j); 
	cout << "scanf() returned: " << ret << endl; 
	cout << "Checking i: " << i << endl; 
	cout << "Checking j: " << j << endl; 
	return 0; 
}