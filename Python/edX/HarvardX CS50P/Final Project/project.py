import warnings
import sys
from typing import List, Tuple, Any
import numpy as np
# mypy: ignore-errors
import matplotlib.pyplot as plt
from scipy.optimize import curve_fit


# Main function - Regression Visualizer
def main():
    """
    This function is the entry point of the program.
    
    It provides a menu for the user to choose between different regression types and performs the chosen regression.
    """
    print("Welcome to Regression Visualizer!")
    print("\nChoose a regression type:")
    print("1. Linear Regression")
    print("2. Exponential Regression")
    print("3. Polynomial Regression")
    print("4. Quit")

    while True:
        with warnings.catch_warnings():
            warnings.filterwarnings("ignore") # Suppress program warnings
            choice = get_valid_input("\nEnter your choice: ", int)
            if choice == 1:
                linear_regression_main()
                break
            elif choice == 2:
                exponential_regression_main()
                break
            elif choice == 3:
                polynomial_regression_main()
                break
            elif choice == 4:
                print("Goodbye!")
                break
            else:
                print("Invalid choice. Please enter a valid option.")


# Validation function
def get_valid_input(prompt: str, data_type: type) -> Any:
    """
    Get user input with validation.
    
    Args:
        prompt (str): The prompt to display to the user.
        data_type (type): The expected data type of the input.
    
    Returns:
        Any: The valid user input of the specified data type.
    """
    while True:
        try:
            value = data_type(input(prompt))
            return value
        except ValueError:
            print("Invalid input. Please enter a valid value.")


# Collecting function
def get_data_points() -> Tuple[List[float], List[float]]:
    """
    Get x and y coordinate values from the user.
    
    Returns:
        Tuple[List[float], List[float]]: Lists of x and y coordinate values.
    """
    x_values: List[float] = []
    y_values: List[float] = []
    
    num_points = get_valid_input("Enter the number of data points: ", int)
    
    for i in range(num_points):
        x = get_valid_input(f"Enter x-coordinate for point {i + 1}: ", float)
        y = get_valid_input(f"Enter y-coordinate for point {i + 1}: ", float)
        x_values.append(x)
        y_values.append(y)
    
    return x_values, y_values


# Plotting function
def plot_results(x_values: List[float], y_values: List[float], x_range: np.ndarray, y_range: np.ndarray, label: str, title: str):
    """
    Plot the regression results.
    
    Args:
        x_values (List[float]): List of x-coordinate values.
        y_values (List[float]): List of y-coordinate values.
        x_range (np.ndarray): Array of x-coordinate values for the plot.
        y_range (np.ndarray): Array of y-coordinate values for the plot.
        label (str): Label for the plot.
        title (str): Title of the plot.
    """
    plt.scatter(x_values, y_values, label="Data Points")
    plt.plot(x_range, y_range, label=label, color="red")
    plt.xlabel("X")
    plt.ylabel("Y")
    plt.title(title)
    plt.legend()
    plt.grid()
    plt.show()


# Linear Regression function
def linear_regression(x: np.ndarray, y: np.ndarray) -> Tuple[float, float]:
    """
    Perform linear regression on given data points.
    
    Args:
        x (np.ndarray): Array of x-coordinates (independent variable).
        y (np.ndarray): Array of y-coordinates (dependent variable).
    
    Returns:
        Tuple[float, float]: Angular coefficient and linear coefficient of the linear regression line.
    """

    return np.polyfit(x, y, 1)


# Exponential Regression function
def exponential_regression(x: np.ndarray, y: np.ndarray) -> Tuple[float, float, float]:
    """
    Perform exponential regression on given data points.

    Args:
        x (np.ndarray): Array of x-coordinates (independent variable).
        y (np.ndarray): Array of y-coordinates (dependent variable).

    Returns:
        Tuple[float, float, float]: Exponential coefficients a, b, and c.
    """
    try:
        exponential_func = lambda x, a, b, c: a * np.exp(b * x) + c
        coefficients, _ = curve_fit(exponential_func, x, y)
    except RuntimeError:
        sys.exit("\nError: Unable to find optimal parameters for exponential regression. Please try again with other data or another regression method.")
    return coefficients[0], coefficients[1], coefficients[2]


# Polynomial Regression function
def polynomial_regression(x: np.ndarray, y: np.ndarray, degree: int) -> np.poly1d:
    """
    Perform polynomial regression on given data points.
    
    Args:
        x (np.ndarray): Array of x-coordinates (independent variable).
        y (np.ndarray): Array of y-coordinates (dependent variable).
        degree (int): Degree of the polynomial.
    
    Returns:
        np.poly1d: Polynomial regression function.
    """
    coefficients = np.polyfit(x, y, degree)

    return np.poly1d(coefficients)


# Linear regression calculation and graph plotting function
def linear_regression_main():
    """
    Perform linear regression based on user input and display the results.
    """
    try:
        x_values, y_values = get_data_points()
        angular_coeff, linear_coeff = linear_regression(np.array(x_values), np.array(y_values))
        x_range = np.linspace(min(x_values), max(x_values), 100)
        y_range = angular_coeff * x_range + linear_coeff

        print("\nLinear Regression Equation:")
        print(f"y = {angular_coeff:.6f} * x + {linear_coeff:.6f}")

        plot_results(x_values, y_values, x_range, y_range, "Linear Regression", "Linear Regression")
    except Exception as e:
        print(f"An error occurred: {e}")


# Exponential regression calculation and graph plotting function
def exponential_regression_main():
    """
    Perform exponential regression based on user input and display the results.
    """
    try:
        x_values, y_values = get_data_points()
        a, b, c = exponential_regression(np.array(x_values), np.array(y_values))
        x_range = np.linspace(min(x_values), max(x_values), 100)
        exponential_func = lambda x, a=a, b=b, c=c: a * np.exp(b * x) + c
        y_range = exponential_func(x_range, a, b, c)
        
        print("\nExponential Regression Equation:")
        print(f"y = {a:.6f} * e^({b:.6f} * x) + {c:.6f}")

        plot_results(x_values, y_values, x_range, y_range, "Exponential Regression", "Exponential Regression")
    except Exception as e:
        print(f"An error occurred: {e}")


# Polynomial regression calculation and graph plotting function
def polynomial_regression_main():
    """
    Perform polynomial regression based on user input and display the results.
    """
    try:
        x_values, y_values = get_data_points()
        degree = get_valid_input("Enter the degree of the polynomial: ", int)
        regression_function = polynomial_regression(np.array(x_values), np.array(y_values), degree)
        x_range = np.linspace(min(x_values), max(x_values), 100)
        y_range = regression_function(x_range)
        
        coefficients = regression_function.coefficients[::-1]
        print("\nPolynomial Regression Equation:")
        print("y = ", end="")
        print(" + ".join([f"{coeff:.6f} * x^{i}" for i, coeff in enumerate(coefficients)]))

        plot_results(x_values, y_values, x_range, y_range, f"{degree}-degree Polynomial Regression", "Polynomial Regression")
    except Exception as e:
        print(f"An error occurred: {e}")


if __name__ == "__main__":
    main()