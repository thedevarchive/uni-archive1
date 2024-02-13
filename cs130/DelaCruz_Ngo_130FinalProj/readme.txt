CONTENTS OF THE ZIP: 
The zip contains two files: Part 1 and Part 2. Part 1 contains the Analyzer and Part 2 contains the Parser. The zip contains a readme.txt (this file). 

Part 1 contains myscanner.l (lex file), its lex.yy.c, myscanner.c (the main file), myscanner.h (contains the values that will be returned by the lex file), and the Analyzer, the executable file itself. 

Part 2 contains two folders: main and calc. main contains similar files to Part 1, such as the lex file, its lex.yy.c, the main c file, and the header, all having the same names as mentioned in Part 1. main also contains the Parser. calc contains calc.y (yacc file), its y.tab.c, calc.l (lex file), its lex.yy.c, the header file (similarly titled in main), and its y.tab.h. calc also contains the calc executable. 

SYSTEM REQUIREMENTS: 
For Mac: at least OS X 10.7.4 especially for compilation because XCode contains a compiler for lex and yacc. 
For Windows: at least Windows 10. 

UNRESOLVED BUGS: 
Part 1
- bad number format error does not parse the bad number itself
Sample Input: 
1.+2
5.5ea
5.5e-x

Expected Output: 
***lexical error: badly formed number
NUMBER     1.+
NUMBER     2
***lexical error: badly formed number
NUMBER     5.5ea
***lexical error: badly formed number
NUMBER     5.5e-x

Analyzer Output: 
***lexical error: badly formed number
***lexical error: badly formed number
***lexical error: badly formed number

Part 2
- cannot connect the Calculator (calc) Yacc file to the Parser. As a result, Parser can only identify the equation but not return its result.

HOW TO USE: 
GENERAL INSTRUCTIONS: Using Terminal or Command Prompt, go to the location of those files and type the following commands

Test/Run ANALYZER: ./Analyzer [file to test/analyze].txt [output filename].txt
Test/Run PARSER: ./Parser [file to test/parse].txt [output filename].csv

HOW TO RECOMPILE: 
ANALYZER
To recompile lex (compile lex after making changes to it): lex myscanner.l
To recompile the main c file (and in turn, the Analyzer): gcc lex.yy.c myscanner.c -o Analyzer

PARSER
main
To recompile lex (compile lex after making changes to it): lex myscanner.l
To recompile the main c file (and in turn, the Analyzer): gcc lex.yy.c myscanner.c -o Parser

calc: 
To recompile calc.y (compile this after making changes to it): yacc calc.y
To recompile calc.l (compile this after making changes to it): lex calc.l 
To recompile calc program: gcc lex.yy.c y.tab.c -o calc

