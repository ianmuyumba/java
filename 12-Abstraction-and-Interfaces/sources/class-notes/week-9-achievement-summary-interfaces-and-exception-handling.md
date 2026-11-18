# Week 9 - Achievement Summary - Interfaces and Exception Handling

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: Week 9 - Achievement Summary - Interfaces and Exception Handling.pdf

> Searchable PDF transcription. Page text preserves extraction order; diagrams, table alignment and code indentation may require the archived PDF. Use the unit README for edited study notes.


## PDF page 1

<details>
<summary>Page text</summary>

```text
Week 9 Achievement Summary: Interfaces & Exception Handling 
Dear Student, 
Welcome to the end of Week 9! You have just learned two of the most critical skills for building 
enterprise-level software: designing flexible architectures with Interfaces and building crash-
proof applications with Exception Handling. 
You now know how to make different parts of a system communicate safely and how to prevent 
your app from breaking when things go wrong. Here is a summary of what you achieved and 
how it powers the real world. 
 
    Learning Outcome 1: Evaluate when to use an interface vs. an abstract class in a given 
design scenario. 
What You Learned: 
You learned the difference between an "IS-A" relationship (Abstract Class) and a "CAN-DO" 
relationship (Interface). An abstract class is used for closely related objects that share code and 
state, while an interface is a pure contract used to define a specific capability that unrelated 
classes can share. 
Real-Life Application: 
Think about a Smartphone. 
• It IS A Device (Abstract Class) because it has common features like a battery and a 
screen. 
• But it CAN DO Camera, MusicPlayer, and GPS (Interfaces). A SecurityCamera might also 
implement the Camera interface, but it wouldn't extend the Device class. Interfaces 
allow unrelated objects to share behaviors. 
 
    Learning Outcome 2: Create a class that implements multiple interfaces to achieve 
polymorphic behavior. 
What You Learned: 
Java doesn't allow a class to extend multiple parent classes (no multiple inheritance), but you 
learned that a class can implements multiple interfaces. This allows an object to take on many 
forms and be treated as different types depending on what the code needs.
```

</details>


## PDF page 2

<details>
<summary>Page text</summary>

```text
Real-Life Application: 
Consider a Smart Home System. You have a SmartSpeaker class. It can implement 
VoiceAssistant, MusicPlayer, and WiFiConnectable. A SmartTV class might implement 
MusicPlayer and WiFiConnectable. Later, the system can loop through a list of MusicPlayer 
objects and play audio, regardless of whether the object is a speaker, a TV, or a phone. 
 
    Learning Outcome 3: Analyze exception handling code to determine if exceptions are 
properly caught or propagated. 
What You Learned: 
You learned how to use try-catch-finally blocks to stop your program from crashing. You 
analyzed how the try block monitors dangerous code, the catch block handles the error 
gracefully, and the finally block guarantees that cleanup code (like closing files) always runs. 
Real-Life Application: 
Think about using an ATM or Banking App. If the network drops while you are sending money, 
the app doesn't just crash and lose your data. The developer wrote a try-catch block. When the 
NetworkException happens, the program catches it and displays a friendly message: "Network 
unavailable. Please try again later," while safely preserving your account balance. 
 
    Learning Outcome 4: Design a custom exception hierarchy for a domain-specific problem. 
What You Learned: 
You learned that Java's built-in exceptions aren't always enough. By extending the Exception 
class, you created your own custom exceptions (like InsufficientFundsException). You also 
learned how to use the throw keyword to trigger the error and throws to warn the compiler. 
Real-Life Application: 
Imagine a Stock Trading Platform. If a user tries to buy 100 shares of Safaricom but only has 
enough money for 50, a generic Java error like "NumberFormatException" makes no sense. 
Instead, the system throws a custom InsufficientCapitalException. This allows the user interface 
to display a precise, helpful message: "Your balance is too low to purchase 100 shares." 
 
        The Big Picture 
In the real world, software must interact with databases, networks, and user inputs—all of 
which are unpredictable. Interfaces allow you to swap out components easily (e.g., changing a
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
payment gateway from M-Pesa to Stripe without breaking the app), while Exception Handling 
ensures that your application remains stable and professional when things go wrong. 
Before class starts, make sure your Week 9 code is pushed to GitHub! See you in Week 10 
(Collections & File I/O)!
```

</details>
