#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/sem.h>
#include <sys/shm.h>

#include <cstdio>
#include <cstdlib>
#include <fstream>
#include <unistd.h>

using namespace std;

int main( int argc, char* argv[]) {
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
    ofstream out; 
    out.open(argv[1]); 
    /*if(!out)
    {
        perror("file not found"); 
        exit(1); 
    }*/

    int curr = 0; 

    while(*shmpB != 'n')
    {
        if(*shmpB == 'p')
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
                // make file 
                out.seekp(out.tellp()); 
                out << shmpA; 

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
            }else perror("semop (increment)"); 
            if(*shmpB == 'n') break; 
            else *shmpB = 'c'; 
        }
        sleep(1); 
    }
    out.seekp(out.tellp()); 
    out << shmpA; 
    out.close(); 
    return 0; 
}