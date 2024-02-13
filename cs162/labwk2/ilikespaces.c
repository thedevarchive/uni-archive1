#include <iostream> 
#include <cstdio> 
using namespace std; 
int main(void)
{
	const int SIZE = 80; 
	char s[SIZE]; 
	printf("Input a string: ");
	fgets(s, SIZE, stdin); 
	printf("You typed: %s\n", s); 
	return 0; 
}