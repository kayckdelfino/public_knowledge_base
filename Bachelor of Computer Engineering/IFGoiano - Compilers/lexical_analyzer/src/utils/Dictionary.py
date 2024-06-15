class Dictionary:
    """
    Class to define the dictionary of patterns used in tokenization.
    """

    # List of patterns, where each element is a tuple containing the token type and its corresponding regex pattern.
    patterns = [
        ("digit", r"\d(?![\d])"),  # Digit not followed by another digit
        ("digits", r"\d{2,}"),  # Two or more consecutive digits
        ("symbol", r"[_-]"),  # Underscore (_) or hyphen (-) symbol
        ("id", r"((?:SELECT|FROM|WHERE)[\w-]+|^(?!SELECT|FROM|WHERE)[a-zA-Z][\w-]*)"),  # Identifier: can start with SELECT, FROM, or WHERE followed by alphanumeric characters, hyphens, or underscores, or can start with a letter followed by alphanumeric characters, hyphens, or underscores, excluding keywords
        ("KW_SELECT", r"SELECT(?![\w-])"),  # "SELECT" if not followed by alphanumeric characters, hyphens, or underscores
        ("KW_FROM", r"FROM(?![\w-])"),  # "FROM" if not followed by alphanumeric characters, hyphens, or underscores
        ("KW_WHERE", r"WHERE(?![\w-])"),  # "WHERE" if not followed by alphanumeric characters, hyphens, or underscores
        ("OP_REL", r"(<>|=|<=|>=|<|>)"),  # Relational operators: not equal (<>), equal (=), less than or equal (<=), greater than or equal (>=), less than (<) or greater than (>)
        ("DOT", r";|,"),  # Semicolon (;) or comma (,)
        ("ws", r"[\s]+")  # One or more whitespace characters
    ]
    
    
    @staticmethod
    def getDictionary():
        """
        Gets the dictionary of patterns.

        Returns:
            list: List of token patterns.
        """
        return Dictionary.patterns