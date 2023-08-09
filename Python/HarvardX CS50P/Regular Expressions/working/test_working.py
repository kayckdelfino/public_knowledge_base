from working import convert
import pytest


def main():
    test_1()
    test_2()
    test_3()
    test_4()
    test_5()


def test_1():
    assert convert("9 AM to 5 PM") == "09:00 to 17:00"


def test_2():
    assert convert("9:05 AM to 5:15 PM") == "09:05 to 17:15"


def test_3():
    with pytest.raises(ValueError):
        convert("9 AM 5 PM")


def test_4():
    with pytest.raises(ValueError):
        convert("13 PM to 17 PM")


def test_5():
    with pytest.raises(ValueError):
        convert("9:60 AM to 9:60 PM")


if __name__ == "__main__":
    main()