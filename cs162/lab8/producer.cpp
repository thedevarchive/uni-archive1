#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/sem.h>
#include <sys/shm.h>
#include <fstream>
#include <unistd.h>

#include <cstdio>
#include <cstdlib>
#include <cstring>

using namespace std;

int main( int argc, char* argv[] )
{
    //shared resources
    int ida, idb; //shared mem ids 
    key_t ka = 3456, kb = 7890; //keys
    int sizeA = atoi(argv[2]), sizeB = 2; //initialize mem space 
    int shmFlags = IPC_CREAT | 0666; 
    char* shmpA; 
    char* shmpB; 

    ida = shmget(ka, sizeA, shmFlags); 
    idb = shmget(kb, sizeB, shmFlags);
    shmpA = (char*) shmat(ida, NULL, 0); 
    shmpB = (char*) shmat(idb, NULL, 0); 

    int semid; 
    key_t semkey = 1234; 
    semid = semget(semkey, 1, IPC_CREAT | 0666); 

    //catch exceptions
    if(ida == -1) 
    {
        perror("cannot get shma"); 
        exit(1); 
    }
    if(idb == -1) 
    {
        perror("cannot get shmb"); 
        exit(1); 
    }
    if(semid == -1) 
    {
        perror("cannot get sem"); 
        exit(1); 
    }
    if(((int*) shmpA) == ((int*) -1))
    {
        perror("shmpa shmat failed"); 
        exit(1); 
    }
    if(((int*) shmpB) == ((int*) -1))
    {
        perror("shmpb shmat failed"); 
        exit(1); 
    }

    //get file
    ifstream inputf; 
    inputf.open(argv[1]); 
    if(!inputf)
    {
        perror("file not found"); 
        exit(1); 
    }
    inputf.seekg(0, inputf.end); 
    int size = inputf.tellg(); 
    int curr = 0, len; 
    char* buffer = new char[sizeA]; 

    *shmpB = 'n'; 
    while(!inputf.eof())
    {
        if(*shmpB == 'n' | *shmpB == 'c')
        {
            int ops = 2; 
            struct sembuf sema[ops]; 
            sema[0].sem_num = 0; 
            sema[0].sem_op = 0; 
            sema[0].sem_flg = SEM_UNDO; 

            sema[1].sem_num = 0; 
            sema[1].sem_op = 1; 
            sema[1].sem_flg = SEM_UNDO; 

            int res = semop(semid, sema, ops);
            if(res != -1)
            {
                //read
                len = sizeof(shmpA); 
                memset(shmpA, '\0', len); 
                memset(buffer, '\0', sizeA); 
                inputf.seekg(curr); 
                inputf.read(buffer, sizeA); 

                memcpy(shmpA, buffer, sizeA); 

                curr += sizeA; 

                ops = 1; 
                sema[0].sem_num = 0;
                sema[0].sem_op = -1; 
                sema[0].sem_flg = SEM_UNDO | IPC_NOWAIT; 

                res = semop(semid, sema, ops); 
                if(res != -1)
                {
                    perror("semop (decrement)"); 
                    exit(1); 
                }
            }
            else perror("semop (increment)"); 
            sleep(1); 
            *shmpB = 'p'; 
        }
    }
    *shmpB = 'n';
	delete[] buffer;
	inputf.close();
    return 0;
}

