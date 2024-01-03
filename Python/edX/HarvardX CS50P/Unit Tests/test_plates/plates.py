def main():
    plate = input("Plate: ")
    if is_valid(plate):
        print("Valid")
    else:
        print("Invalid")


def is_valid(s):
    if not s[:2].isalpha(): return False
    elif not 2 <= len(s) <= 6: return False
    elif not s.isalnum(): return False

    char_end = False
    for c in s:
        if c.isdigit():
            if not char_end and c == "0":
                return False
            char_end = True
        if char_end and not c.isdigit():
            return False

    else: return True


if __name__ == "__main__":
    main()