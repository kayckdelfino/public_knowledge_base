def main():
    s = input("Input: ")
    print("Output:", shorten(s))


def shorten(word):
    for c in word:
        if c in ["A", "E", "I", "O", "U", "a", "e", "i", "o", "u"]:
            word = word.replace(c, "")

    return word


if __name__ == "__main__":
    main()