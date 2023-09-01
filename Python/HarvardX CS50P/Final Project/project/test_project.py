import pytest
from project import linear_regression
from project import exponential_regression
from project import polynomial_regression
import numpy as np


def test_linear_regression():
    x_values = np.array([1, 2, 3])
    y_values = np.array([5, 8, 11])
    angular_coeff, linear_coeff = linear_regression(x_values, y_values)
    assert angular_coeff == pytest.approx(3.0)
    assert linear_coeff == pytest.approx(2.0)


def test_exponential_regression():
    x = np.array([1, 2, 3, 4, 5])
    y = np.array([2.718, 7.389, 20.085, 54.598, 148.413])
    a, b, c = exponential_regression(x, y)
    assert a == pytest.approx(1.0, rel=1e-3)
    assert b == pytest.approx(1.0, rel=1e-3)
    assert c == pytest.approx(0.0, abs=1.0e-3)


def test_polynomial_regression():
    x = np.array([1, 2, 3, 4, 5])
    y = np.array([1, 4, 9, 16, 25])
    degree = 2
    regression_function = polynomial_regression(x, y, degree)
    coefficients = regression_function.coefficients
    assert coefficients[0] == pytest.approx(1.0, rel=1e-12)
    assert coefficients[1] == pytest.approx(0.0, rel=1e-12)
    assert coefficients[2] == pytest.approx(0.0, rel=1e-12)