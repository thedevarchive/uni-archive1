#include <iostream>
#include <math.h>
#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <cmath>

void *sin( void *i );

long double *sum;
pthread_t * array;
int N;
double X;
long double *fact;
int curMaxFact;
int *nums;
long double min = 0.0000000000000001;

void factorial(int n)
{
	//Get factorial for number and change curMaxFact
	for(int i = 1; i <= n; i++)
		fact[i] = fact[i-1] * i;
}

int main(int argc, char* argv[])
{
	N = atoi(argv[1]);
	X = atof(argv[2]);

	sum = (long double*) malloc(sizeof(long double) * N);
	array = (pthread_t*) malloc(sizeof(pthread_t)* N);
	fact = (long double*) malloc(sizeof(long double) * 1000);
	nums = (int *) malloc(sizeof(int)* N);
	fact[curMaxFact] = 1;
	factorial(900);

	for(int i = 0; i < N; i++)
	{
		sum[i] = 0;
		nums[i] = i;
		pthread_create( &array[i], NULL, sin, (void*) &nums[i]);
	}

	for(int i = 0; i < N; i++)
		pthread_join( *array, NULL);

	long double sinTotal = 0;
	for(int i = 0; i < N; i++)
		sinTotal += sum[i] - 1;

	printf("%.5Lf \n", sinTotal);
}

void *sin( void *i )
{
	int *q;
	q = (int *) i;

	long double curAns = 1;
	int term = *q;
	int thread = *q;

	while(true)
	{
		sum[thread] += curAns;
		curAns = pow(X, (term * 2) + 1);
		curAns /= fact[(term * 2) + 1];
		if(term % 2 == 1)
			curAns *= -1;
		if(std::abs(curAns) < min)
			break;
		term += N;
	}
	return 0;
}