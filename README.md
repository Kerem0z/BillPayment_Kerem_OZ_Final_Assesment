## Customer Bills and Payment Backend Project

In this project you can create customers ,customer bills and bill payment actions 

### Customer CRUD Actions

#### 1-Create Customer (users/userAdd)
```json
{
    "name": "kerem",
    "lastName" : "öz"
}
```
#### 2-Get all Customer (users/getAll)

No Body required for this method

#### 3-Delete Customer (users/delete/"user_id")

With @Pathvariable annotation no body needed.
customer id needed for deleting method and if customer has any bills customer cant be deleted. 

#### 4-Update Customer (users/update)
```json
{
    "userId" : 1,
    "name": "kerem1",
    "lastName" : "oz1"
}
```
### Bill CRUD Actions

#### 1-Create Bill (bill/add)
```json
{  
    "billAmount": 100.0,
    "payment" : false,
    "user": {
        "userId" : 1
    }
}
```
#### 2-Delete Bill (users/delete/"userId"?"billId"?)
has 1 query params need user id for deleting bill
when userId given all the bills got paid.

#### 3-Get All Bills (bill/getAll)
with this method all bills will be showin

#### 4-Get all Bill not paid (bill/getAllFalse?userId=?)
Shows all unpaid bills

#### 5-Bill Payment (payment/pay?userId=?)
has 2 query params need userId and billId for paying bill.


