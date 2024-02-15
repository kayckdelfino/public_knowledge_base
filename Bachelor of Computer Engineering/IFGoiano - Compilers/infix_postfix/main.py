# Exercise
# Develop a program that:
# 
# a) Given an input of type String corresponding to a mathematical equation, create a method that converts and returns another String from infix notation to postfix notation. Use the following statements to test:
# 
# ['(9-5+2)', '(A+B)(C+D)', 'AB+CD', 'A+B+C+D', 'A+BC+D']
# 
# b) Given an input of type String corresponding to a mathematical equation written in postfix notation, calculate and return a Double corresponding to the result of the equation. Use the following statements to test:
# 
# ['(9-5+2)', '(6+9)(4-5)', '36+8*2', '4+5+6+7', '6+8/4+2']


from math_expression_handler import MathExpressionHandler

def main():
    """
    Main function that executes the program for converting infix expressions to postfix and calculating postfix expressions.
    """
    while True:
        # Display the menu options
        print("\n[1] Infix -> Postfix",
              "[2] Postfix -> Result",
              "[3] Infix -> Postfix -> Result",
              "[0] Exit",
              sep="\n")

        op = input("Select an option: ")

        # Check the selected option
        if op == "0":
            print("Goodbye!")
            break

        try:
            # Execute the chosen operation
            match op:
                case "1":
                    infix_exp = input("\nEnter the infix expression: ")
                    postfix_exp = MathExpressionHandler.infix_to_postfix(
                        infix_exp)

                    print(f"Postfix: {postfix_exp}")

                case "2":
                    postfix_exp = input("\nEnter the postfix expression: ")
                    result = MathExpressionHandler.calculate_postfix(
                        postfix_exp)

                    print(f"Result: {result}")

                case "3":
                    infix_exp = input("\nEnter the infix expression: ")
                    postfix_exp = MathExpressionHandler.infix_to_postfix(
                        infix_exp)
                    result = MathExpressionHandler.calculate_postfix(
                        postfix_exp)

                    print(f"Result: {result}")

                case _:
                    continue

        except ValueError as ve:
            # Display error messages if a ValueError exception occurs
            print(ve)


if __name__ == "__main__":
    main()