# Week 1 - Practical Lab 1 - Install VS Code, Git and GitHub

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: Week 1 - Practical Lab 1 - Install VS Code, Git and GitHub.pdf

> Searchable PDF transcription. Page text preserves extraction order; diagrams, table alignment and code indentation may require the archived PDF. Use the unit README for edited study notes.


## PDF page 1

<details>
<summary>Page text</summary>

```text
Practical Lab 1: Setting Up Your Java Development Environment 
Student-Centered, Self-Paced Guide 
 
 Lab Objectives 
By the end of this lab, you will have: 
1. Installed VS Code (your code editor) 
2. Installed Git (your version control tool) 
3. Created a GitHub account (your online code portfolio) 
4. Connected VS Code to GitHub 
5. Pushed your first Java program to GitHub 
Time Required: 60–90 minutes 
Difficulty: Beginner 
Instructor Intervention: None – you will figure it out yourself! 
 
 Before You Begin 
You will need: 
• A computer running Windows, macOS, or Linux 
• Internet connection 
• An email address 
• Patience and curiosity! 
Golden Rule: If you get stuck, Google the error message. That's what real developers do. Only 
ask a classmate or instructor after you've tried: 
1. Reading the error message carefully 
2. Searching on Google 
3. Watching a YouTube tutorial
```

</details>


## PDF page 2

<details>
<summary>Page text</summary>

```text
Your Roadmap 
 
STEP 1: Install JDK (Java Development Kit) 
Why? Java code needs the JDK to compile and run. 
        Windows 
1. Open your browser and go to: https://adoptium.net/ 
2. Click the big blue button that says "Latest LTS Release" (LTS = Long Term Support) 
3. Download the Windows x64 Installer (.msi file) 
4. Run the installer 
5. IMPORTANT: Check the box that says "Set JAVA_HOME variable" 
6. Click Next → Next → Install 
7. Wait for installation to complete
```

</details>


## PDF page 3

<details>
<summary>Page text</summary>

```text
macOS 
Option A: Using Homebrew (Recommended) 
1. Open Terminal (Press Cmd + Space, type "Terminal", press Enter) 
2. Paste this command and press Enter: 
bash 
/bin/bash -c "$(curl -fsSL 
https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)" 
3. Wait for Homebrew to install (may take 10 minutes) 
4. Then run: 
bash 
brew install openjdk@21 
Option B: Manual Download 
1. Go to: https://adoptium.net/ 
2. Download the macOS Installer (.pkg file) 
3. Run the installer and follow the prompts 
 
       Linux (Ubuntu/Debian) 
1. Open Terminal (Ctrl + Alt + T) 
2. Run these commands one by one: 
bash 
sudo apt update 
sudo apt install openjdk-21-jdk -y 
 Verify JDK Installation 
Open your terminal/command prompt and type: 
bash 
java -version
```

</details>


## PDF page 4

<details>
<summary>Page text</summary>

```text
Expected output (something like): 
openjdk version "21.0.1" 2024-10-15 
OpenJDK Runtime Environment (build 21.0.1+12) 
OpenJDK 64-Bit Server VM (build 21.0.1+12, mixed mode) 
 If you see "command not found": 
• Windows: Restart your computer and try again 
• macOS/Linux: Close and reopen Terminal 
 
STEP 2: Install VS Code 
Why? VS Code is your code editor – where you'll write Java programs. 
All Operating Systems 
1. Open your browser and go to: https://code.visualstudio.com/ 
2. Click the big Download button (it auto-detects your OS) 
3. Run the installer: 
o Windows: Double-click the .exe file → Accept → Next → Next → Install 
o macOS: Open the .zip file → Drag Visual Studio Code to Applications 
o Linux: Install the .deb file using your software center, or run: 
bash 
sudo dpkg -i code_*.deb 
 Verify VS Code Installation 
1. Open VS Code 
2. You should see the Welcome screen 
 Install Essential Extensions 
Inside VS Code: 
1. Click the Extensions icon on the left sidebar (looks like 4 squares) 
2. Search for and install these extensions (click Install for each):
```

