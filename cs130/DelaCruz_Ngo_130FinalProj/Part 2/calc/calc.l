%{
    #include <stdlib.h>
    #include "y.tab.h"
    void yyerror(char *);
    #include "myscanner.h" 
%}



%%
[<][!][\-][\-]([ \t\n\]*[\.,\"\'\/\\?@!`~#\$\-\+\*&\^%\(\)\[\]\{\}\|<>=_a-zA-Z0-9]*)*[ \t\n\]*[\-][\-][>]       ; 

    /* integers */
([0-9]+|([0-9]*\.[0-9]+)([eE][+-]?[0-9]+)?) {
    yylval.dval = atof(yytext);
    return NUM;
    }

[<][!a-z][a-z0-9]*     return TAGIDENT; 
:                   return COLON; 
\<\/                  return ENDTAGHEAD; 
\+                  return PLUS; 
\*                  return MULT; 
\/                  return DIVIDE; 
%                   return MODULO; 
\*\*                return EXP; 
\(                  return LPAREN; 
\)                  return RPAREN; 
=                   return EQUALS; 
,                   return COMMA; 
;                   return SCOLON; 
'                   return QUOTE; 
\"                  return DQUOTE; 
>                   return GTHAN; 
\<                   return LTHAN; 

[a-zA-Z][_a-zA-Z0-9]* return IDENT; 
\.                  return PERIOD; 
    /* operators */
[-+()=/*\n] { return *yytext; }

    /* skip whitespace */
[ \t]        ;

    /* anything else is an error */
<<EOF>>             return END_OF_FILE; 
.               yyerror("invalid character");

%%

int yywrap(void) {
    return 1;
}
