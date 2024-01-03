def main():
    print(gauge(convert(input("Fraction: "))))


def convert(fraction):
    if "/" in fraction:
        x, y = fraction.split("/")
        if int(x) > int(y) and int(y) != 0: raise ValueError()
        else:
            div = int(x) / int(y)
            return round(div * 100)


def gauge(percentage):
    if percentage <= 1:
        return "E"
    elif percentage >= 99:
        return "F"
    else:
        return f"{percentage}%"


if __name__ == "__main__":
    main()