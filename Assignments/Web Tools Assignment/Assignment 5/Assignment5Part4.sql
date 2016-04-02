use Assignment4Part4;

select * from SaleDetails;

truncate SaleDetails;

drop table SaleDetails;

desc SaleDetails;

create table saleDetails (
salesOrderID varchar(30) Primary Key,
revisionNumber varchar(30),
orderDate varchar(25),
dueDate varchar(25),
shipDate varchar(25),
status varchar(30),
onlineOrderFlag varchar(25),
salesOrderNumber varchar(25),
purchaseOrderNumber varchar(25),
accountNumber varchar(25),
customerID varchar(30),	
salesPersonID varchar(30),
territoryID varchar(30),
billToAddressID varchar(30),
shipToAddressID varchar(30),
shipMethodID varchar(30),
creditCardID varchar(30),
creditCardApprovalCode varchar(25),
currencyRateID varchar(25),
subTotal varchar(30),
taxAmt varchar(30),
freight varchar(30),
totalDue varchar(25),
comment varchar(25),
modifiedDate varchar(25)
);