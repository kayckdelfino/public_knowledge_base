from math_expression_handler import MathExpressionHandler

def infix_to_postfix_test(verbose=False):
    """
    Tests the infix to postfix conversion function.

    Args:
        verbose (bool, optional): If True, displays test details. Defaults to False.
    """
    # List of infix expressions and their expected postfixes
    expressions = [
        # Requested tests
        "(9-5+2)", "(A+B)*(C+D)", "A*B+C*D", "A+B+C+D", "A+B*C+D",

        # Only numbers
        "(1+2)*(3-4)", "5*(6/3)", "(7+8)*(9-0)", "1*(2/3)", "(4+5)*(6-7)", "8*(9/5)", "(1+2)*(3-4)", "5*(6/3)", "(7+8)*(9-0)", "1*(2/3)",

        # Only letters
        "(A+B)*(C-D)", "E*(F/G)", "(G+H)*(I-J)", "K*(L/M)", "(N+O)*(P-Q)",

        # Mixed
        "(A+B)*(1-2)", "3*(C-D)", "(E+4)*(5-F)", "G*(6/7)", "(8+H)*(I-9)"
    ]

    expected_postfix = [
        # Requested tests
        "95-2+", "AB+CD+*", "AB*CD*+", "AB+C+D+", "ABC*+D+",

        # Only numbers
        "12+34-*", "563/*", "78+90-*", "123/*", "45+67-*", "895/*", "12+34-*", "563/*", "78+90-*", "123/*",

        # Only letters
        "AB+CD-*", "EFG/*", "GH+IJ-*", "KLM/*", "NO+PQ-*",

        # Mixed
        "AB+12-*", "3CD-*", "E4+5F-*", "G67/*", "8H+I9-*"
    ]

    # Tests
    for i in range(len(expressions)):
        exp = expressions[i]
        calculated_pfix = MathExpressionHandler.infix_to_postfix(expressions[i])
        expected_pfix = expected_postfix[i]

        print(f"Test {i + 1}: {calculated_pfix == expected_pfix}")

        if verbose:
            print(f"Infix: {exp}",
                  f"Calculated Postfix: {calculated_pfix}",
                  f"Expected Postfix: {expected_pfix}",
                  sep="\n", end="\n\n")


def calculate_postfix_test(verbose=False):
    """
    Tests the postfix expression calculation function.

    Args:
        verbose (bool, optional): If True, displays test details. Defaults to False.
    """
    # List of postfix expressions and their expected results
    postfix_expressions = [
        # Requested tests
        "95-2+", "69+45-*", "36*82*+", "45+6+7+", "684/+2+",

        # Additional tests
        "45+67-*", "895/*", "12+34-*", "563/*", "78+90-*"
    ]

    expected_results = [
        # Requested tests
        6.0, -15.0, 34.0, 22.0, 10,

        # Additional tests
        -9.0, 14.4, -3.0, 10.0, 135.0
    ]

    # Tests
    for i in range(len(postfix_expressions)):
        exp = postfix_expressions[i]
        calculated_result = MathExpressionHandler.calculate_postfix(postfix_expressions[i])
        expected_result = expected_results[i]

        print(f"Test {i + 1}: {calculated_result == expected_result}")

        if verbose:
            print(f"Postfix: {exp}",
                  f"Calculated Result: {calculated_result}",
                  f"Expected Result: {expected_result}",
                  sep="\n", end="\n\n")


if __name__ == "__main__":
    # Run the tests
    infix_to_postfix_test(verbose=True)
    calculate_postfix_test(verbose=True)