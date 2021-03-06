package lambda;

import java.util.function.Function;

import org.junit.jupiter.api.Test;

public class LambdaTest {

  @Test
  public void lambdaTest() {
    MyLambda myLambda = parameter -> parameter + " from myLambda";
    String result = UseLambda.add("Message ", myLambda);
    System.out.println("1 --- " + result);

    Function<String, String> fn = parameter -> parameter + " from function";
    result = UseLambda.add("Message ", fn);

    System.out.println("2 --- " + result);

    Function<String, String> fn3 = LambdaTest::createMessage;
    //Function<String, String> fn3 = parameter -> createMessage(parameter);
    result = UseLambda.add("Message ", fn3);

    System.out.println("3 --- " + result);

    Bar babar = Foo::method;
    //Bar bar = parameter -> Foo.method(parameter);
    UseLambda.execute("you", babar);

    Function<String, Foo> createMe = Foo::method;
    Function<String, Foo> bar = methodTakingFunctionAsParameter(createMe);
    bar.apply("from a method");

    System.out.println("1234567".substring("1234567".length() - 1));
  }

  private static String createMessage(final String parameter) {
    return parameter + " from method";
  }

  private static Function<String, Foo> methodTakingFunctionAsParameter(Function<String, Foo> function) {
    return function;
  }

}
