package main;

import java_cup.runtime.*;
import java.io.*;
import error.*;

%%

%cup
%public
%class Scanner
%line
%column

%eofval{
    return createSymbol(Sym.EOF);
%eofval}

%{
    private ErrorList errorList;

    public Scanner(java.io.FileReader in, ErrorList errorList) {
        this(in);
        this.errorList = errorList;
    }

    public ErrorList getErrorList() {
        return errorList;
    }

    public void defineError(int line, int column, String msg) {
        errorList.defineError(line, column, msg);
    }

    private Symbol createSymbol(int code, Object value) {
        return new Symbol(code, yyline, yycolumn, value);
    }

    private Symbol createSymbol(int code) {
        return new Symbol(code, yyline, yycolumn, null);
    }
%}

IGNORE = [\s]
DIGIT = [0-9]
DIGITS = {DIGIT}+
FLOAT = {DIGITS}.{DIGITS}
ID = [a-zA-Z][a-zA-Z0-9_]*

%%

<YYINITIAL>{
    "int"       { return createSymbol(Sym.KW_INT);                 }
    "float"     { return createSymbol(Sym.KW_FLOAT);               }
    "boolean"   { return createSymbol(Sym.KW_BOOL);                }
    "while"     { return createSymbol(Sym.KW_WHILE);               }
    "true"      { return createSymbol(Sym.KW_TRUE);                }
    "false"     { return createSymbol(Sym.KW_FALSE);               }
    ">="        { return createSymbol(Sym.KW_GRT_EQUAL);           }
    "<="        { return createSymbol(Sym.KW_LSS_EQUAL);           }
    "=="        { return createSymbol(Sym.KW_EQUAL);               }
    "="         { return createSymbol(Sym.KW_ATT);                 }
    "+"         { return createSymbol(Sym.KW_ADD);                 }
    "-"         { return createSymbol(Sym.KW_SUB);                 }
    "*"         { return createSymbol(Sym.KW_MUL);                 }
    "/"         { return createSymbol(Sym.KW_DIV);                 }
    "%"         { return createSymbol(Sym.KW_RES);                 }
    ">"         { return createSymbol(Sym.KW_GRT);                 }
    "<"         { return createSymbol(Sym.KW_LSS);                 }
    "!="        { return createSymbol(Sym.KW_DIF);                 }
    "("         { return createSymbol(Sym.KW_LEFT_PR);             }
    ")"         { return createSymbol(Sym.KW_RIGHT_PR);            }
    "{"         { return createSymbol(Sym.KW_LEFT_BRACE);          }
    "}"         { return createSymbol(Sym.KW_RIGHT_BRACE);         }
    ";"         { return createSymbol(Sym.KW_DOT);                 }
    ","         { return createSymbol(Sym.KW_COMMA);               }
    {DIGITS}    { return createSymbol(Sym.NUMBER_INT, yytext());   }
    {FLOAT}     { return createSymbol(Sym.NUMBER_FLOAT, yytext()); }
    {ID}        { return createSymbol(Sym.ID, yytext());           }

    {IGNORE}    {}
}

<<EOF>> { return createSymbol(Sym.EOF); }