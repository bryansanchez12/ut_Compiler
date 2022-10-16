grammar Grammar;

comments: program EOF
        ;

program : (classes END )*
        ;

classes : type identifier arguments body
        ;

arguments: '(' (type identifier (',' type identifier)* )? ')'
         |
         ;

body: '{' ( statements | funct )* '}'
    ;

statements: if_condition END
          | while_loop END
          | for_loop END
          | declaration END
          | return1 END
          | print END
          | concurrentBlock END
          | lockCondition END
          ;

concurrentBlock: 'parbegin' '{' statements* '}'
                ;

lockCondition : 'lock' '(' identifier ')' '{' statements* '}'
              ;

funct : 'def' identifier arguments body END
      ;


return1 : 'return' variable
       ;

print : 'print' '(' variable ')'
       ;

if_condition : 'if' '(' condition ')' body ('else if' '(' condition ')' body )*   ('else' body)?
             ;

for_loop : 'for' '(' declaration END condition END declaration ')' body
         ;

while_loop : 'while' '(' condition ')' body ;

declaration : type identifier STARTFUNC expression
            | identifier STARTFUNC expression
            ;

expression : '(' expression ')'
           | variable (OPERATORS variable)*
           ;

condition : variable COMPARATIVES variable
          | multiple_conditions
          | identifier
          | STATE
          ;

multiple_conditions : '(' condition ')' (MCOND '(' condition ')')+
                    ;


variable : QUOTES identifier QUOTES
         | OPENBRT variable (',' variable)* CLOSEBRT
         | identifier
         | integer
         |
         | STATE
         ;

type: BOOLEAN
    | INT
    | ARRAY
    | CLASS
    | STRING
    | GLOBAL_INTEGER
    | GLOBAL_BOOLEAN
    | GLOBAL_ARRAY
    | GLOBAL_STRING
    ;

integer : INTEGER;
identifier : IDENTIFIER;

// LEXER
INT: 'int';
ARRAY: 'array';
BOOLEAN: 'boolean';
CLASS: 'class';
STATE : ('True'|'False');
STRING : 'string' ;
MCOND : ('and'| 'or');
GLOBAL_INTEGER : 'globalInt';
GLOBAL_BOOLEAN : 'globalBoolean';
GLOBAL_ARRAY : 'globalArray';
GLOBAL_STRING : 'globalString' ;
INTEGER : [0-9]+ ;
IDENTIFIER : [a-zA-Z_][a-zA-Z_0-9]* ;
WHITESPACE : [ \t\n\r]+ -> skip;
COMMENT : '--' .*? '\n' -> skip;
MULTILINE_COMMENT: '--*' .*?'*--' -> skip;
END : (';');
OPERATORS: ('+'|'-'|'*'|'/'|'||'|'&&');
COMPARATIVES: ('>'|'<'|'=='|'!='|'>='|'<='|'||'|'&&');
STARTFUNC: ('=');
QUOTES : ('"');
OPENBRT : ('[');
CLOSEBRT : (']');
GLOBAL :('global');