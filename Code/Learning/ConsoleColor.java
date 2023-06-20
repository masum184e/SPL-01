public class ConsoleColor {
    public static void main(String[] args) {
        System.out.println("\033[31m" + "Hello, world!" + "\033[0m");//Hello, world! in red
        System.out.println("\033[31m" + "Hello, world!");//Hello, world! and ending path in red
        System.out.println("Hello, world!" + "\033[0m");//Hello, world! and begining path in red
    }
}

// Black: \033[30m
// Red: \033[31m
// Green: \033[32m
// Yellow: \033[33m
// Blue: \033[34m
// Purple: \033[35m
// Cyan: \033[36m
// White: \033[37m
