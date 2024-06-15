from utils.Reader import Reader
from utils.Token import Token
from utils.SymbolTable import SymbolTable

# Horizontal line for separation
SEPARATOR_LINE = "============================================================================================"


def main():
    # Read expressions from file
    expressions = Reader.read_expressions_from_file("expressions.txt")
    
    # Display initial expressions
    print(SEPARATOR_LINE)
    print("Expressions List:", end="\n\n")
    print(expressions)
    print(SEPARATOR_LINE)
    
    # Tokenize each expression and store the generated tokens
    expressions_tokens_list = []
    for expression in expressions:
        expressions_tokens_list.append(Token.tokenize(expression))
    
    # Display the generated tokens for each expression
    print("Expressions Tokens (Full Token):", end="\n\n")
    for expressions_tokens in expressions_tokens_list:
        for token in expressions_tokens:
            print(token, end="")
        print() # New line to separate the expressions
    print(SEPARATOR_LINE)

    # Get unique tokens
    unique_tokens = Token.get_unique_tokens(expressions_tokens_list)

    # Generate symbol table content
    symbol_table_content = SymbolTable.generate_symbol_table_content(unique_tokens)
    
    # Save the symbol table to a file
    SymbolTable.save_symbol_tables_to_file(symbol_table_content, "symbol_table.txt", format="table")
    
    # Read and display the symbol table file
    print("Symbol Table:", end="\n\n")
    print(Reader.read_file("symbol_table.txt"))
    print(SEPARATOR_LINE)

    # Format the tokens of the expressions with the symbol table indices
    formatted_tokens = Token.format_tokens(expressions_tokens_list, unique_tokens)
    
    # Save formatted tokens to a file
    Token.save_formatted_tokens_to_file(formatted_tokens, "tokenized_expressions_with_indices.txt")
    
    # Read and display the formatted expressions file
    print("Formatted Expressions Tokens (w/ indexes):", end="\n\n")
    print(Reader.read_file("tokenized_expressions_with_indices.txt"))
    print(SEPARATOR_LINE)


if __name__ == "__main__":
    main()