</details>


## PDF page 5

<details>
<summary>Page text</summary>

```text
o Extension Pack for Java (by Microsoft) 
o GitLens (by GitKraken) 
o Prettier (by Prettier) 
 Wait for each extension to finish installing before moving on. 
 
STEP 3: Install Git 
Why? Git tracks changes in your code and lets you push to GitHub. 
        Windows 
1. Go to: https://git-scm.com/download/win 
2. The download should start automatically 
3. Run the .exe installer 
4. IMPORTANT: Keep all default settings – just click Next repeatedly 
5. Click Install 
   macOS 
Option A: Using Homebrew 
bash 
brew install git 
Option B: Using Xcode Command Line Tools 
bash 
xcode-select --install 
A popup will appear – click Install. 
       Linux (Ubuntu/Debian) 
bash 
sudo apt install git -y 
   Verify Git Installation 
Open terminal and type:
```

</details>


## PDF page 6

<details>
<summary>Page text</summary>

```text
bash 
git --version 
Expected output: 
text 
git version 2.43.0 
 
STEP 4: Create GitHub Account 
Why? GitHub is your online portfolio – where employers will see your code. 
1. Open your browser and go to: https://github.com/ 
2. Click Sign up (top right corner) 
3. Enter: 
o Email: Use a professional email (e.g., firstname.lastname@gmail.com) 
o Password: Strong password (12+ characters) 
o Username: Use your real name (e.g., john-otieno or jotieno-dev) 
✓ IMPORTANT: Choose a professional username – this is your developer identity! 
4. Complete the puzzle/verification 
5. Check your email and enter the verification code 
6. On the "Welcome" screen, you can skip personalization 
7. Choose the Free plan 
✓ Verify GitHub Account 
1. Go to: https://github.com/YOUR-USERNAME 
o Replace YOUR-USERNAME with your actual username 
2. You should see your profile page 
✓ Personalize Your Profile (Optional but Recommended) 
1. Click the Edit profile button 
2. Add:
```

</details>


## PDF page 7

<details>
<summary>Page text</summary>

```text
o Your full name 
o A short bio: "First-year Computer Science student learning Java" 
o Your university 
3. Click Save 
 
STEP 5: Configure Git 
Why? Git needs to know who you are so your commits are labeled correctly. 
Open your terminal and run these commands one by one: 
bash 
git config --global user.name "Your Full Name" 
bash 
git config --global user.email "your.email@example.com" 
Replace with your actual information. For example: 
bash 
git config --global user.name "John Otieno" 
git config --global user.email "john.otieno@gmail.com" 
✓ Use the SAME email you used for GitHub! 
✓ Verify Configuration 
bash 
git config --list 
You should see your name and email in the output. 
 
STEP 6: Connect VS Code to GitHub 
1. Open VS Code 
2. Click the Accounts icon at the bottom-left (looks like a person) 
3. Click "Sign in with GitHub"
```

</details>


## PDF page 8

<details>
<summary>Page text</summary>

```text
4. A browser window opens – click Authorize Visual Studio Code 
5. VS Code will show "Signed in as YOUR-USERNAME" 
✓ Verify Connection 
1. In VS Code, press Ctrl + Shift + P (Windows/Linux) or Cmd + Shift + P (Mac) 
2. Type: GitHub: Sign in 
3. You should see you're already signed in 
 
STEP 7: Create Your First Java Project 
7.1 Create a Folder for Your Course 
1. Open File Explorer (Windows) or Finder (Mac) or Files (Linux) 
2. Navigate to your Documents folder 
3. Create a new folder called: java-course 
4. Inside java-course, create a subfolder called: week1 
7.2 Open the Folder in VS Code 
1. Open VS Code 
2. Click File → Open Folder 
3. Select your java-course folder 
4. Click Select Folder (Windows) or Open (Mac) 
7.3 Create Your First Java File 
1. In VS Code, right-click on the week1 folder in the sidebar 
2. Click New File 
3. Name it: HelloWorld.java 
4. Press Enter 
7.4 Write Your First Java Program 
Copy and paste this code into HelloWorld.java: 
java
```

