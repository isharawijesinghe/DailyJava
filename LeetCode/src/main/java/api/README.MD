## Hackerrank REST API Intermediate certification 

### Question 1 : Total Goal By a team

#### Input
Year and Team name.

To access collection of match perform GET request
`https://jsonmock.hackerrank.com/api/football_matches?year=<year>&team1=<team>&page=<page>` and
`https://jsonmock.hackerrank.com/api/football_matches?year=<year>&team2=<team>&page=<page>`

- `<year>`: year of competition
- `<team>`: name of team
- `<page>`: page number of request
- `team1` : home team
- `team2` : visiting team
 
#### Output
Get all matches a particular team played. 

In order to get all matches a team played in , need to retrive the matches where team was home team and the visiting team.

totalgoal = team1goal(from 1st URL)+team2goal(from 2nd URL)

#### Sample Input

```
https://jsonmock.hackerrank.com/api/football_matches?year=2011&team1=Barcelona&page=1
{
    "page": 1,
    "per_page": 10,
    "total": 6,
    "total_pages": 1,
    "data": [
        {
            "competition": "UEFA Champions League",
            "year": 2011,
            "round": "GroupH",
            "team1": "Barcelona",
            "team2": "AC Milan",
            "team1goals": "2",
            "team2goals": "2"
        },
        {
            "competition": "UEFA Champions League",
            "year": 2011,
            "round": "GroupH",
            "team1": "Barcelona",
            "team2": "Viktoria Plzen",
            "team1goals": "2",
            "team2goals": "0"
        },
        ....
    ]
}
https://jsonmock.hackerrank.com/api/football_matches?year=2011&team2=Barcelona&page=1
{
    "page": 1,
    "per_page": 10,
    "total": 6,
    "total_pages": 1,
    "data": [
        {
            "competition": "UEFA Champions League",
            "year": 2011,
            "round": "GroupH",
            "team1": "BATE Borisov",
            "team2": "Barcelona",
            "team1goals": "0",
            "team2goals": "5"
        },
        {
            "competition": "UEFA Champions League",
            "year": 2011,
            "round": "GroupH",
            "team1": "Viktoria Plzen",
            "team2": "Barcelona",
            "team1goals": "0",
            "team2goals": "4"
        },
        ...
    ]
}
```

### Question 2 : Football competition winner team goal



### Question 3 : Number of Drawn matches


### Question 3 : Barcode Find 

```
The response is a JSON object with 5 fields. The essential field is data:

data: Either an empty array or an array with a single object that contains the item's record.
In the data array, the item has the following schema:
barcode - the barcode for the product (String)
price - the gross selling price (Number)
discount: the discount percent to apply (Number).
Some fields that are not of interest.
page, per_page, total, total_pages, etc. are not required for this task.

If the barcode is found, the data array contains exactly 1 element. If not, it is empty and the function should return '-1'.

An example of the product record from https://jsonmock.hackerrank.com/api/inventory?barcode=74001755 is:

{
"barcode": "74001755",
"item": "Ball Gown",
"category": "Full Body Outfits",
"price": 785,
"discount": 7,
"available": 1
}
Use the "discount" and the "price" properties to calculate the discounted price rounded to the nearest integer.

discountedPrice = price - ((discount / 100) * price)
Function Description

Complete the getDiscountedPrice function in the editor.

getDiscountedPrice has the following parameters:

string barcode: the item to query
Returns

int: the discounted price rounded to the nearest integer or -1
Constraints

There will be either 1 or 0 records in data.
```

#### Solution used

- Java 8
- `URL` and `HttpURLConnection` from package java.net.*;
- Parsing json object with Gson. External jar used: gson-2.8.2
- recursive call to get all pagination data response