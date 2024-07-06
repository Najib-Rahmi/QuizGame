package com.example.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionDbHelper extends SQLiteOpenHelper {
    public final static int DATABASE_VERSION=1;
    public final static String DATABASE_NAME="hello";
    public QuestionDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    SQLiteDatabase db;
    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db=db;

        String CREATE_QUIZ_TABLE = "CREATE TABLE Quiz (" +

                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "question TEXT NOT NULL,"+
                "reponse1 TEXT NOT NULL,"+
                "reponse2 TEXT NOT NULL,"+
                "reponse3 TEXT NOT NULL,"+
                "bonnereponse TEXT NOT NULL)";

        db.execSQL(CREATE_QUIZ_TABLE);
        ajoutQuiz(new Quiz("Which method can be defined only once in a program?","static method" ,"main method","finalize method","main method"));
        ajoutQuiz(new Quiz("Which keyword is used to prevent a method from being overridden in its subclasses?", "final", "static", "abstract", "final"));
        ajoutQuiz(new Quiz("What is the default value of a boolean variable in Java?", "true", "false", "0", "false"));
        ajoutQuiz(new Quiz("Which keyword is used to define a constant in Java?", "constant", "final", "static", "final"));
        ajoutQuiz(new Quiz("What is the return type of the hashCode() method in Java?", "int", "void", "boolean", "int"));
        ajoutQuiz(new Quiz("Which Java keyword is used to define a subclass?", "extends", "implements", "super", "extends"));
        ajoutQuiz(new Quiz("What does the 'super' keyword refer to in Java?", "Base class object", "Derived class object", "Current class object", "Base class object"));
        ajoutQuiz(new Quiz("Which of the following is not a primitive data type in Java?", "int", "boolean", "String", "String"));
        ajoutQuiz(new Quiz("What is the size of 'int' datatype in Java?", "4 bytes", "8 bytes", "Depends on the platform", "4 bytes"));
        ajoutQuiz(new Quiz("Which method is invoked when an object is created?", "start()", "run()", "constructor", "constructor"));
        ajoutQuiz(new Quiz("What does JVM stand for?", "Java Virtual Machine", "Java Virtual Memory", "Java Visual Machine", "Java Virtual Machine"));
        ajoutQuiz(new Quiz("Which operator is used to compare two values for equality in Java?", "==", "=", "===", "=="));
        ajoutQuiz(new Quiz("What is the range of a byte variable in Java?", "-128 to 127", "0 to 255", "-32768 to 32767", "-128 to 127"));
        ajoutQuiz(new Quiz("What is the correct way to declare a constant in Java?", "final int MAX_VALUE = 100;", "const MAX_VALUE = 100;", "int constant MAX_VALUE = 100;", "final int MAX_VALUE = 100;"));
        ajoutQuiz(new Quiz("Which exception is thrown when an array is accessed with an illegal index?", "ArrayIndexOutOfBoundsException", "IndexOutOfBoundsException", "IllegalStateException", "ArrayIndexOutOfBoundsException"));
        ajoutQuiz(new Quiz("Which loop is guaranteed to execute at least once in Java?", "for loop", "while loop", "do-while loop", "do-while loop"));
        ajoutQuiz(new Quiz("Which keyword is used to define methods that do not return a value?", "void", "null", "None of the above", "void"));
        ajoutQuiz(new Quiz("What does the 'this' keyword refer to in Java?", "Current object", "Parent object", "Child object", "Current object"));
        ajoutQuiz(new Quiz("Which of the following is a marker interface in Java?", "Runnable", "Serializable", "Cloneable", "Serializable"));
        ajoutQuiz(new Quiz("What does the 'break' statement do in Java?", "Exits the current loop or switch statement", "Skips the next iteration of the loop", "Continues to the next iteration of the loop", "Exits the current loop or switch statement"));
        ajoutQuiz(new Quiz("What is the purpose of 'finally' block in Java exception handling?", "To clean up resources", "To execute code regardless of exception", "To specify code that handles exception", "To execute code regardless of exception"));
        ajoutQuiz(new Quiz("What does the 'default' case in a switch statement do in Java?", "Handles all unspecified cases", "Handles the default case", "Throws an exception", "Handles the default case"));
        ajoutQuiz(new Quiz("Which access modifier allows a class to be accessed only within the same package?", "public", "private", "protected", "default"));
        ajoutQuiz(new Quiz("Which method is used to explicitly allocate memory to an object in Java?", "malloc()", "allocate()", "new", "new"));
        ajoutQuiz(new Quiz("Which of the following is an example of a checked exception in Java?", "NullPointerException", "ArrayIndexOutOfBoundsException", "IOException", "IOException"));
        ajoutQuiz(new Quiz("What does the 'transient' keyword do in Java?", "Prevents serialization of a member variable", "Enforces atomicity of a method", "Indicates that a method cannot be overridden", "Prevents serialization of a member variable"));
        ajoutQuiz(new Quiz("Which interface must be implemented by a class to be used as a key in a HashMap?", "Comparable", "Cloneable", "Serializable", "Comparable"));
        ajoutQuiz(new Quiz("What is the difference between '==', '.equals()', and 'hashCode()' methods in Java?", "They compare references, values, and hash codes respectively", "They are synonyms and can be used interchangeably", "They are used for conditional statements", "They compare references, values, and hash codes respectively"));
        ajoutQuiz(new Quiz("What is the purpose of 'static' keyword in Java?", "To define a class that cannot be instantiated", "To define variables and methods that belong to the class, rather than instances of the class", "To define a method that cannot be overridden", "To define variables and methods that belong to the class, rather than instances of the class"));
        ajoutQuiz(new Quiz("What does the 'volatile' keyword do in Java?", "Ensures visibility of changes to a variable across threads", "Prevents the variable from being modified", "Prevents the variable from being accessed by multiple threads", "Ensures visibility of changes to a variable across threads"));
        ajoutQuiz(new Quiz("What is the purpose of 'abstract' keyword in Java?", "To define a class that cannot be instantiated", "To define methods without providing implementation", "To define a method that cannot be overridden", "To define methods without providing implementation"));
        ajoutQuiz(new Quiz("Which statement is used to terminate the execution of a method in Java?", "break", "exit", "return", "return"));
        ajoutQuiz(new Quiz("What is the purpose of 'instanceof' operator in Java?", "To compare two objects", "To check if an object belongs to a particular class", "To instantiate an object", "To check if an object belongs to a particular class"));
        ajoutQuiz(new Quiz("Which method is used to convert a primitive data type to a string in Java?", "toString()", "parse()", "valueOf()", "toString()"));
        ajoutQuiz(new Quiz("What is the purpose of 'final' keyword in Java?", "To define a class that cannot be extended", "To define a method that cannot be overridden", "To define constants", "To define constants"));
        ajoutQuiz(new Quiz("What does the 'throws' clause indicate in a method declaration in Java?", "The method might throw an exception", "The method must throw an exception", "The method does not throw any exception", "The method might throw an exception"));
        ajoutQuiz(new Quiz("What is the purpose of 'interface' in Java?", "To define a blueprint of a class", "To define a class that cannot be instantiated", "To define variables and methods that belong to the class, rather than instances of the class", "To define a blueprint of a class"));
        ajoutQuiz(new Quiz("What is the purpose of 'static block' in Java?", "To initialize static variables of a class", "To define a method that cannot be overridden", "To define variables and methods that belong to the class, rather than instances of the class", "To initialize static variables of a class"));
        ajoutQuiz(new Quiz("What is the purpose of 'try-catch' block in Java?", "To clean up resources", "To handle exceptions", "To execute code regardless of exception", "To handle exceptions"));
        ajoutQuiz(new Quiz("What does the 'protected' access modifier do in Java?", "Allows access only within the same package", "Allows access from any class in the same package and subclasses", "Allows access from any class in the same package", "Allows access from any class in the same package and subclasses"));
        ajoutQuiz(new Quiz("What is the purpose of 'this()' constructor call in Java?", "To call the superclass constructor", "To call another constructor of the same class", "To call a static method", "To call another constructor of the same class"));
        ajoutQuiz(new Quiz("What is the purpose of 'package' keyword in Java?", "To define a namespace of classes and interfaces", "To define a class that cannot be instantiated", "To define constants", "To define a namespace of classes and interfaces"));
        ajoutQuiz(new Quiz("What is the purpose of 'package-private' access modifier in Java?", "Allows access only within the same package", "Allows access from any class in the same package and subclasses", "Allows access from any class in the same package", "Allows access only within the same package"));
        ajoutQuiz(new Quiz("Which statement is used to skip the current iteration of a loop in Java?", "continue", "break", "return", "continue"));
        ajoutQuiz(new Quiz("What is the purpose of 'enum' in Java?", "To define a fixed set of constants", "To define a class that cannot be instantiated", "To define variables and methods that belong to the class, rather than instances of the class", "To define a fixed set of constants"));
        ajoutQuiz(new Quiz("What is the purpose of 'static import' in Java?", "To access static members of a class directly", "To prevent subclassing of a class", "To import a package", "To access static members of a class directly"));
        ajoutQuiz(new Quiz("What is the purpose of 'interface default methods' introduced in Java 8?", "To provide a default implementation in interfaces", "To override default methods in subclasses", "To define variables and methods that belong to the class, rather than instances of the class", "To provide a default implementation in interfaces"));
        ajoutQuiz(new Quiz("What is the purpose of 'lambda expressions' in Java?", "To provide a concise way to represent anonymous functions", "To prevent subclassing of a class", "To define variables and methods that belong to the class, rather than instances of the class", "To provide a concise way to represent anonymous functions"));
        ajoutQuiz(new Quiz("What is the purpose of 'method reference' in Java?", "To refer to methods or constructors using concise syntax", "To define a method that cannot be overridden", "To import a package", "To refer to methods or constructors using concise syntax"));
        ajoutQuiz(new Quiz("What is the purpose of 'instance initialization block' in Java?", "To initialize instance variables of a class", "To define a method that cannot be overridden", "To initialize static variables of a class", "To initialize instance variables of a class"));
        ajoutQuiz(new Quiz("What does the 'strictfp' keyword do in Java?", "Ensures platform-independent floating-point arithmetic", "Prevents subclassing of a class", "Indicates that a method cannot be overridden", "Ensures platform-independent floating-point arithmetic"));
        ajoutQuiz(new Quiz("What is the purpose of 'assert' statement in Java?", "To check assumptions about program behavior", "To terminate the execution of a program", "To define variables and methods that belong to the class, rather than instances of the class", "To check assumptions about program behavior"));
        ajoutQuiz(new Quiz("What is the purpose of 'enhanced for loop' (for-each loop) in Java?", "To iterate over elements of arrays and collections", "To prevent subclassing of a class", "To iterate over a fixed range of numbers", "To iterate over elements of arrays and collections"));
        ajoutQuiz(new Quiz("What is the purpose of 'StringBuffer' and 'StringBuilder' classes in Java?", "To create mutable string objects", "To prevent subclassing of a class", "To define variables and methods that belong to the class, rather than instances of the class", "To create mutable string objects"));
        ajoutQuiz(new Quiz("What is the purpose of 'autoboxing' and 'unboxing' in Java?", "To automatically convert primitive types to wrapper types and vice versa", "To prevent subclassing of a class", "To define variables and methods that belong to the class, rather than instances of the class", "To automatically convert primitive types to wrapper types and vice versa"));
        ajoutQuiz(new Quiz("What is the purpose of 'varargs' (variable-length arguments) in Java?", "To pass a variable number of arguments to a method", "To prevent subclassing of a class", "To define variables and methods that belong to the class, rather than instances of the class", "To pass a variable number of arguments to a method"));
        ajoutQuiz(new Quiz("What is the purpose of 'try-with-resources' statement in Java?", "To automatically close resources after use", "To handle exceptions", "To define variables and methods that belong to the class, rather than instances of the class", "To automatically close resources after use"));
         ajoutQuiz(new Quiz("What is the purpose of 'transient' keyword in Java?", "To indicate that a variable should not be serialized", "To prevent a class from being subclassed", "To define a constant", "To indicate that a variable should not be serialized"));
        ajoutQuiz(new Quiz("What is the purpose of 'interface default methods' introduced in Java 8?", "To provide a default implementation in interfaces", "To override default methods in subclasses", "To define variables and methods that belong to the class, rather than instances of the class", "To provide a default implementation in interfaces"));
        ajoutQuiz(new Quiz("What is the purpose of 'instance initialization block' in Java?", "To initialize instance variables of a class", "To define a method that cannot be overridden", "To initialize static variables of a class", "To initialize instance variables of a class"));
        ajoutQuiz(new Quiz("What does the 'strictfp' keyword do in Java?", "Ensures platform-independent floating-point arithmetic", "Prevents subclassing of a class", "Indicates that a method cannot be overridden", "Ensures platform-independent floating-point arithmetic"));
        ajoutQuiz(new Quiz("What is the output of the following code?\nString s = \"Java\";\nSystem.out.println(s.substring(0, 2));", "Ja", "v", "va", "Ja"));
        ajoutQuiz(new Quiz("What is the purpose of 'assert' statement in Java?", "To check assumptions about program behavior", "To terminate the execution of a program", "To define variables and methods that belong to the class, rather than instances of the class", "To check assumptions about program behavior"));
        ajoutQuiz(new Quiz("What is the purpose of 'enhanced for loop' (for-each loop) in Java?", "To iterate over elements of arrays and collections", "To prevent subclassing of a class", "To iterate over a fixed range of numbers", "To iterate over elements of arrays and collections"));
        ajoutQuiz(new Quiz("What is the purpose of 'StringBuffer' and 'StringBuilder' classes in Java?", "To create mutable string objects", "To prevent subclassing of a class", "To define variables and methods that belong to the class, rather than instances of the class", "To create mutable string objects"));
        ajoutQuiz(new Quiz("What is the purpose of 'autoboxing' and 'unboxing' in Java?", "To automatically convert primitive types to wrapper types and vice versa", "To prevent subclassing of a class", "To define variables and methods that belong to the class, rather than instances of the class", "To automatically convert primitive types to wrapper types and vice versa"));
        ajoutQuiz(new Quiz("What is the purpose of 'varargs' (variable-length arguments) in Java?", "To pass a variable number of arguments to a method", "To prevent subclassing of a class", "To define variables and methods that belong to the class, rather than instances of the class", "To pass a variable number of arguments to a method"));
        ajoutQuiz(new Quiz("What is the purpose of 'try-with-resources' statement in Java?", "To automatically close resources after use", "To handle exceptions", "To define variables and methods that belong to the class, rather than instances of the class", "To automatically close resources after use"));
        ajoutQuiz(new Quiz("What is the default value of boolean variable in Java?", "false", "true", "null", "false"));
        ajoutQuiz(new Quiz("Which data type is used to create a variable that should store text?", "String", "int", "boolean", "String"));
        ajoutQuiz(new Quiz("What is the output of the following code?\nint x = 5;\nSystem.out.println(++x);", "6", "5", "Compiler error", "6"));
        ajoutQuiz(new Quiz("What is the output of the following code?\nString s1 = \"Hello\";\nString s2 = new String(\"Hello\");\nSystem.out.println(s1 == s2);", "false", "true", "Compiler error", "false"));
        ajoutQuiz(new Quiz("What is the result of 10 % 3 in Java?", "1", "0", "3", "1"));
        ajoutQuiz(new Quiz("What is the result of the expression (5 > 3 && 8 < 5)?", "false", "true", "Compiler error", "false"));
        ajoutQuiz(new Quiz("What does the 'static' keyword mean in Java?", "The variable or method belongs to the class, rather than instances of the class", "The variable or method belongs to instances of the class", "The variable or method cannot be changed", "The variable or method belongs to the class, rather than instances of the class"));
        ajoutQuiz(new Quiz("Which keyword is used to prevent method overriding in Java?", "final", "static", "abstract", "final"));
        ajoutQuiz(new Quiz("What is the output of the following code?\nint[] numbers = {1, 2, 3};\nfor(int i : numbers) {\n  System.out.print(i + \" \");\n}", "1 2 3", "1, 2, 3", "123", "1 2 3"));
        ajoutQuiz(new Quiz("What is the purpose of 'StringBuilder' class in Java?", "To create mutable sequences of characters", "To define a constant", "To prevent a class from being subclassed", "To create mutable sequences of characters"));
        ajoutQuiz(new Quiz("How can you convert a String to an int in Java?", "Integer.parseInt()", "String.valueOf()", "int.parse()", "Integer.parseInt()"));
        ajoutQuiz(new Quiz("What is the purpose of 'try', 'catch', and 'finally' blocks in Java?", "To handle exceptions and cleanup resources", "To define a constant", "To prevent a class from being subclassed", "To handle exceptions and cleanup resources"));
        ajoutQuiz(new Quiz("What is the purpose of 'throw' keyword in Java?", "To explicitly throw an exception", "To define a constant", "To prevent a class from being subclassed", "To explicitly throw an exception"));
        ajoutQuiz(new Quiz("What is the purpose of 'throws' keyword in Java?", "To declare that a method may throw exceptions", "To define a constant", "To prevent a class from being subclassed", "To declare that a method may throw exceptions"));
        ajoutQuiz(new Quiz("What is the purpose of 'assert' statement in Java?", "To assert a condition true during program execution", "To define a constant", "To prevent a class from being subclassed", "To assert a condition true during program execution"));
        ajoutQuiz(new Quiz("What is the purpose of 'enum' in Java?", "To define a set of named constants", "To define a constant", "To prevent a class from being subclassed", "To define a set of named constants"));
        ajoutQuiz(new Quiz("What is the purpose of 'package' in Java?", "To organize classes and interfaces", "To define a constant", "To prevent a class from being subclassed", "To organize classes and interfaces"));
        ajoutQuiz(new Quiz("What is the purpose of 'import' statement in Java?", "To access classes from other packages", "To define a constant", "To prevent a class from being subclassed", "To access classes from other packages"));
        ajoutQuiz(new Quiz("What is the purpose of 'break' statement in Java?", "To exit from a loop or switch statement", "To define a constant", "To prevent a class from being subclassed", "To exit from a loop or switch statement"));
        ajoutQuiz(new Quiz("What is the purpose of 'continue' statement in Java?", "To skip the current iteration of a loop and continue with the next iteration", "To define a constant", "To prevent a class from being subclassed", "To skip the current iteration of a loop and continue with the next iteration"));
        ajoutQuiz(new Quiz("What is the purpose of 'return' statement in Java?", "To exit from a method and optionally return a value", "To define a constant", "To prevent a class from being subclassed", "To exit from a method and optionally return a value"));
        ajoutQuiz(new Quiz("What is the purpose of 'final' keyword in Java?", "To prevent a class from being subclassed and to declare constants", "To define a constant", "To prevent a class from being subclassed", "To prevent a class from being subclassed and to declare constants"));
        ajoutQuiz(new Quiz("What is the purpose of 'synchronized' keyword in Java?", "To ensure only one thread accesses a method at a time", "To define a constant", "To prevent a class from being subclassed", "To ensure only one thread accesses a method at a time"));
        ajoutQuiz(new Quiz("What is the purpose of 'interface' in Java?", "To define a contract for classes that implement it", "To define a constant", "To prevent a class from being subclassed", "To define a contract for classes that implement it"));
        ajoutQuiz(new Quiz("What is the purpose of 'default' keyword in Java?", "To provide a default implementation in interfaces", "To define a constant", "To prevent a class from being subclassed", "To provide a default implementation in interfaces"));
        ajoutQuiz(new Quiz("What is the purpose of 'method overloading' in Java?", "To define multiple methods with the same name but different parameters", "To define a constant", "To prevent a class from being subclassed", "To define multiple methods with the same name but different parameters"));
        ajoutQuiz(new Quiz("What is the purpose of 'method overriding' in Java?", "To provide a specific implementation of a method in a subclass", "To define a constant", "To prevent a class from being subclassed", "To provide a specific implementation of a method in a subclass"));
        ajoutQuiz(new Quiz("What is the purpose of 'constructor chaining' in Java?", "To invoke one constructor from another in the same class", "To define a constant", "To prevent a class from being subclassed", "To invoke one constructor from another in the same class"));
        ajoutQuiz(new Quiz("What is the default value of boolean variable in Java?", "false", "true", "null", "false"));
        ajoutQuiz(new Quiz("Which data type is used to create a variable that should store text?", "String", "int", "boolean", "String"));
        ajoutQuiz(new Quiz("What is the result of 10 % 3 in Java?", "1", "0", "3", "1"));
        ajoutQuiz(new Quiz("What is the result of the expression (5 > 3 && 8 < 5)?", "false", "true", "Compiler error", "false"));
        ajoutQuiz(new Quiz("What does the 'static' keyword mean in Java?", "The variable or method belongs to the class, rather than instances of the class", "The variable or method belongs to instances of the class", "The variable or method cannot be changed", "The variable or method belongs to the class, rather than instances of the class"));
        ajoutQuiz(new Quiz("Which keyword is used to prevent method overriding in Java?", "final", "static", "abstract", "final"));
        ajoutQuiz(new Quiz("What is the purpose of 'StringBuilder' class in Java?", "To create mutable sequences of characters", "To define a constant", "To prevent a class from being subclassed", "To create mutable sequences of characters"));
        ajoutQuiz(new Quiz("How can you convert a String to an int in Java?", "Integer.parseInt()", "String.valueOf()", "int.parse()", "Integer.parseInt()"));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            db.execSQL("DROP TABLE IF EXISTS " + "Quiz");

            onCreate(db);

    }


    public void ajoutQuiz(Quiz q){

        ContentValues valeurs = new ContentValues();
        valeurs.putNull("_id");
        valeurs.put("question", q.getQuestion());
        valeurs.put("reponse1", q.getReponse1());
        valeurs.put("reponse2", q.getReponse2());
        valeurs.put("reponse3", q.getReponse3());
        valeurs.put("bonnereponse", q.getBonneReponse());
        db.insert("Quiz", null, valeurs);

    }
    public void updateQuiz(Quiz q){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valeurs = new ContentValues();
        valeurs.put("question", q.getQuestion());
        valeurs.put("reponse1", q.getReponse1());
        valeurs.put("reponse2", q.getReponse2());
        valeurs.put("reponse3", q.getReponse3());
        valeurs.put("bonnereponse", q.getBonneReponse());
        db.update( "Quiz", valeurs, "_id=?", new String[] { q.getId()});
    }
    public void deteleQuiz(Quiz q){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("Quiz", "_id BETWEEN ? AND ?", new String[]{"5","8"});
    }
    public List<Quiz> afficheQuiz() {

        List<Quiz> quizList = new ArrayList<Quiz>();
        SQLiteDatabase db=getReadableDatabase();

        String selectQuery = "SELECT * FROM Quiz" ;
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Quiz q = new Quiz();
                q.setId(cursor.getString(0));
                q.setQuestion(cursor.getString(1));
                q.setReponse1(cursor.getString(2));
                q.setReponse2(cursor.getString(3));
                q.setReponse3(cursor.getString(4));
                q.setBonneReponse(cursor.getString(5));
                quizList.add(q);
            } while (cursor.moveToNext());
        }
        Collections.shuffle(quizList);
        return quizList;
    }
}