</details>


## PDF page 9

<details>
<summary>Page text</summary>

```text
/** 
 * My first Java program 
 * @author Your Name 
 * @date Today's Date 
 */ 
public class HelloWorld { 
    public static void main(String[] args) { 
        System.out.println("Hello, World!"); 
        System.out.println("My name is: [Your Name]"); 
        System.out.println("I am learning Java at [Your University]"); 
        System.out.println("Today's date is: [Today's Date]"); 
    } 
} 
Replace the bracketed text with your actual information. 
7.5 Run Your Program 
1. Press Ctrl + S to save the file 
2. Click the Run button (  ) at the top-right of VS Code 
3. In the terminal at the bottom, you should see: 
Output 
Hello, World! 
My name is: John Otieno 
I am learning Java at University of Nairobi 
Today's date is: 2026-01-15 
✓ Congratulations! You just ran your first Java program!
```

</details>


## PDF page 10

<details>
<summary>Page text</summary>

```text
STEP 8: Push to GitHub 
8.1 Initialize Git in Your Project 
1. In VS Code, click the Source Control icon on the left sidebar (looks like a branch) 
2. Click "Initialize Repository" 
3. You should see your files listed under "Changes" 
8.2 Create a .gitignore File 
Why? To prevent unnecessary files (like compiled .class files) from being uploaded. 
1. Right-click on the java-course folder 
2. Click New File 
3. Name it: .gitignore 
4. Paste this content: 
text 
# Compiled Java files 
*.class 
 
# VS Code settings 
.vscode/ 
 
# OS files 
.DS_Store 
Thumbs.db 
 
# Logs 
*.log 
5. Save the file (Ctrl + S)
```

</details>


## PDF page 11

<details>
<summary>Page text</summary>

```text
8.3 Stage and Commit Your Changes 
1. In VS Code, go to Source Control panel 
2. You should see HelloWorld.java and .gitignore under "Changes" 
3. Click the + icon next to each file to stage them 
(Or hover over "Changes" and click the + to stage all) 
4. In the message box at the top, type: Initial commit: Hello World program 
5. Click the ✓ Commit button 
8.4 Create a GitHub Repository 
1. Open your browser and go to https://github.com/ 
2. Click the + icon (top-right) → New repository 
3. Fill in: 
o Repository name: java-course 
o Description: My Java learning journey - OOP Course 
o Visibility:    Public (so employers can see your work) 
o DO NOT check "Add a README file" 
4. Click Create repository 
8.5 Connect Local Repository to GitHub 
After creating the repository, GitHub will show you commands. In VS Code terminal (Ctrl + ~), 
run: 
bash 
git remote add origin https://github.com/YOUR-USERNAME/java-course.git 
Replace YOUR-USERNAME with your actual GitHub username. 
Then push: 
bash 
git branch -M main 
git push -u origin main
```

</details>


## PDF page 12

<details>
<summary>Page text</summary>

```text
8.6 Authenticate with GitHub 
A browser window may open asking you to authorize Git. Click Authorize. 
If prompted for credentials: 
✓ Username: Your GitHub username 
✓ Password: Use a Personal Access Token (not your GitHub password) 
o To create one: GitHub → Settings → Developer settings → Personal access tokens 
→ Tokens (classic) → Generate new token 
o Select scope: repo (full control) 
o Copy the token and use it as your password 
✓ Verify Push Success 
1. Refresh your GitHub repository page 
2. You should see: 
o HelloWorld.java 
o .gitignore 
o A commit message: "Initial commit: Hello World program" 
CONGRATULATIONS! You've pushed your first code to GitHub! 
 
Final Self-Assessment Checklist 
Tick each box only when you've verified it: 
• □ JDK installed and java -version works 
• □ VS Code installed with Java Extension Pack 
• □ Git installed and git --version works 
• □ GitHub account created and verified 
• □ Git configured with name and email 
• □ VS Code signed in to GitHub 
• □ HelloWorld.java created and runs successfully
```

