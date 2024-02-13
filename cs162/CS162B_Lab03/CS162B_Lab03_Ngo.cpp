#include <iostream>
#include "CS162B_Lab03_Ngo.hpp"
using namespace std;
 
 // taken from https://proprogramming.org/c-program-to-implement-stack-using-linked-list/
 
// Main function
int main()
{
    IntStack s;
    string choice;
    while(1)
    {

        cout << "Please enter a command." << endl; 
        cout << "CHOICES: push, pop, display, exit (case sensitive)" << endl; 
        cin >> choice; 

        if(choice == "push")
        {
            s.push(); 
        }
        else if (choice == "pop")
        {
            s.pop(); 
        }
        else if(choice == "display")
        {
            s.show(); 
        }
        else if (choice == "exit")
        {
            return 0; 
            break; 
        }
        else
        {
            cout << endl; 
            cout << "Command not recognized."; 
        }
        cout << endl; 
    }
    return 0;
}