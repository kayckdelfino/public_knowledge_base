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
	public void addError(int line, int column, String message) {
		errorList.addError(line, column, message);
	}
	private Symbol createSymbol(int code, Object value) {
		return new Symbol(code, yyline, yycolumn, value);
	}
	private Symbol createSymbol(int code) {
		return new Symbol(code, yyline, yycolumn, null);
	}
%}

IGNORE = [\s]+
NUMBER = [0-9]+
ID = [a-zA-Z][a-zA-Z0-9_-]*
OPERATOR = (<>|=|<=|>=|<|>)

%%

<YYINITIAL>{
	"SELECT"     { return createSymbol(Sym.KW_SELECT);          }
	"FROM"       { return createSymbol(Sym.KW_FROM);            }
	"WHERE"      { return createSymbol(Sym.KW_WHERE);           }
	","          { return createSymbol(Sym.COMMA);              }
	";"          { return createSymbol(Sym.DOT);                }
	{NUMBER}     { return createSymbol(Sym.NUMBER, yytext());   }
	{ID}         { return createSymbol(Sym.ID, yytext());       }
	{OPERATOR}   { return createSymbol(Sym.OPERATOR, yytext()); }

    {IGNORE}    {}
}

<<EOF>> { return createSymbol(Sym.EOF); }