class CharStack {
  private char[] stack;
  private int top;
  private int capacity;

  public CharStack(int size) {
    stack = new char[size];
    top = -1;
    capacity = size;
  }

  public boolean isEmpty() {
    return top == -1;
  }

  public int size() {
    return top + 1;
  }

  public char getTop() {
    if (isEmpty())
      return '\0';
    return stack[top];
  }

  public void push(char c) {
    if (top == capacity - 1)
      return;
    stack[++top] = c;
  }

  public char pop() {
    if (isEmpty())
      return '\0';
    return stack[top--];
  }
}

public class RomanToInteger {
  public int romanToInt(String s) {
    CharStack stack = new CharStack(s.length());

    int totalCount = 0;

    for (int i = 0; i < s.length(); i++)
      stack.push(s.charAt(i));

    while (!stack.isEmpty()) {
      int currentCount = 0;
      char topChar = Character.toUpperCase(stack.pop());

      switch (topChar) {
      case 'I':
        currentCount = 1;
        break;
      case 'V':
        currentCount = 5;
        if (stack.getTop() == 'I') {
          currentCount = 4;
          stack.pop();
        }
        break;
      case 'X':
        currentCount = 10;
        if (stack.getTop() == 'I') {
          currentCount = 9;
          stack.pop();
        }
        break;
      case 'L':
        currentCount = 50;
        if (stack.getTop() == 'X') {
          currentCount = 40;
          stack.pop();
        }
        break;
      case 'C':
        currentCount = 100;
        if (stack.getTop() == 'X') {
          currentCount = 90;
          stack.pop();
        }
        break;
      case 'D':
        currentCount += 500;
        if (stack.getTop() == 'C') {
          currentCount = 400;
          stack.pop();
        }
        break;
      case 'M':
        currentCount = 1000;
        if (stack.getTop() == 'C') {
          currentCount = 900;
          stack.pop();
        }
        break;
      default:
        break;
      }

      totalCount += currentCount;
    }

    return totalCount;

  }

  public static void main(String[] args) {
    RomanToInteger rti = new RomanToInteger();

    int case1Results = rti.romanToInt("III");
    int case2Results = rti.romanToInt("LVIII");
    int case3Results = rti.romanToInt("MCMXCIV");
    int case4Results = rti.romanToInt("IX");

    System.out.println(case1Results);
    System.out.println(case2Results);
    System.out.println(case3Results);
    System.out.println(case4Results);
  }
}
