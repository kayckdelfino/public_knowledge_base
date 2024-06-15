from utils.Dictionary import Dictionary
import re


class Token:
    """
    Class to represent a token.
    """

    def __init__(self, token_type, lexeme):
        """
        Initializes a Token object with the token type and lexeme.

        Args:
            token_type (str): Type of the token.
            lexeme (str): Lexeme of the token.
        """
        self.type = token_type
        self.lexeme = lexeme


    def __str__(self):
        """
        Returns the string representation of the token.

        Returns:
            str: String representing the token in the format "<type, lexeme>".
        """
        return f"<{self.type}, {self.lexeme}>"


    @staticmethod
    def tokenize(input_string, verbose=False):
        """
        Tokenizes the input.

        Args:
            input_string (str): Input string.
            verbose (bool): If True, displays debug messages.

        Returns:
            list: List of tokens.
        """
        tokens = []

        while input_string:
            match = None

            if verbose:
                print("============================================================================================")
                print(f"{input_string}\n")

            # Iterate over dictionary patterns
            for token_type, pattern in Dictionary.getDictionary():
                regex = re.compile(pattern)
                match = regex.match(input_string)

                # If a matching pattern is found
                if match:
                    if verbose:
                        print(f"pattern: {pattern}   match: {match}")

                    # Get the matching value
                    value = match.group(0)

                    # Add the token to the list of tokens, except if it is a whitespace token
                    if token_type != "ws":
                        tokens.append(Token(token_type, value))

                    # Update the input string
                    input_string = input_string[match.end():]
                    break

            # If no match is found
            if not match:
                raise ValueError("Compilation error: Digits out of dictionary.")

        if verbose:
            print("============================================================================================")

        return tokens
    

    @staticmethod
    def get_unique_tokens(expressions_tokens_list):
        """
        Returns a list of unique tokens.

        Args:
            expressions_tokens_list (list): List of lists of tokens corresponding to each expression.

        Returns:
            list: List containing the unique tokens.
        """
        unique_tokens = set()  # Set to store unique tokens
        ordered_unique_tokens = []  # List to maintain the order of token occurrence

        # Iterate over each list of tokens
        for tokens in expressions_tokens_list:
            # Iterate over each token in the list of tokens
            for token in tokens:
                # Convert the token to a string to ensure uniqueness
                token_str = str(token)

                # Check if the token is already in the set of unique tokens
                if token_str not in unique_tokens:
                    # Add the token to the set of unique tokens
                    unique_tokens.add(token_str)

                    # Add the token to the list of ordered tokens
                    ordered_unique_tokens.append(token)

        return ordered_unique_tokens
    

    @staticmethod
    def format_tokens(expressions_tokens_list, unique_tokens):
        """
        Converts the tokens to the representation with indices of the unique tokens.

        Args:
            expressions_tokens_list (list): List of lists of tokens corresponding to each expression.
            unique_tokens (list): List containing the unique tokens.

        Returns:
            list: List of lists of strings with the representation of the tokens in the format <token, index>.
        """
        unique_tokens_str = [str(token) for token in unique_tokens]
        formatted_tokens = []

        # Iterate over each list of tokens
        for tokens in expressions_tokens_list:
            token_indices = []

            # Iterate over each token in the list of tokens
            for token in tokens:
                # Convert the token to a string
                token_str = str(token)

                # Get the index of the token in the list of unique tokens
                token_index = unique_tokens_str.index(token_str)

                # Add the representation of the token with its index to the list of token_indices
                if token.type in ["KW_SELECT", "KW_FROM", "KW_WHERE", "OP_REL", "DOT"]:
                    token_indices.append(f"<{token.type}>")
                else:
                    token_indices.append(f"<{token.type}, {token_index}>")

            formatted_tokens.append(token_indices)

        return formatted_tokens
    

    @staticmethod
    def save_formatted_tokens_to_file(formatted_tokens, filename):
        """
        Saves the formatted tokens to a file.

        Args:
            formatted_tokens (list): List of lists of strings containing the representation of the formatted tokens.
            filename (str): Name of the file to save the tokens.
        """
        # Write the data to the file
        with open(filename, "w") as file:
            for i, token_list in enumerate(formatted_tokens):
                # Write each token separated by a space
                file.write(" ".join(token_list))
                
                # Add a newline after each list of tokens, except for the last line
                if i != len(formatted_tokens) - 1:
                    file.write("\n")