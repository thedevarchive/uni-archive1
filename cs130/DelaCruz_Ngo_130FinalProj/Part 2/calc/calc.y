
%{
    void yyerror(char *);
    int yylex(void);
    #include <stdio.h>     /* C declarations used in actions */
    #include <stdlib.h>
    #include <ctype.h>
#include <math.h>
%}

%union {
    double dval;}
%token <dval> NUM
%left '+' '-'
%left '*' '/'
%type <dval> expr

%%

program:
        '=' program statement '\n'
        | 
        ;

statement:
        expr                      { printf("%.2f\n", $1); }
        ;

expr:
        NUM
        | expr '+' expr           { $$ = $1 + $3; }
        | expr '-' expr           { $$ = $1 - $3; }
        | expr '*' expr           { $$ = $1 * $3; }
        | expr '/' expr           { $$ = $1 / $3; }
        | '(' expr ')'            { $$ = $2; }
        ;

%%

void yyerror(char *s) {
    fprintf(stderr, "%s\n", s);
}

/*int main(void) {
    yyparse();
    return 0;
}*/