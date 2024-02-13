#include <iostream> 
#include <string> 
#include <cstdio> 
#include <cstdlib>
using namespace std; 

struct Point3D {

int x;
int y;
int z;

};

void MHDistance(Point3D* x, int lim)
{
	int count = 0; 
	while(count < lim - 1)
	{
		Point3D* next = x + 1; 
		int mhd = abs(x->x - next->x) + abs(x->y - next->y) + abs(x->z - next->z);
		cout << mhd << endl; 
		x += 1; 
		count++; 
	}
}

int main(void)
{
	int cases; 
	cin >> cases; 
	for(int i = 0; i < cases; i++)
	{
		int points; 
		cin >> points; 
		Point3D p[points]; 
		for(int j = 0; j < points; j++)
		{
			int sc = scanf("%d %d %d", &p[j].x, &p[j].y, &p[j].z); 
		}
		MHDistance(p, points); 
	}
	return 0; 
}