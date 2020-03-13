import secrets


def charToNum(char):
    alphabet = "abcdefghijklmnopqrstuvwxyz "
    num = 1
    for letter in alphabet:
        if letter == char:
            break
        else:
            num += 1
    return num


def numToChar(num):
    alphabet = "abcdefghijklmnopqrstuvwxyz "
    return alphabet[num+1]


def encodeChar(pText, key):
    cNum = (charToNum(pText) + charToNum(key)) % 26
    cText = numToChar(cNum)
    return cText


def encode(pText, key):
    cText = ""
    for i in range(0, len(pText)):
        cText += encodeChar(pText[i], key[i])
    return cText, key


def keyGenerator(textLength):
    key = []
    alphabet = "abcdefghijklmnopqrstuvwxyz "
    for i in range(0, textLength):
        k = secrets.randbelow(len(alphabet))
        key.append(alphabet[k])
    return key


if __name__ == "__main__":
    text = ""
    listKey = []
    text = input("Please enter your plaintext: ")
    key = keyGenerator(len(text))
    text, listKey = (encode(text, key))
    stringKey = ''.join(listKey)
    print("Encrypted Text: "+text + "\nKey: "+stringKey)
    pass
