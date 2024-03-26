-- SCHEMA: questionservice 	TABLE: questions
-- SCHEMA: quizservice 		TABLE: quiz_entity_questions , quiz_table


INSERT INTO questions (correct, difficultylevel, explanation, option1, option2, option3, option4, questioncategory, questiontext)
VALUES
    ('Java Virtual Machine', 'Intermediate', 'The Java Virtual Machine (JVM) is responsible for executing Java byte code.', 'Java Compiler', 'Java Interpreter', 'Java Virtual Machine', 'Java Debugger', 'Java', 'What component of the Java platform is responsible for executing Java byte code?'),
    ('Garbage Collection', 'Beginner', 'Garbage Collection automatically reclaims memory occupied by objects that are no longer reachable.', 'Object Creation', 'Memory Allocation', 'Garbage Collection', 'Thread Synchronization', 'Java', 'Which process in Java automatically reclaims memory occupied by objects that are no longer reachable?'),
    ('Inheritance', 'Intermediate', 'Inheritance allows a class to inherit properties and behaviors from another class.', 'Polymorphism', 'Abstraction', 'Inheritance', 'Encapsulation', 'Java', 'What concept in Java allows a class to inherit properties and behaviors from another class?'),
    ('NullPointerException', 'Intermediate', 'A NullPointerException occurs when an attempt is made to access an object that is not initialized.', 'ArrayIndexOutOfBoundsException', 'ClassCastException', 'NullPointerException', 'FileNotFoundException', 'Java', 'Which exception is thrown when an attempt is made to access an object that is not initialized?'),
    ('ArrayList', 'Beginner', 'An ArrayList is a dynamic array-like data structure in Java that can grow or shrink in size.', 'LinkedList', 'HashSet', 'ArrayList', 'HashMap', 'Java', 'Which data structure in Java is a dynamic array that can grow or shrink in size?'),
    ('public static void main(String[] args)', 'Beginner', 'The main method is the entry point of a Java program and is used to start its execution.', 'public static void start()', 'public static int main()', 'public static void initialize(String[] args)', 'public void main(String[] args)', 'Java', 'What is the standard signature of the main method in a Java program?'),
    ('SyntaxError', 'Beginner', 'A SyntaxError occurs when the syntax of a program is incorrect and violates the rules of the programming language.', 'RuntimeError', 'LogicError', 'SyntaxError', 'TypeMismatchError', 'Programming Concepts', 'What type of error occurs when the syntax of a program is incorrect?'),
    ('Python', 'Beginner', 'Python is a high-level programming language known for its simplicity and readability.', 'C++', 'Java', 'Python', 'Ruby', 'Programming Languages', 'Which programming language is known for its simplicity and readability?'),
    ('Indentation', 'Beginner', 'In Python, indentation is used to define the scope of code blocks.', 'Semicolons', 'Curly Braces', 'Indentation', 'Parentheses', 'Python', 'In Python, what is used to define the scope of code blocks?'),
    ('Dynamic Typing', 'Intermediate', 'Dynamic typing allows variables to change their data type during runtime.', 'Static Typing', 'Strong Typing', 'Dynamic Typing', 'Weak Typing', 'Python', 'Which typing system allows variables to change their data type during runtime?'),
    ('JavaBean', 'Intermediate', 'A JavaBean is a reusable software component that follows specific naming conventions and can be manipulated visually in development tools.', 'JSP', 'Java Class', 'JavaBean', 'Servlet', 'Java', 'What is a reusable software component in Java that follows specific naming conventions and can be manipulated visually in development tools?'),
    ('Method Overloading', 'Intermediate', 'Method overloading allows a class to have multiple methods with the same name but different parameters.', 'Method Overriding', 'Method Overloading', 'Method Hiding', 'Method Polymorphism', 'Java', 'What Java feature allows a class to have multiple methods with the same name but different parameters?'),
    ('try-catch-finally', 'Intermediate', 'The try-catch-finally block is used to handle exceptions in Java programs, allowing for proper error handling and resource cleanup.', 'if-else', 'switch-case', 'for loop', 'while loop', 'Java', 'Which block is used in Java to handle exceptions and ensures proper error handling and resource cleanup?'),
    ('HashMap', 'Intermediate', 'HashMap is a data structure in Java that stores key-value pairs and provides fast access to values based on their keys.', 'LinkedList', 'HashSet', 'HashMap', 'TreeMap', 'Java', 'Which data structure in Java stores key-value pairs and provides fast access to values based on their keys?'),
    ('Encapsulation', 'Beginner', 'Encapsulation is the concept of bundling data and methods that operate on the data into a single unit, often referred to as a class.', 'Inheritance', 'Polymorphism', 'Abstraction', 'Encapsulation', 'Java', 'Which concept in Java involves bundling data and methods into a single unit, often referred to as a class?'),
    ('public', 'Beginner', 'The "public" access modifier in Java allows a class, method, or field to be accessible from any other class.', 'private', 'protected', 'default', 'public', 'Java', 'Which access modifier in Java allows a class, method, or field to be accessible from any other class?'),
    ('JDBC', 'Intermediate', 'Java Database Connectivity (JDBC) is a Java-based API that enables Java programs to interact with relational databases.', 'ORM', 'ODBC', 'JDBC', 'SQL', 'Java', 'What Java-based API enables programs to interact with relational databases?'),
    ('Polymorphism', 'Intermediate', 'Polymorphism in Java allows objects of different classes to be treated as objects of a common superclass.', 'Inheritance', 'Abstraction', 'Encapsulation', 'Polymorphism', 'Java', 'What concept in Java allows objects of different classes to be treated as objects of a common superclass?'),
    ('Compiler', 'Beginner', 'A compiler is a software that translates high-level programming languages into machine code.', 'Interpreter', 'Debugger', 'Compiler', 'Assembler', 'Programming Concepts', 'What software translates high-level programming languages into machine code?'),
    ('Syntax', 'Beginner', 'Syntax refers to the set of rules that dictate how programs written in a programming language should be structured.', 'Logic', 'Semantics', 'Syntax', 'Grammar', 'Programming Concepts', 'What term refers to the set of rules that dictate how programs written in a programming language should be structured?'),
    ('Inheritance', 'Intermediate', 'In object-oriented programming, inheritance is a mechanism that allows a new class to inherit properties and behaviors from an existing class.', 'Abstraction', 'Polymorphism', 'Encapsulation', 'Inheritance', 'Programming Concepts', 'What object-oriented programming mechanism allows a new class to inherit properties and behaviors from an existing class?'),
    ('Variable Scope', 'Intermediate', 'Variable scope defines where a variable is accessible and can be used within a program.', 'Variable Type', 'Variable Declaration', 'Variable Value', 'Variable Scope', 'Programming Concepts', 'What term defines where a variable is accessible and can be used within a program?'),
    ('SyntaxError', 'Beginner', 'A SyntaxError occurs when the syntax of a program is incorrect and violates the rules of the programming language.', 'RuntimeError', 'LogicError', 'SyntaxError', 'TypeMismatchError', 'Programming Concepts', 'What type of error occurs when the syntax of a program is incorrect?'),
    ('Static Method', 'Intermediate', 'A static method in Java belongs to the class rather than an instance of the class, and can be called using the class name.', 'Instance Method', 'Abstract Method', 'Final Method', 'Static Method', 'Java', 'Which type of method in Java belongs to the class rather than an instance of the class?'),
    ('Thread', 'Intermediate', 'A thread in Java represents the smallest unit of execution in a program, allowing for concurrent and parallel execution.', 'Process', 'Task', 'Function', 'Thread', 'Java', 'What represents the smallest unit of execution in a Java program, allowing for concurrent and parallel execution?'),
    ('Object', 'Beginner', 'In object-oriented programming, an object is an instance of a class that encapsulates data and methods.', 'Class', 'Method', 'Attribute', 'Object', 'Programming Concepts', 'What is an instance of a class that encapsulates data and methods in object-oriented programming?'),
    ('NullPointerException', 'Intermediate', 'A NullPointerException occurs when an attempt is made to access an object that is not initialized.', 'ArrayIndexOutOfBoundsException', 'ClassCastException', 'NullPointerException', 'FileNotFoundException', 'Java', 'Which exception is thrown when an attempt is made to access an object that is not initialized?'),
    ('Class', 'Beginner', 'A class in Java is a blueprint for creating objects, defining their properties and behaviors.', 'Object', 'Method', 'Attribute', 'Class', 'Java', 'What is a blueprint for creating objects and defining their properties and behaviors in Java?'),
    ('IDE', 'Beginner', 'An Integrated Development Environment (IDE) is a software suite that provides tools for writing, testing, and debugging code.', 'Compiler', 'Interpreter', 'Debugger', 'IDE', 'Programming Concepts', 'What software suite provides tools for writing, testing, and debugging code?'),
    ('Binary Search', 'Intermediate', 'Binary search is an efficient algorithm for finding a specific value in a sorted array or list.', 'Linear Search', 'Hashing', 'Sorting', 'Binary Search', 'Algorithms', 'Which algorithm is efficient for finding a specific value in a sorted array or list?');