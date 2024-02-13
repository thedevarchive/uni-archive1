%{
    #include "myscanner.h" 
    
%}


%%
[<][!][\-][\-]([ \t\n\]*[\.,\"\'\/\\?@!`~#\$\-\+\*&\^%\(\)\[\]\{\}\|<>=_a-zA-Z0-9]*)*[ \t\n\]*[\-][\-][>]       ; 
(([0-9]|[1-9][0-9]*)[\.,\"\'\/\\\?@!`~#\$\-\+\*&\^%\|<>=_a-zA-Z][\.,\"\'\/\\\?@!`~#\$\-\+\*&\^%\|<>=_a-zA-Z]*)*|(0*[0-9]*) return BFNUM; 
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
\[                return LBRACKET; 
\]                    return RBRACKET; 

[a-zA-Z][_a-zA-Z0-9]* return IDENT; 
([0-9]|[1-9][0-9]*)|(([0-9]|[1-9][0-9]*)[\.]([0-9][0-9]*))|(([0-9]|[1-9][0-9]*)[eE][\+\-]([0-9]|[1-9][0-9]*))|(([0-9]|[1-9][0-9]*)[\.]([0-9][0-9]*)[eE][\+\-]([0-9]+[1-9][0-9]*))|(([0-9]|[1-9][0-9]*)[eE]([0-9]|[1-9][0-9]*))|(([0-9]+[1-9][0-9]*)[\.]([0-9][0-9]*)[eE]([0-9]|[1-9][0-9]*)) return NUMBER; 
\.                  return PERIOD; 
[ \t\n]+             ; 

<<EOF>>             return END_OF_FILE; 
.                   return OTHER; 
%%

int yywrap(void)
{
    return 1; 
}

