#include <cstdlib> 
#include <iostream> 

using namespace std; 

void changeChar(char* c)
{
	if(*c == 'a') *c = 'b'; 
	else if(*c == 'b') *c = 'c'; 
	else if(*c == 'c') *c = 'd'; 
	else if(*c == 'd') *c = 'e'; 
	else if(*c == 'e') *c = 'f'; 
	else if(*c == 'f') *c = 'g'; 
	else if(*c == 'g') *c = 'h'; 
	else if(*c == 'h') *c = 'i'; 
	else if(*c == 'i') *c = 'j'; 
	else if(*c == 'j') *c = 'k'; 
	else if(*c == 'k') *c = 'l'; 
	else if(*c == 'l') *c = 'm'; 
	else if(*c == 'm') *c = 'n'; 
	else if(*c == 'n') *c = 'o'; 
	else if(*c == 'o') *c = 'p'; 
	else if(*c == 'p') *c = 'q'; 
	else if(*c == 'q') *c = 'r'; 
	else if(*c == 'r') *c = 's'; 
	else if(*c == 's') *c = 't'; 
	else if(*c == 't') *c = 'u'; 
	else if(*c == 'u') *c = 'v'; 
	else if(*c == 'v') *c = 'w'; 
	else if(*c == 'w') *c = 'x'; 
	else if(*c == 'x') *c = 'y'; 
	else if(*c == 'y') *c = 'z'; 
	else if(*c == 'z') *c = 'a'; 
	else if(*c == 'A') *c = 'B'; 
	else if(*c == 'B') *c = 'C'; 
	else if(*c == 'C') *c = 'D'; 
	else if(*c == 'D') *c = 'E'; 
	else if(*c == 'E') *c = 'F'; 
	else if(*c == 'F') *c = 'G'; 
	else if(*c == 'G') *c = 'H'; 
	else if(*c == 'H') *c = 'I'; 
	else if(*c == 'I') *c = 'J'; 
	else if(*c == 'J') *c = 'K'; 
	else if(*c == 'K') *c = 'L'; 
	else if(*c == 'L') *c = 'M'; 
	else if(*c == 'M') *c = 'N'; 
	else if(*c == 'N') *c = 'O'; 
	else if(*c == 'O') *c = 'P'; 
	else if(*c == 'P') *c = 'Q'; 
	else if(*c == 'Q') *c = 'R'; 
	else if(*c == 'R') *c = 'S'; 
	else if(*c == 'S') *c = 'T'; 
	else if(*c == 'T') *c = 'U'; 
	else if(*c == 'U') *c = 'V'; 
	else if(*c == 'V') *c = 'W'; 
	else if(*c == 'W') *c = 'X'; 
	else if(*c == 'X') *c = 'Y'; 
	else if(*c == 'Y') *c = 'Z'; 
	else if(*c == 'Z') *c = 'A'; 
	
}

int main(void) 
{
	string name; 
	cin >> name; 
	cout << name << endl; 
	cout << name[0]; 
	for(int i = 1; i < name.length(); i++)
	{
		cout << "#"; 
	}
	cout << endl; 
	for(int i = 0; i < name.length(); i++)
	{
		changeChar(&name[i]); 
	}
	cout << name << endl; 
	
	return 0; 
}