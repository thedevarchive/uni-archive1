#include <iostream> 
#include <cstdlib> 
using namespace std; 

int main(void)
{
	int i; string s; 
	cin >> s; 
	i = atoi(s.c_str()); 
	//s.c_str() == s.toCharArray(); 
	cout << "Converted: " << i << endl; 
	return 0; 
}