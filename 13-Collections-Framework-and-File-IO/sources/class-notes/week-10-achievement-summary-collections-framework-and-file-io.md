# Week 10 - Achievement Summary - Collections Framework and File IO

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: Week 10 - Achievement Summary - Collections Framework and File IO.pdf

> Searchable PDF transcription. Page text preserves extraction order; diagrams, table alignment and code indentation may require the archived PDF. Use the unit README for edited study notes.


## PDF page 1

<details>
<summary>Page text</summary>

```text
Week 10 Achievement Summary: Collections & Permanent Storage 
Dear Student, 
Congratulations on completing Week 10! You have just unlocked the ability to handle massive 
amounts of data and make it permanent. Up until now, whenever you closed your Java 
program, all your data disappeared. You have now learned how to save data to files and how to 
choose the perfect data structure to process it efficiently. 
Here is a summary of what you achieved and how it powers the real world. 
 
    Learning Outcome 1: Analyze the time complexity of operations on different collection 
types (List, Set, Map). 
What You Learned: 
You analyzed how fast it is to find, add, or remove data. You learned that searching through an 
ArrayList (List) takes O(n) time because you have to look at every item. However, finding an item 
in a HashSet (Set) or retrieving a value from a HashMap (Map) takes O(1) time because they use 
a mathematical "hash" to jump directly to the item. 
Real-Life Application: 
Think about Safaricom's M-Pesa customer database. Safaricom has over 30 million users. If you 
dial *334#, you expect an instant response. If the system used a List (O(n)) to find your phone 
number, it would have to check millions of records one by one, taking minutes! Instead, they 
use a HashMap (O(1)) where your phone number is the "Key", allowing the system to instantly 
pull up your "Value" (account balance) in milliseconds. 
 
    Learning Outcome 2: Evaluate which collection type is most appropriate for a given data 
storage requirement. 
What You Learned: 
You evaluated the rules of the three main collections: 
• List (ArrayList): Use when order matters and duplicates are allowed. 
• Set (HashSet): Use when you need to guarantee 100% uniqueness (no duplicates). 
• Map (HashMap): Use when you need to link a unique Key to a specific Value. 
Real-Life Application: 
Imagine building the backend for Jumia or Kilimall.
```

</details>


## PDF page 2

<details>
<summary>Page text</summary>

```text
• The Shopping Cart: Uses a List because a customer might buy two identical iPhones 
(duplicates) and order matters. 
• Active Coupon Codes: Uses a Set because every coupon code must be absolutely 
unique. 
• Product Catalog: Uses a Map where the Key is the Barcode (SKU) and the Value is the 
Product Details. You can instantly scan a barcode and fetch the price. 
 
    Learning Outcome 3: Create an application that reads data from a file, processes it using 
collections, and writes results to a new file. 
What You Learned: 
You built a complete Data Pipeline. You read raw data from a .csv file using Scanner, processed 
it into a HashMap, and generated a formatted report into a new text file using PrintWriter. 
Real-Life Application: 
Consider a HR & Payroll System. At the end of every month, the system reads a massive CSV file 
containing thousands of employees' hours worked. The program loads this data into a Map to 
calculate taxes, generate payslips, and write the final bank transfer details into a secure file that 
is sent to Equity or KCB bank. This automation saves companies weeks of manual work. 
 
    Learning Outcome 4: Debug file I/O code that fails due to unhandled IOException or 
resource leaks. 
What You Learned: 
You learned that interacting with files is dangerous because files can be moved, deleted, or 
locked. You learned to use try-catch blocks to safely handle FileNotFoundException and try-with-
resources to guarantee that your program never leaves a file "open" (which causes memory 
leaks). 
Real-Life Application: 
Think about a Supermarket Point of Sale (POS) system. As a cashier scans items, the system 
writes the transaction to a local backup file. If the computer's hard drive is full or the file gets 
corrupted, a normal program would crash, and the store would stop serving customers. 
However, because you used Exception Handling, the system catches the error gracefully, prints 
a warning, and keeps the POS running so the store doesn't lose money.
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
The Big Picture 
You are no longer writing programs that just exist for a few minutes in a terminal. You now know 
how to collect, organize, process, and permanently save data. These are the exact same tools 
used by backend engineers building the systems that run our economy. 
Before class starts, make sure your Week 10 code is pushed to GitHub! You are now fully 
equipped to build real-world software!
```

</details>
