# Bitcoin Price Index
# Bitcoin is a form of digitial currency, otherwise known as cryptocurrency. Rather than rely on a central authority like a bank, Bitcoin instead relies on a distributed network, otherwise known as a blockchain, to record transactions.
# 
# Because there’s demand for Bitcoin (i.e., users want it), users are willing to buy it, as by exchanging one currency (e.g., USD) for Bitcoin.
# 
# In a file called bitcoin.py, implement a program that:
# 
# - Expects the user to specify as a command-line argument the number of Bitcoins, n, that they would like to buy. If that argument cannot be converted to a float, the program should exit via sys.exit with an error message.
# - Queries the API for the CoinDesk Bitcoin Price Index at https://api.coindesk.com/v1/bpi/currentprice.json, which returns a JSON object, among whose nested keys is the current price of Bitcoin as a float. Be sure to catch any exceptions, as with code like:
# 
# import requests
# 
# try:
#     ...
# except requests.RequestException:
#     ...
# 
# - Outputs the current cost of n Bitcoins in USD to four decimal places, using , as a thousands separator.
# 
# Hints
# - Recall that the sys module comes with argv, per docs.python.org/3/library/sys.html#sys.argv.
# 
# - Note that the requests module comes with quite a few methods, per requests.readthedocs.io/en/latest, among which are get, per requests.readthedocs.io/en/latest/user/quickstart/#make-a-request, and json, per requests.readthedocs.io/en/latest/user/quickstart/#json-response-content. You can install it with:
# pip install requests
# 
# - Note that CoinDesk’s API returns a JSON response like:
# {
#    "time":{
#       "updated":"May 2, 2022 15:27:00 UTC",
#       "updatedISO":"2022-05-02T15:27:00+00:00",
#       "updateduk":"May 2, 2022 at 16:27 BST"
#    },
#    "disclaimer":"This data was produced from the CoinDesk Bitcoin Price Index (USD). Non-USD currency data converted using hourly conversion rate from openexchangerates.org",
#    "chartName":"Bitcoin",
#    "bpi":{
#       "USD":{
#          "code":"USD",
#          "symbol":"&#36;",
#          "rate":"38,761.0833",
#          "description":"United States Dollar",
#          "rate_float":38761.0833
#       },
#       "GBP":{
#          "code":"GBP",
#          "symbol":"&pound;",
#          "rate":"30,827.6198",
#          "description":"British Pound Sterling",
#          "rate_float":30827.6198
#       },
#       "EUR":{
#          "code":"EUR",
#          "symbol":"&euro;",
#          "rate":"36,800.2764",
#          "description":"Euro",
#          "rate_float":36800.2764
#       }
#    }
# }
# 
# - Recall that you can format USD to four decimal places with a thousands separator with code like:
# print(f"${amount:,.4f}")
# 
# Demo
# This demo was recorded when the price of Bitcoin was $38,761.0833. Your own output may vary.
# $ python bitcoin.py
# Missing command-line argument
# $ python bitcoin.py cat
# Command-line argument is not a number
# $ python bitcoin.py 1
# $38,761.0833
# $ python bitcoin.py 1.5
# $58,141.6249
# $ python bitcoin.py 2
# $77,522.1666

import sys
import requests

if len(sys.argv) != 2: sys.exit("Missing command-line argument")
else:
    try:
        request = requests.get("https://api.coindesk.com/v1/bpi/currentprice.json")
        n = float(sys.argv[1])
    except requests.RequestException:
        sys.exit("Request Error")
    except ValueError:
        sys.exit("Command-line argument is not a number")

    json = request.json()
    rate = float(json["bpi"]["USD"]["rate_float"])

    total = n * rate
    print(f"${total:,.4f}")