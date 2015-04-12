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
This code runs, but doesn't yield the correct answer.  For example ``aabcccccaaa`` gives the answer ``0a2b1c5``.  This is because the logic in my ``else`` inside the ``for`` is faulty. When i is 0, currentChar isn't set, so in this special case we need to set it to the first character of the string.  I'm thinking it would be better to do this at the beginning and then start the loop at 1.

### Iteration #1
```java
public static String compressString(String str) {
  if (str == null) { return null; }
  if (str.length() < 3) { return str; }
  char currentChar = str.charAt(0);
  String newStr = "";
  int sameCount = 1;
  for (int i=1; i<str.length(); i++) {
    if (str.charAt(i) == currentChar) {
      sameCount++;
    }
    else {
      newStr += currentChar + "" + sameCount;
      currentChar = str.charAt(i);
      sameCount = 1;
    }
    if (newStr.length() >= str.length()) {
      return str; 
    }
  }
  newStr += currentChar + "" + sameCount;
  return newStr;
}
```
This works, but it's slow.  I peaked at the solution in the book and the author
uses a ``Stringbuffer`` to make it faster.  I'm going to try that.  I'm also
going to try writing a method to go through and check the length of the
"compressed" string at the beginning.


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
something.  Just getting to that code means that the character has to be at
least 3 characters long, so I think this is a safe thing to do.
* What's the deal with adding a char to an empty string?  Is ``String newStr =
"" + currentChar`` a reasonable way to do it?
* `` newStr += currentChar + "" + sameCount;`` same question with this line.
* For me the keys to this problem were the realization that you ned to add
``currentChar + "" + sameCount`` once more at the end, and the fact that you
have to deal with the edge case of the first element, but to not populate the
initial newString with the fir st character.
* Just don't forget that extra ``currentChar + "" + sameCount`` at the end.  I
kept forgetting that when trying to write it on paper.  I also need to
familiarize myself better with the rules for ``<String> + <char> + <int>`` like
situations and what happens with string conversion etc.
* The Java ``StringBuffer`` class allows you to do String concatenation much faster than with the String class.  Whenever you're adding two strings together, that's a ``O(n^2)`` operation.
