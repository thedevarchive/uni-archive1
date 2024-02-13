%{
    #include "myscanner.h" 
    
%}

/*how to detect html comments from https://stackoverflow.com/a/15516186*/
/*regex for badly-formed numbers and unexpected end of file made by Christian Chan*/


commentstart "<!--"
commentend "-->"
startag "<"[a-zA-Z]+[>]

%%
(<!--([^-]|-[^-]|--+[^->])*-*-->) ; 
[0]*[1-9][0-9]*(["."eE]?)[\.,\"\'\/\\?@!`~#\$\-\+\*&\^%\(\)\[\]\{\}\|<>=_]*[0-9]*([a-zA-Z]*)?[\.,\"\'\/\\?@!`~#\$\-\+\*&\^%\(\)\[\]\{\}\|<>=_]*([a-zA-Z]*)?[0-9]* return BFNUM; 
{startag}[ \t\n]*[\.,\"\'\/\\?@!`~#\$\-\+\*&\^%\(\)\[\]\{\}\|<>=_a-zA-Z0-9]*[ \t\n]*[<]*[/]*[a-zA-Z]*|{commentstart}[ \t\n]*[\.,\"\'\/\\?@!`~#\$\-\+\*&\^%\(\)\[\]\{\}\|<>=_a-zA-Z0-9]*[ \t\n]*[\-]* return UNEOF; 
[<][a-z][a-z0-9]*     return TAGIDENT; 
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
-                   return MINUS; 

[a-zA-Z][_a-zA-Z]* return IDENT; 
([0-9]+|([0-9]*\.[0-9]+)([eE][+-]?[0-9]+)?) return NUMBER; 
\.                  return PERIOD; 
[ \t\n]+             ; 

<<EOF>>             return END_OF_FILE; 
.                   return OTHER; 
%%

int yywrap(void)
{
    return 1; 
}

