#include <iostream> 
#include <string> 
using namespace std; 

int main(void)
{
	int cases; 
	cin >> cases; 
	for(int i = 1; i <= cases; i++)
	{
		int x, y; 
		int ret = scanf("%d %d", &i, &j); 
		cout << "Agent#" << i << " is at (" << i << ", " << j << ")" << endl; 
		string message; 
		getline(cin, message); 
		cout << "Says: " << message << endl; 
	}
	return 0; 
}