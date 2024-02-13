 // taken from https://proprogramming.org/c-program-to-implement-IntStack-using-linked-list/
 // destructor from https://stackoverflow.com/questions/15672812/destructor-for-a-linked-list

#include <iostream>
using namespace std;

//   Creating an IntNode Structure
struct IntNode
{
    int data;
    struct IntNode *next;
};
 
// IntStack struct 
struct IntStack
{
    struct IntNode *top;
    public:
    IntStack() // constructor
    {
        top=NULL;
    }
    void push()
    {
        int value;
        struct IntNode *ptr;
        cout<<"Enter a number: ";
        cin>>value;
        ptr=new IntNode;
        ptr->data=value;
        ptr->next=NULL;
        if(top!=NULL) ptr->next=top;
        top=ptr;
        cout<< value << " is pushed in the stack." << endl;
    
    }
    
    // POP Operation
    void pop()
    {
        struct IntNode *temp;
        if(top==NULL)
        {
            cout<<"Stack is empty." << endl;
        }
        temp=top;
        top=top->next;
        cout<< temp->data << " is removed from the top of stack." << endl;
        delete temp;
    }
    
    // Show IntStack
    // prints from top of stack down to the bottom
    void show()
    {
        struct IntNode *ptr1=top;
        cout<<"Stack contents: ";
        while(ptr1!=NULL)
        {
            cout<<ptr1->data<<" ";
            ptr1=ptr1->next;
        }
        cout << endl;
        
    }

    //destructor
    ~IntStack(void)
    {
        struct IntNode* temp;
        while (top != NULL)
        {
            temp = top->next;
            delete top;
            top = temp;
        }
    }
};