class MathExpressionHandler:
    @staticmethod
    def _is_operator(char):
        """
        Checks if the character is an operator.

        Args:
            char (str): The character to be checked.

        Returns:
            bool: True if the character is an operator, False otherwise.
        """
        return char in ["+", "-", "*", "/"]

    @staticmethod
    def _precedence(operator):
        """
        Checks the precedence of operators.

        Args:
            operator (str): The operator to be checked.

        Returns:
            int: An integer value representing the precedence. Returns 1 for + and -, and 2 for * and /.
        """
        if operator in ["+", "-"]:
            return 1

        elif operator in ["*", "/"]:
            return 2

        else:
            return -1

    @staticmethod
    def infix_to_postfix(infix):
        """
        Converts from infix notation to postfix notation.

        Args:
            infix (str): The expression in infix notation.

        Returns:
            str: The expression in postfix notation.
        """
        output = []
        stack = []
        count = 0

        for char in infix:
            if char == "(":
                stack.append(char)

            elif char == ")":
                # Validate parentheses composition
                if "(" not in stack:
                    raise ValueError(
                        "Invalid expression: Unbalanced parentheses.")

                # Pop operators until finding the corresponding '('
                while stack and stack[-1] != "(":
                    output.append(stack.pop())

                # Remove '(' from the stack
                stack.pop()

            elif char.isalnum():
                # Validate sequence of alphanumeric digits
                if count > 0 and infix[count - 1].isalnum():
                    raise ValueError(
                        "Invalid expression: Operands without operator.")

                # Add operands to the output
                output.append(char)

            elif MathExpressionHandler._is_operator(char):
                # Validate operator composition
                if not output or count == len(infix) - 1 or (not infix[count + 1].isalnum() and infix[count + 1] != "(") or (count > 0 and infix[count - 1] == "("):
                    raise ValueError(
                        "Invalid expression: Operator without operand.")

                # Pop operators of greater or equal precedence
                while stack and MathExpressionHandler._precedence(char) <= MathExpressionHandler._precedence(stack[-1]):
                    output.append(stack.pop())

                # Add operator to the stack
                stack.append(char)

            else:
                # If it's not an operator / alphanumeric / ["(", ")"] return error
                raise ValueError(
                    "Invalid expression: Invalid character found.")

            count += 1

        # Pop the remaining operators
        while stack:
            char = stack.pop()

            # Validate stack content
            if char == "(":
                raise ValueError(
                    "Invalid expression: Unbalanced parentheses.")
            else:
                output.append(char)

        # Return calculated postfix string
        return "".join(output)

    @staticmethod
    def calculate_postfix(postfix):
        """
        Calculates the postfix expression.

        Args:
            postfix (str): The expression in postfix notation.

        Returns:
            int or float: The result of the expression.
        """
        stack = []

        for char in postfix:
            if char.isdigit():
                # Add operands to the stack
                stack.append(int(char))

            elif MathExpressionHandler._is_operator(char):
                # Validate stack content
                if len(stack) < 2:
                    raise ValueError(
                        "Invalid expression: Lack of operands for the operator.")

                operand2 = stack.pop()
                operand1 = stack.pop()

                # Perform the operation and push the result
                if char == "+":
                    result = operand1 + operand2
                elif char == "-":
                    result = operand1 - operand2
                elif char == "*":
                    result = operand1 * operand2
                elif char == "/":
                    # Validate division by zero
                    if operand2 == 0:
                        raise ValueError(
                            "Invalid expression: Division by zero.")
                    result = operand1 / operand2

                # Add operation result to the stack
                stack.append(result)

            else:
                # If it's not an operator / alphanumeric return error
                raise ValueError(
                    "Invalid expression: Invalid character found.")

        if len(stack) != 1:
            # Validate final stack content
            raise ValueError(
                "Invalid expression: Unused operands after processing.")

        # Return calculated float
        return float(stack.pop())
