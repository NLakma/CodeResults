# swivel  - Coding Challenge

# Requirements
* Java 8
* Apache Maven 3.6.0 


Alternatively, open the project in an IDE and run `Main.java`

# Data

By default the application uses the files present in the `resources` folder as input files.
```
$ ls src/main/resources/*.json
users.json tickets.json organizations.json

```
JSON files:
* organizations.json
* users.json
* tickets.json
```

# Design

Inhere input file is scanned and each record is converted into a JSON Object.
All JSON Objects are loaded into a data structure called `Dictionary`.

`Dictionary` consists of 
* A `List` which contains actual JSON objects
* An `Inverted Index (Map<String<Multimap<String,Integer>)` which contains mapping of terms to a multimap containing values and list of indices of the actual objects containing those values

# Assumptions

* Input files are valid `JSON` files.
* Names of the member variables in the model classes match the attribute names of the json
* Json records in the input file are in the form of an `array` 
* Model class has the id field annotated with `@Id`
* Attribute `_id` is unique and document has just one record per `_id`
* `_id` cannot be null

# Features

* Empty fields can be searched as well.
* Values in the array can be searched independently. All records containing the particular array value will be matched
* Search is case-insensitve
* Keys for the date values are stored  in "YYYY-MM-dd" format. 