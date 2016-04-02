create database Assignment4Part4;

use Assignment4Part4;

create table saleDetails (
salesOrderID int,
revisionNumber int,
orderDate varchar(25),
dueDate varchar(25),
shipDate varchar(25),
saleStatus int,
onlineOrderFlag varchar(25),
salesOrderNumber varchar(25),
purchaseOrderNumber varchar(25),
accountNumber varchar(25),
customerID int,	
salesPersonID int,
territoryID int,
billToAddressID int,
shipToAddressID int,
shipMethodID int,
creditCardID int,
creditCardApprovalCode varchar(25),
currencyRateID varchar(25),
subTotal float,
taxAmt float,
freight float,
totalDue varchar(25),
comments varchar(25),
modifiedDate varchar(25)
);

select count(*) from saleDetails;

desc saleDetails;

truncate saleDetails;