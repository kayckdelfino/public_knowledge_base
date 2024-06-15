class Reader:
    """
    Class to read a file.
    """

    @staticmethod
    def read_expressions_from_file(filename):
        """
        Reads expressions from the file.

        Args:
            filename (str): Name of the file containing the expressions.

        Returns:
            list: List of strings containing the expressions.
        """
        with open(filename, "r") as file:
            # Read the entire content of the file as a single string
            content = file.read()

            # Remove newline characters ("\n")
            content = content.replace("\n", "")

            # Replace ";" with ";\n" to separate the expressions
            content = content.replace(";", ";\n")

            # Split the string into expressions using "\n" as the delimiter
            expressions = content.split("\n")

            # Remove extra whitespace from each expression
            expressions = [expression.strip() for expression in expressions if expression.strip()]

            return expressions
        

    @staticmethod
    def read_file(filename):
        """
        Reads the content of a file.

        Args:
            filename (str): Name of the file.

        Returns:
            str: Content of the file.
        """
        with open(filename, "r") as file:
            return file.read()