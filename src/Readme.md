# Page object practice. Saucedemo lab.

1.
[INFO] The following dependencies in Dependencies have newer versions:

[INFO]   org.seleniumhq.selenium:selenium-java ...... 4.1.0 -> 4.1.2

2.
mvn clean test

Results:

[INFO] Tests run: 12, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 37.701 s - in TestSuite

3.
mvn -Dtest=ProductTest test

Results :

[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 10.675 s - in saucedemoTest.ProductTest


mvn clean test -Dsuite=SuiteTest

Results :

[INFO] Tests run: 12, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 39.548 s - in TestSuite


mvn -Dtest=CatalogTest#sortingAtoZTest test

Results :

[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 3.91 s - in saucedemoTest.CatalogTest



mvn -Dtest=CatalogTest#sortingZtoATest+menuIsOpenedTest test

Results :

[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 8.735 s - in saucedemoTest.CatalogTest


Testing Saucedemo is an online store.

###Checklist

| Name| Test |Automated test |
|-----|------|-------|
|Login page |valid login| + | 
|Login page |testing "Locked user"| + | 
|Catalog page| open "BURGER MENU"| + | 
|Catalog page| testing button "LOGOUT"| + | 
|Catalog page| sort by A to Z| + | 
|Catalog page| sort by Z to A | + | 
|Catalog page| sort by low to high| + | 
|Catalog page| sort by high to low| + | 
|Catalog page| add product to cart| + | 
|Catalog page| return from cart and add product to cart| + | 
|Cart page |open to card| + |
|Cart page |check product to card| + |
|Cart page |delete product from card| + |
|Checkout page |checkout product| +  |
|Checkout page |continue | +  |
|Checkout page |user in form| +  |
|Checkout:overview page |pushFinish| + |
|Checkout complete page|back home| +  |