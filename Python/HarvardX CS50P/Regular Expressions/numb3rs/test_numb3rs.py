from numb3rs import validate


def test_valids():
    assert validate("0.0.0.0") == True
    assert validate("255.255.255.255") == True
    assert validate("127.0.0.1") == True
    assert validate("1.2.3.4") == True
    assert validate("255.255.255.0") == True


def test_invalids():
    assert validate("-1.-2.-3.-4") == False
    assert validate("512.512.512.512") == False
    assert validate("275.3.6.28") == False
    assert validate("1.2.3.1000") == False
    assert validate("1.555.555.555") == False
    assert validate("cat") == False