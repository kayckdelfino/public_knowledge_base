from seasons import calculate_minutes, numbers_in_words
import pytest


# Made on 2023-08-11
def main():
    test_calculate_minutes()
    test_numbers_in_words()


def test_calculate_minutes():
    assert calculate_minutes("2022-08-11") == 525600
    assert calculate_minutes("2021-08-11") == 1051200

    with pytest.raises(SystemExit):
        calculate_minutes("cat")
        calculate_minutes("28-10-2003")


def test_numbers_in_words():
    assert numbers_in_words(525600) == "Five hundred twenty-five thousand, six hundred minutes"
    assert numbers_in_words(1051200) == "One million, fifty-one thousand, two hundred minutes"


if __name__ == "__main__":
    main()