</details>


## PDF page 13

<details>
<summary>Page text</summary>

```text
• □ .gitignore file created 
• □ Local repository initialized 
• □ First commit made 
• □ GitHub repository created 
• □ Code pushed to GitHub 
• □ I can see my code on github.com 
If you ticked all boxes → YOU ARE AMAZING!  
 
➢ Troubleshooting Guide 
Problem Solution 
java: command not found Restart terminal/computer. Reinstall JDK and check "Set JAVA_HOME" 
git: command not found Restart terminal. Reinstall Git with default settings 
VS Code won't run Java Install "Extension Pack for Java" from Extensions marketplace 
"Permission denied" on push Use Personal Access Token instead of password 
"Repository not found" Check the URL: https://github.com/YOUR-USERNAME/java-course.git 
Files not showing in Source 
Control Save all files (Ctrl + S), then refresh VS Code 
Merge conflict error Don't panic! Run git pull origin main --rebase then git push 
GitHub email not verified Check spam folder. Resend verification email
```

</details>


## PDF page 14

<details>
<summary>Page text</summary>

```text
➢ Challenge Tasks (For Fast Finishers) 
If you finish early, try these: 
1. Create a second Java file called AboutMe.java that prints 5 facts about you. Push it to 
GitHub. 
2. Modify .gitignore to also ignore .pdf files. 
3. Add a README.md file to your repository with: 
markdown 
# My Java Course 
 
## About Me 
- Name: [Your Name] 
- University: [Your University] 
- Course: Object-Oriented Programming 
 
## What I'm Learning 
- Java fundamentals 
- Object-oriented programming 
- Git and GitHub 
 
## My Progress 
- [x] Week 1: Setup complete 
- [ ] Week 2: Variables and data types 
4. Create a folder called week2 and push it (with a placeholder file). 
5. Explore GitHub: Find 3 Java repositories you find interesting and star them.
```

</details>


## PDF page 15

<details>
<summary>Page text</summary>

```text
➢ Weekly Workflow (What You'll Do Every Week) 
From now on, every time you write code in class: 
 
Commit Messages Should Be: 
• Week 2: Variables and operators practice 
• Week 3: Loop exercises - triangle patterns 
• Week 4: OOP - BankAccount class 
 
➢ Reflection Questions 
After completing this lab, answer these in your notebook: 
1. What was the most challenging part of this setup? 
2. What error message did you encounter, and how did you solve it? 
3. Why do developers use Git and GitHub? 
4. How will this setup help you in your career?
```

</details>


## PDF page 16

<details>
<summary>Page text</summary>

```text
➢ What You've Achieved 
You have just set up the exact same professional development environment used by software 
engineers at: 
• Safaricom 
• Google 
• Microsoft 
• Andela 
• Every major tech company in the world 
You are no longer just a student - you are a developer. 
 
➢ Next Steps 
In your next class, you will: 
1. Write Java programs using variables and data types 
2. Push each program to your GitHub repository 
3. Build a portfolio that will impress future employers 
Remember: Every professional developer has a GitHub account. Yours is now live! 
 
 
 Additional Resources (Self-Help) 
Topic Resource 
Git Basics https://git-scm.com/book/en/v2/Getting-Started-Git-Basics 
GitHub Guides https://guides.github.com/
```

</details>


## PDF page 17

<details>
<summary>Page text</summary>

```text
Topic Resource 
VS Code Java https://code.visualstudio.com/docs/java/java-tutorial 
Markdown Guide https://www.markdownguide.org/basic-syntax/ 
Java Documentation https://docs.oracle.com/en/java/ 
 
END OF PRACTICAL LAB 1 
"The expert in anything was once a beginner." – Helen Hayes
```

</details>
