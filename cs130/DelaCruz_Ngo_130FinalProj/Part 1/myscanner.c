#include <stdio.h> 
#include <stdlib.h>
#include "myscanner.h"

extern int yylex(); 
extern int yylineno; 
extern char* yytext; 

extern FILE *yyin;
extern FILE *yyout; 

char *names[] = {"", "TAGIDENT", "GTHAN", "IDENT", "ENDTAGHEAD", "NUMBER", "PLUS", "MINUS", "MULT", "DIVIDE", "MODULO", "EXP", "LPAREN", "RPAREN", "EQUALS", "LTHAN", "COLON", "COMMA", "SCOLON", "PERIOD", "QUOTE", "DQUOTE"}; 

int main(int argc, char *argv[]) {
    yyin = fopen(argv[1], "r");
    yyout = fopen(argv[2], "w");

    int ntoken;  
    ntoken = yylex(); 

    while(ntoken)
    {

        switch(ntoken)
        {
            case TAGIDENT: 
            case ENDTAGHEAD: 
                fprintf(yyout, "%s\t%s\n", names[ntoken], yytext);
                break; 
            case OTHER: 
                fprintf(yyout, "***lexical error: illegal character (%s)\n", yytext); 
                break; 
            case BFNUM: 
                fprintf(yyout, "***lexical error: badly formed number\n"); 
                break; 
            case END_OF_FILE: 
                fclose(yyin);
                fclose(yyout); 
                return 0; 
                break; 
            case UNEOF: 
                fprintf(yyout, "***lexical error: un-expected end of file\n"); 
                fclose(yyin);
                fclose(yyout); 
                return 0; 
                break; 
            default: 
                fprintf(yyout, "%s\t\t%s\n", names[ntoken], yytext);
                break; 
        }

        ntoken = yylex(); 



    }
    

    printf("unexpected end of file"); 

}