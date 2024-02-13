#include <stdio.h> 
#include <stdlib.h>
#include "myscanner.h"
#include <string.h> 

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
    int prev = 0; 

    while(ntoken)
    {
        switch(ntoken)
        {
            case IDENT: 
            case NUMBER: 
                if(strncmp(yytext, "th", 2) == 0 || strncmp(yytext, "td", 2) ==0) break; 
                else if((prev == IDENT) || (prev == NUMBER)) fprintf(yyout, " %s", yytext); 
                else fprintf(yyout, "%s", yytext); 
                prev = ntoken; 
                break; 
            case ENDTAGHEAD: 
                ntoken = yylex(); 
                char c; 
                if(strncmp(yytext, "th", 2) == 0 || strncmp(yytext, "td", 2) ==0)
                {
                    ntoken = yylex(); 
                    c = ','; 
                    ntoken = yylex(); 
                    ntoken = yylex(); 
                    if(strncmp(yytext, "tr", 2) == 0)
                    {
                        ntoken = yylex(); 
                        c = '\n';  
                    }
                    fprintf(yyout, "%c", c);
                }
                else if(strncmp(yytext, "tr", 2) == 0)
                    {
                        ntoken = yylex(); 
                        fprintf(yyout, "\n"); 
                    }
                prev = ntoken; 
                break; 
            case EQUALS: 
                while(ntoken)
                {
                    if(ntoken == ENDTAGHEAD) break; 
                    fprintf(yyout, "%s", yytext); 
                    ntoken = yylex(); 
                }
                prev = ntoken; 
                break; 
            case PERIOD: 
            case COMMA: 
            case COLON: 
            case SCOLON: 
                fprintf(yyout, "%s ", yytext); 
                prev = ntoken; 
                break; 
            case LBRACKET: 
                ntoken = yylex(); 
                while(ntoken != RBRACKET)
                {
                    fprintf(yyout, "%s", yytext); 
                    ntoken = yylex(); 
                }
                break; 
            case END_OF_FILE: 
                fclose(yyin);
                fclose(yyout); 
                return 0; 
                break; 
        }

        ntoken = yylex(); 



    }
    


}