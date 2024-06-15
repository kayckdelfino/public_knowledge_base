from Grammar import Grammar


def main():
    grammar_A = Grammar(file_name="grammarA.txt")
    print("\t# grammarA #")

    firsts_A = grammar_A.first()

    follows_A = grammar_A.follow()

    print_values(grammar_A.grammar, firsts_A, follows_A)

    ###

    grammar_B = Grammar(file_name="grammarB.txt")
    print("\t# grammarB #")

    firsts_B = grammar_B.first()

    follows_B = grammar_B.follow()

    print_values(grammar_B.grammar, firsts_B, follows_B)


def print_values(grammar, firsts, follows):
    SEPARATOR = "="*50

    print(SEPARATOR)
    print("GRAMMAR:\n")

    for head, productions in grammar.items():
        result = " | ".join(productions)

        print(f"{head} -> {result}")

    print(SEPARATOR)
    print("FIRSTS:\n")

    for non_terminal, values in firsts.items():
        result = "{" + ", ".join(values) + "}"

        print(f"{non_terminal} -> {result}")

    print(SEPARATOR)
    print("FOLLOWS:\n")

    for non_terminal, values in follows.items():
        result = "{" + ", ".join(values) + "}"

        print(f"{non_terminal} -> {result}")

    print(SEPARATOR)


if __name__ == "__main__":
    main()