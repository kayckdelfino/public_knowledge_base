from Parser import Parser

# Define the parser grammar
grammar = {
    1: {"S": "AA"},
    2: {"A": "aA"},
    3: {"A": "b"}
}

# Define the shift-reduce table of the parser
shift_reduce_table = {
    0: {
        "a": "s3",
        "b": "s4",
        "S": 1,
        "A": 2
    },
    1: {
        "$": "acc"
    },
    2: {
        "a": "s3",
        "b": "s4",
        "A": 5
    },
    3: {
        "a": "s3",
        "b": "s4",
        "A": 6
    },
    4: {
        "a": "r3",
        "b": "r3",
        "$": "r3"
    },
    5: {
        "$": "r1"
    },
    6: {
        "a": "r2",
        "b": "r2",
        "$": "r2"
    },
}

# Create an instance of the parser
parser = Parser(grammar, shift_reduce_table)


def main():
    # Valid inputs
    print("VALID INPUTS")
    test_input("abb")
    test_input("abab")
    test_input("bb")
    test_input("aaaaabaaab")
    test_input("baaab")

    # Invalid inputs
    print("\nINVALID INPUTS")
    test_input("abbb")
    test_input("aab")
    test_input("aaaaaaa")
    test_input("")

    # parser.test("abb", verbose=True)


def test_input(input_str):
    try:
        result = parser.test(input_str)

        if result:
            print(f"'{input_str}' - ACCEPT")
            
    except Exception:
        print(f"'{input_str}' - ERROR")


if __name__ == "__main__":
    main()