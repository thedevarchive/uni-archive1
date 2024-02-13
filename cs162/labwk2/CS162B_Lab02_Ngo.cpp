#include <iostream> 
#include <string> 
#include <cstdio>
using namespace std; 

int main(void)
{
	int cases; 
	cin >> cases; 
	for(int i = 1; i <= cases; i++)
	{
		int x, y; 
		int ret = scanf("%d %d", &x, &y); 
		cout << "Agent#" << i << " is at (" << x << ", " << y << ")" << endl; 
		string message; 
		getline(cin, message); 
		cout << "Says:" << message << endl; 
	}
	return 0; 
}