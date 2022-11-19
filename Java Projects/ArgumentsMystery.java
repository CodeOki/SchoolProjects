public class ArgumentsMystery {
public static void main(String[] args) {
int num0 = Integer.parseInt(args[0]);
int num1 = Integer.parseInt(args[1]);
int num2 = Integer.parseInt(args[1]);
int result = (num0 ^ num1 << num2) + 2;
System.out.println(result);
}
}