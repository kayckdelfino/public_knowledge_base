import csv
import io
from tabulate import tabulate


class SymbolTable:
    """
    Class to generate and save symbol tables.
    """

    @staticmethod
    def generate_symbol_table_content(unique_tokens):
        """
        Generates the content of the symbol table.

        Args:
            unique_tokens (list): List of unique tokens.

        Returns:
            list: List containing the formatted symbol table data.
        """
        symbol_table_content = []

        # Fill the table data with information about each token
        for i, token in enumerate(unique_tokens):
            # Check if the token is of type digit or digits
            if token.type in ["digit", "digits"]:
                # Add the token to the list, also filling in the "Value" column
                symbol_table_content.append(
                    [i, token.lexeme, f"<{str(token.type)}>", token.lexeme])
            else:
                # Add the token to the list, with "-" for "Value"
                symbol_table_content.append(
                    [i, token.lexeme, f"<{str(token.type)}>", "-"])

        return symbol_table_content
    

    @staticmethod
    def save_symbol_tables_to_file(symbol_table_content, filename, format="csv"):
        """
        Saves the symbol tables to a file.

        Args:
            symbol_table_content (list): List of formatted symbol table data.
            filename (str): Name of the file to save the tables.
            format (str): Format to save the tables ("csv" or "table").

        Raises:
            ValueError: If the specified format is not "csv" or "table".
        """
        # Table headers
        headers = ["Identifier", "Lexeme", "Token", "Value"]

        # Add the headers to the start of the symbol table
        symbol_table_content.insert(0, headers)

        # Check the specified output format
        if format == "csv":
            # Create a StringIO object to write CSV data
            csv_output = io.StringIO()
            writer = csv.writer(csv_output, dialect="unix")

            # Write the symbol table data
            writer.writerows(symbol_table_content)
            
            # Get the CSV content as a string
            output_content = csv_output.getvalue().strip()
        elif format == "table":
            # Get the content formatted as a table
            output_content = tabulate(symbol_table_content, headers="firstrow", tablefmt="grid")
        else:
            # If the specified format is not supported, raise a ValueError
            raise ValueError("Invalid format: Use 'csv' or 'table'.")

        # Write the data to the file
        with open(filename, "w") as file:
            file.write(output_content)