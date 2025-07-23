class CharStack {
  private char[] stack;
  private int capacity;
  private int top;

  public CharStack(int size) {
    stack = new char[size];
    capacity = size;
    top = -1;
  }

  public boolean isEmpty() {
    return top == -1;
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

public class ValidParentheses {
  public boolean isValid(String s) {
    if (s.length() < 1)
      return true;

    CharStack stack = new CharStack(s.length());

    for (int i = 0; i < s.length(); i++) {
      char parentheses = s.charAt(i);

      switch (parentheses) {
      case '(':
      case '{':
      case '[':
        stack.push(parentheses);
        break;
      case ')':
        if (stack.pop() != '(')
          return false;
        break;
      case '}':
        if (stack.pop() != '{')
          return false;
        break;
      case ']':
        if (stack.pop() != '[')
          return false;
        break;
      default:
        break;
      }
    }

    if (stack.isEmpty())
      return true;
    else
      return false;
  }

  public static void main(String[] args) {
    ValidParentheses vp = new ValidParentheses();

    boolean case0Result = vp.isValid("");
    boolean case1Result = vp.isValid("()");
    boolean case2Result = vp.isValid("()[]{}");
    boolean case3Result = vp.isValid("(]");
    boolean case4Result = vp.isValid("([])");
    boolean case5Result = vp.isValid("([)]");

    System.out.println(case0Result);
    System.out.println(case1Result);
    System.out.println(case2Result);
    System.out.println(case3Result);
    System.out.println(case4Result);
    System.out.println(case5Result);
  }
}
