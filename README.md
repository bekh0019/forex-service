## Forex Service
Forex Service (FS) is the Service Provider. It provides currency exchange values for various currency.

GET to http://localhost:8000/currency-exchange/from/EUR/to/INR

{
  id: 10002,
  from: "EUR",
  to: "INR",
  conversionMultiple: 75,
  port: 8000,
}

![forex-service](https://user-images.githubusercontent.com/33734675/87420374-d1693a00-c5dd-11ea-81c9-8521d8e59943.png)

## Currency Conversion Service (CCS)
Currency Conversion Service (CCS) can convert a bucket of currencies into another currency. 
It uses the Forex Service to get current currency exchange values. CCS is the Service Consumer.

http://localhost:8100/currency-converter/from/EUR/to/INR/quantity/10000

{
  id: 10002,
  from: "EUR",
  to: "INR",
  conversionMultiple: 75,
  quantity: 10000,
  totalCalculatedAmount: 750000,
  port: 8000,
}

![CCS](https://user-images.githubusercontent.com/33734675/87420386-d62dee00-c5dd-11ea-88ce-92ad9c9aa7f7.png)

