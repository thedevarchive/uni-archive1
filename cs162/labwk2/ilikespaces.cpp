#include <iostream> 
#include <string> 
using namespace std; 

int main(void)
{
	string s; 
	cout << "Input a string: "; 
	getline(cin, s); 
	cout << "You typed: " << s << endl; 
	return 0; 
}