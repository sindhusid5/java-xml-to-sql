 
# Java XML Data Merge and Database Insertion

This project demonstrates how to merge two XML files (`file1.xml` and `file2.xml`) containing data about people (e.g., name, address, phone number, salary, pension) and insert the merged data into a MySQL database.

The project has the following steps:
1. **Merging XML Files**: The two XML files are merged into a single XML file, removing unnecessary XML tags (`<geodata>`, `<salarydata>`).
2. **Parsing XML**: The merged XML file is parsed, extracting information about each person.
3. **Inserting into Database**: The extracted data is inserted into a MySQL database.

## Files Included
- `MergeXml.java`: A Java program that reads two XML files, removes certain XML tags, and merges them into a new XML file (`persondata.xml`).
- `Sidzz.java`: A Java program that parses the merged XML file (`persondata.xml`) and inserts data into a MySQL database (`persondata` table).
- `DbConnect.java`: A utility Java class that handles the connection to a MySQL database.
- `file1.xml`: The first XML file containing information about people’s address and phone number.
- `file2.xml`: The second XML file containing information about people’s salary and pension.

## Requirements
- **Java 8+**
- **MySQL Database**: A MySQL database with the following configuration:
  - **Database**: `person`
  - **Table**: `persondata`
  
  The `persondata` table should have columns for:
  - `person_name` (VARCHAR)
  - `address` (VARCHAR)
  - `phonenumber` (VARCHAR)
  - `salary` (VARCHAR)
  - `pension` (VARCHAR)

- **JDBC Driver**: MySQL JDBC driver (`com.mysql.cj.jdbc.Driver`)

## Setup and Installation

### 1. Clone the Repository

```bash
git clone https://github.com/sindhusid5/java-xml-to-sql.git
cd java-xml-to-sql
```

### 2. Set up the Database
1. Create a MySQL database and table. You can use the following SQL script:

```sql
CREATE DATABASE person;

USE person;

CREATE TABLE persondata (
    person_name VARCHAR(255),
    address VARCHAR(255),
    phonenumber VARCHAR(20),
    salary VARCHAR(20),
    pension VARCHAR(20)
);
```

### 3. Configure Database Credentials
Update the connection details in `Sidzz.java` and `DbConnect.java` with your MySQL username and password:
```java
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/person", "your-username", "your-password");
```

### 4. Run the Java Programs

#### a. Merge the XML Files
1. Run the `MergeXml.java` program to merge the data from `file1.xml` and `file2.xml` into a single `persondata.xml` file.

```bash
javac MergeXml.java
java MergeXml
```

This will create a new `persondata.xml` file that combines the data from both XML files.

#### b. Parse the Merged XML and Insert Data into MySQL
2. Run the `Sidzz.java` program to parse the merged `persondata.xml` file and insert the extracted data into the MySQL database.

```bash
javac Sidzz.java
java Sidzz
```

This will parse `persondata.xml` and insert the data for each person (name, address, phone number, salary, pension) into the `persondata` table in MySQL.

#### c. Test Database Connection
You can test the database connection using the `DbConnect.java` class, which connects to MySQL and closes the connection. This helps ensure that your MySQL setup is correct.

```bash
javac DbConnect.java
java DbConnect
```

### 5. Sample Output
After running the programs, you should see the following in the console:

- **`MergeXml`**: 
  ```text
  XML files merged successfully
  ```
  
- **`Sidzz`**: 
  ```text
  Data is successfully inserted!
  ```

- **`DbConnect`**: 
  ```text
  MySQL JDBC Driver Registered!
  SQL Connection to database established!
  Connection closed !!
  ```

## Conclusion
This project demonstrates how to merge XML files, extract data, and insert it into a MySQL database using Java.  