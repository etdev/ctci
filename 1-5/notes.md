### The problem
Create an algorithm to compress a string based on repeated character counts.
E.g. the string ``aabcccccaaa`` would become ``a2b1c5a3``.  Only compress a
string if it actually becomes smaller as a result.
### Initial algorithm attempt
```java
public static String compressString(String str) {
  if (str == null) { return null; }
  if (str.length() < 3) { return str; }
  String newStr = "";
  int sameCount = 0;
  char currentChar = "\0";

  for(int i=0; i<str.length(); i++) {
    if(str.charAt(i) == currentChar) {
      sameCount++;
    }
    else {
      newStr += (currentChar + "" + sameCount);
      currentChar = str.charAt(i);
      sameCount = 1;
    }
    if (newStr.length() >= str.length() {
      return str;
    }
  }
  return newStr;
}
```

### Iteration #1
```java
```

### Final algorithm
```java
```

### Tests
```java
```

### Thoughts
* You have to use single quotes around ``char`` variables in Java.
* You can't initialize ``char`` objects to empty like you can with ``Strings``.
* It's not good to set a default value for ``currentChar`` though I don't think.
You could set it to the first character in the String and then iterate starting
at 1 though.  Or you could set it to the current character if ``i==0`` or
something.
